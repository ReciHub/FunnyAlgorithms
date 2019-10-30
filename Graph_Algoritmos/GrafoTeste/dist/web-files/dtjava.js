/*
 * Copyright (c) 2006, 2016, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
  The Java Deployment Toolkit is a utility to deploy Java content in
  the browser as applets or applications using the right version of Java.
  If needed it can initiate an upgrade of user's system to install required
  components of Java platform.
  <p>
  Note that some of the Deployment Toolkit methods may not be fully operational if
  used before web page body is loaded (because DT native plugins could not be instantiated).
  If you intend to use it before web page DOM tree is ready then dtjava.js
  needs to be loaded inside the body element of the page and before use of other DT APIs.

  @module java/deployment_toolkit
*/
var dtjava = function() {
    function notNull(o) {
        return (o != undefined && o != null);
    }

    function isDef(fn) {
        return (fn != null && typeof fn != "undefined");
    }

    //return true if any of patterns from query list is found in the given string
    function containsAny(lst, str) {
        for (var q = 0; q < lst.length; q++) {
            if (str.indexOf(lst[q]) != -1) {
                return true;
            }
        }
        return false;
    }

    /* Location of static web content - images, javascript files. */
    var jscodebase =  (function () {
        // <script> elements are added to the DOM and run synchronously,
        // the currently running script will also be the last element in the array
        var scripts = document.getElementsByTagName("script");
        var src = scripts[scripts.length - 1].getAttribute("src");
        return src ? src.substring(0, src.lastIndexOf('/') + 1) : "";
    })();

    //set to true to disable FX auto install (before release)
    var noFXAutoInstall = false;

    // page has no body yet, postpone plugin installation
    postponeNativePluginInstallation = false;

    // JRE version we start to have JRE and FX true co-bundle
    var minJRECobundleVersion = "1.7.0_06";

    //aliases
    var d = document;
    var w = window;

    var cbDone = false;  //done with onload callbacks
    var domInternalCb = []; //list of internal callbacks
    var domCb = [];      //list of callbacks
    var ua = null;


    // Add internal function to be called on DOM ready event.
    // These functions will be called before functions added by addOnDomReady().
    // Used to do internal initialization (installing native plug-in) to avoid
    // race condition with user requests.
    function addOnDomReadyInternal(fn) {
        if (cbDone) {
            fn();
        } else {
            domInternalCb[domInternalCb.length] = fn;
        }
    }

    // add function to be called on DOM ready event
    function addOnDomReady(fn) {
        if (cbDone) {
            fn();
        } else {
            domCb[domCb.length] = fn;
        }
    }

    //invoke pending onload callbacks
    function invokeCallbacks() {
        if (!cbDone) {
            //swfoject.js tests whether DOM is actually ready first
            //  in order to not fire too early. Use same heuristic
            try {
                var t = d.getElementsByTagName("body")[0].appendChild(
                    d.createElement("div"));
                t.parentNode.removeChild(t);
            } catch (e) {
                return;
            }
            cbDone = true;
            for (var i = 0; i < domInternalCb.length; i++) {
                domInternalCb[i]();
            }
            for (var i = 0; i < domCb.length; i++) {
                domCb[i]();
            }
        }
    }

    //cross browser onload support.
    //Derived from swfobject.js
    function addOnload(fn) {
        if (isDef(w.addEventListener)) {
            w.addEventListener("load", fn, false);
        } else if (isDef(d.addEventListener)) {
            d.addEventListener("load", fn, false);
        } else if (isDef(w.attachEvent)) {
            w.attachEvent("onload", fn);
            //TODO: swfobject also keeps references to the listeners to detach them on onload
            // to avoid memory leaks ...
        } else if (typeof w.onload == "function") {
            var fnOld = w.onload;
            w.onload = function() {
                fnOld();
                fn();
            };
        } else {
            w.onload = fn;
        }
    }

    function detectEnv() {
        var dom = isDef(d.getElementById) && isDef(d.getElementsByTagName) && isDef(d.createElement);
        var u = navigator.userAgent.toLowerCase(),
            p = navigator.platform.toLowerCase();

        //NB: may need to be refined as some user agent may contain strings related to other browsers
        //   (e.g. Chrome has both Safari and mozilla, Safari also has mozilla
        var windows = p ? /win/.test(p) : /win/.test(u),
            mac = p ? /mac/.test(p) : /mac/.test(u),
            linux = p ? /linux/.test(p) : /linux/.test(u),
            chrome = /chrome/.test(u),
            // get webkit version or false if not webkit
            webkit = !chrome && /webkit/.test(u) ?
                parseFloat(u.replace(/^.*webkit\/(\d+(\.\d+)?).*$/, "$1")) : false,
            opera = /opera/.test(u),
            cputype = null,
            osVersion = null;

        var ie = false;
        try {
            //Used to be using trick from
            //  http://webreflection.blogspot.com/2009/01/32-bytes-to-know-if-your-browser-is-ie.html
            //ie = !+"\v1",
            //but it does not work with IE9 in standards mode
            //Reverting to alternative - use execScript
            ie = isDef(window.execScript);
            // IE 11 does not support execScript any more and no exception is thrown, so lets use more naive test.
            // http://msdn.microsoft.com/en-us/library/ie/bg182625(v=vs.85).aspx
            if (!ie) { // We do not want to overwrite if ie was detected above.
                ie = (navigator.userAgent.match(/Trident/i) != null);
            }
        } catch (ee) {
            //if javafx app is in the iframe and content of main window is coming from other domain
            //  then some browsers may restrict access to outer window properties,
            //  e.g. FF can throw exception for top.execScript (see RT-17885)
            //We could revert to more naive test, e.g. test user agent for "MSIE " string
            // but so far IE does not seem to throw exception => if we get here it is not IE anyways
            ie = false;
        }

        var edge = false;
        var noActiveX = false;
        edge = (navigator.userAgent.match(/Edge/i) != null);
        
        // If IE and Windows 8 or Windows 8.1 then check for Metro mode
        if(ie && navigator.userAgent.match(/Windows NT 6\.[23]/i) != null) {
            try {
                // try to create a known ActiveX object
                new ActiveXObject("htmlfile");
            } catch(e) {
		// ActiveX is disabled or not supported. 
                noActiveX = true;
            } 
        }

        if(edge || noActiveX) {
            ie = false;
	}

	var noPluginWebBrowser = edge || chrome || noActiveX;

        //we are not required to detect everything and can leave values null as
        // long as we later treat them accordingly.
        //We use "cputype" to detect if given hardware is supported,
        // e.g. we do not support PPC or iPhone/iPad despite they are running Mac OS
        //We use "osVersion" to detect if Java/JavaFX can be installed on this OS
        // e.g. Oracle Java for Mac requires 10.7.3
        if (mac) {
            if ((p && /intel/.test(p)) || /intel/.test(u)) {
                cputype = "intel";
            }
            //looking for things like 10_7, 10_6_8, 10.4 in the user agent
            var t = u.match(/mac os x (10[0-9_\.]+)/);
            //normalize to "." separators
            osVersion = notNull(t) ? t[0].replace("mac os x ","").replace(/_/g, ".") : null;
        }

        // trim() is not supported by IE10 and before
        if(typeof String.prototype.trim !== 'function') {
           String.prototype.trim = function() {
               return this.replace(/^\s+|\s+$/g, ''); 
           }
        }

        // startsWith() is not supported by IE
        if(typeof String.prototype.startsWith !== 'function') {
           String.prototype.startsWith = function(searchString, position) {
               position = position || 0;
               return this.indexOf(searchString, position) === position;
           }
        }


        // Check mime types. Works with netscape family browsers and checks latest installed plugin only
        var mm = navigator.mimeTypes;
        var jre = null;
        var deploy = null;
        var fx = null;
        var override = false;

        if (typeof __dtjavaTestHook__ !== 'undefined' &&
            __dtjavaTestHook__ != null &&
            __dtjavaTestHook__.jre != null &&
            __dtjavaTestHook__.jfx != null &&
            __dtjavaTestHook__.deploy != null) {
            jre = __dtjavaTestHook__.jre;
            deploy = __dtjavaTestHook__.deploy;
            fx = __dtjavaTestHook__.jfx;
            override = true;
        }
        else {
            //Cache configuration from plugin mimetypes
            //It is only available for NPAPI browsers
            for (var t = 0; t < mm.length; t++) {
                // The jpi-version is the JRE version.
                var m = navigator.mimeTypes[t].type;
                if (m.indexOf("application/x-java-applet;version") != -1 && m.indexOf('=') != -1) {
                    var v = m.substring(m.indexOf('=') + 1);
                    // Use the existing version comparison mechanism to ensure that
                    // the latest JRE is selected ( "versionA"<="VersionB" equals to 
                    // versionCheck("versionA+","versionB") returns "true")
                    if(jre == null || versionCheck(jre + "+", v)){
			jre = v;
	            }
                }
                //Supported for 7u6 or later
                if (m.indexOf("application/x-java-applet;deploy") != -1 && m.indexOf('=') != -1) {
                    deploy = m.substring(m.indexOf('=') + 1);
                }
                //javafx version for cobundled javafx (7u6+)
                if (m.indexOf("application/x-java-applet;javafx") != -1 && m.indexOf('=') != -1) {
                    fx = m.substring(m.indexOf('=') + 1);
                }
            }
        }
		
        return {haveDom:dom, wk:webkit, ie:ie, win:windows,
                linux:linux, mac:mac, op: opera, chrome:chrome, edge:edge,
                jre:jre, deploy:deploy, fx:fx, noPluginWebBrowser:noPluginWebBrowser,
                cputype: cputype, osVersion: osVersion, override: override};
    }

   function showMessageBox() {
        var message = 'Java Plug-in is not supported by this browser. <a href="https://java.com/dt-redirect">More info</a>';
        var mbStyle = 'background-color: #ffffce;text-align: left;border: solid 1px #f0c000; padding: 1.65em 1.65em .75em 0.5em; font-family: Helvetica, Arial, sans-serif; font-size: 75%; bottom:0; left:0; right:0; position:fixed; margin:auto; opacity:0.9; width:400px;';
        var messageStyle = "border: .85px; margin:-2.2em 0 0.55em 2.5em;";
        var closeButtonStyle = "margin-left:10px;font-weight:bold;float:right;font-size:22px;line-height:20px;cursor:pointer;color:red;"
        var messageBox = '<span style="'+ closeButtonStyle +'" onclick="this.parentElement.style.display=\'none\';">&times;</span><img src="https://java.com/js/alert_16.png"><div style="'+ messageStyle +'"><p>'+ message + '</p>';


        var divTag = document.createElement("div");
        divTag.id = "messagebox";
        divTag.setAttribute('style', mbStyle);
        divTag.innerHTML = messageBox;
        document.body.appendChild(divTag);              

    }
    //partially derived from swfobject.js
    var initDone = false;

    function init() {
        if (typeof __dtjavaTestHook__ !== 'undefined') {
          jre = null;
          jfx = null;
          deploy = null;

          if ((__dtjavaTestHook__ != null) && (__dtjavaTestHook__.args != null)) {
              jre = __dtjavaTestHook__.args.jre;
              jfx = __dtjavaTestHook__.args.jfx;
              deploy = __dtjavaTestHook__.args.deploy;
          }

          if ((window.location.href.indexOf('http://localhost') == 0) ||
             (window.location.href.indexOf('file:///') == 0)) {
             __dtjavaTestHook__ = {
                detectEnv: detectEnv,
                Version: Version,
                checkFXSupport: checkFXSupport,
                versionCheck: versionCheck,
                versionCheckFX: versionCheckFX,
                jre: jre,
                jfx: jfx,
                deploy: deploy
             };
          }
        }

        if (initDone) return;

        ua = detectEnv();
        if (!ua.haveDom) {
            return;
        }

        //NB: dtjava.js can be added dynamically and init() can be called after
        //    document onload event is fired
        if (( isDef(d.readyState) && d.readyState == "complete") ||
            (!isDef(d.readyState) &&
                (d.getElementsByTagName("body")[0] || d.body))) {
            invokeCallbacks();
        }

        if (!cbDone) {
            if (isDef(d.addEventListener)) {
                d.addEventListener("DOMContentLoaded",
                    invokeCallbacks, false);
            }
            if (ua.ie && ua.win) {
                // http://msdn.microsoft.com/en-us/library/ie/ms536343(v=vs.85).aspx
                // attachEvent is not supported by IE 11.
                if (isDef(d.addEventListener)) {
                    d.addEventListener("onreadystatechange", function() {
                        if (d.readyState == "complete") {
                            d.removeEventListener("onreadystatechange", arguments.callee, false);
                            invokeCallbacks();
                        }
                    }, false);
                } else {
                    d.attachEvent("onreadystatechange", function() {
                        if (d.readyState == "complete") {
                            d.detachEvent("onreadystatechange", arguments.callee);
                            invokeCallbacks();
                        }
                    });
                }
                if (w == top) { // if not inside an iframe
                    (function() {
                        if (cbDone) {
                            return;
                        }
                        //AI: what for??
                        try {
                            d.documentElement.doScroll("left");
                        } catch(e) {
                            setTimeout(arguments.callee, 0);
                            return;
                        }
                        invokeCallbacks();
                    })();
                }
            }
            if (ua.wk) {
                (function() {
                    if (cbDone) {
                        return;
                    }
                    if (!/loaded|complete/.test(d.readyState)) {
                        setTimeout(arguments.callee, 0);
                        return;
                    }
                    invokeCallbacks();
                })();
            }
            addOnload(invokeCallbacks);
        }
        //only try to install native plugin if we do not have DTLite
        //Practically this means we are running NPAPI browser on Windows
        //(Chrome or FF) and recent JRE (7u4+?)
        if (!haveDTLite()) {
            installNativePlugin();
        }
    }
    
   function getAbsoluteUrl(jnlp){
        var absoluteUrl;
        if(isAbsoluteUrl(jnlp)) {
            absoluteUrl = jnlp;
        } else {
            var location = window.location.href;
            var pos = location.lastIndexOf('/');
            var docbase =  pos > -1 ? location.substring(0, pos + 1) : location + '/';
	    absoluteUrl = docbase + jnlp;
        }
        return absoluteUrl;
    }

    function launchWithJnlpProtocol(jnlp) {
        document.location="jnlp:"+ getAbsoluteUrl(jnlp);
    }
  

    function isAbsoluteUrl(url){
       var protocols = ["http://", "https://", "file://"];
       for (var i=0; i < protocols.length; i++){
         if(url.toLowerCase().startsWith(protocols[i])){
         	return true;;
	 }
       }
       return false;
     }


    /**
     This class provides details on why current platform does not meet
     application platform requirements. Note that severe problems are
     reported immediately and therefore full check may be not performed and
     some (unrelated to fatal problem)
     methods may provide false positive answers.
     <p>
     If multiple components do not match then worst status is reported.
     Application need to repeat checks on each individual component
     if it want to find out all details.

     @class PlatformMismatchEvent
     @for   dtjava
     */
    function PlatformMismatchEvent(a) {

        //expect to get all parameters needed
        for (var p in a) {
            this[p] = a[p];
        }

        /**
         * @method toString
         * @return {string}
         *    Returns string replesentation of event. Useful for debugging.
         */
        this.toString = function() {
            return "MISMATCH [os=" + this.os + ", browser=" + this.browser
                + ", jre=" + this.jre + ", fx=" + this.fx
                + ", relaunch=" + this.relaunch + ", platform="
                + this.platform + "]";
        };

        /**
         @method isUnsupportedPlatform
         @return {boolean}
         Returns true if this platform (OS/hardware) is not supported in a way
         to satisfy all platfrom requirements.
         (E.g. page is viewed on iPhone or JavaFX 2.0 application on Solaris.)
         <p>
         Note that this does not include browser match data.
         If platform is unsupported then application can not be
         launched and user need to use another platform to view it.
         */

        this.isUnsupportedPlatform = function() {
            return this.os;
        };

        /**
         @method isUnsupportedBrowser
         @return {boolean}
         Returns true if error is because current browser is not supported.
         <p>
         If true is returned and isRelaunchNeeded() returns true too then
         there are known supported browsers browsers for this platform.
         (but they are not necessary installed on end user system)
         */
        this.isUnsupportedBrowser = function() {
            return this.browser;
        };

        /**
         @method jreStatus
         @return {string}

         Returns "ok" if error was not due to missing JRE.
         Otherwise return error code characterizing the problem:
         <ul>
         <li> none - no JRE were detected on the system
         <li> old - some version of JRE was detected but it does not match platform requirements
         <li> oldplugin - matching JRE found but it is configured to use deprecated Java plugin that
         does not support Java applets
         <ul>
         <p>
         canAutoInstall() and isRelaunchNeeded() can be used to
         get more details on how seamless user' install experience will be.
         */
        this.jreStatus = function() {
            return this.jre;
        };

        /**
         * @method jreInstallerURL
         * @param {string} locale (optional) Locale to be used for installation web page
         * @return {string}
         *
         * Return URL of page to visit to install required version of Java.
         * If matching java runtime is already installed or not officially supported
         * then return value is null.
         */
        this.jreInstallerURL = function(locale) {
            if (!this.os && (this.jre == "old" || this.jre == "none")) {
                return getJreUrl(locale);
            }
            return null;
        };

        /**
         @method javafxStatus
         @return {string}

         Returns "ok" if error was not due to missing JavaFX.
         Otherwise return error code characterizing the problem:
         <ul>
         <li> none - no JavaFX runtime is detected on the system
         <li> old - some version of JavaFX runtime iss detected but it does not match platform requirements
         <li> disabled - matching JavaFX is detected but it is disabled
         <li> unsupported - JavaFX is not supported on this platform
         <ul>
         <p>
         canAutoInstall() and isRelaunchNeeded() can be used to
         get more details on how seamless user' install experience will be.
         */
        this.javafxStatus = function() {
            return this.fx;
        };

        /**
         * @method javafxInstallerURL
         * @param {string} locale (optional) Locale to be used for installation web page
         * @return {string}
         *
         * Return URL of page to visit to install required version of JavaFX.
         * If matching JavaFX runtime is already installed or not officially supported
         * then return value is null.
         */
        this.javafxInstallerURL = function(locale) {
            if (!this.os && (this.fx == "old" || this.fx == "none")) {
                return getFxUrl(locale);
            }
            return null;
        };

        /**
         @method canAutoInstall
         @return {boolean}
         Returns true if installation of missing components can be
         triggered automatically. In particular, ture is returned
         if there are no missing components too.
         <p>
         If any of missing components need to be installed manually
         (i.e. click through additional web pages) then false is returned.
         */
        this.canAutoInstall = function() {
            return isAutoInstallEnabled(this.platform, this.jre, this.fx);
        };

        /**
         @method isRelaunchNeeded
         @return {boolean}

         Returns true if browser relaunch is needed before application can be loaded.
         This often is true in conjuction with need to perform installation.
         <p>
         Other typical case - use of unsupported browser when
         it is known that there are supported browser for this pltaform.
         Then both isUnsupportedBrowser() and isRelaunchNeeded() return true.
         */
        this.isRelaunchNeeded = function() {
            return this.relaunch;
        };
    }

    //returns version of instaled JavaFX runtime matching requested version
    //or null otherwise
    function getInstalledFXVersion(requestedVersion) {
        //NPAPI browser and JRE with cobundle
        if (ua.fx != null && versionCheckFX(requestedVersion, ua.fx)) {
            return ua.fx;
        }
        //try to use DT
        var p = getPlugin();
        if (notNull(p)) {
            try {
                return p.getInstalledFXVersion(requestedVersion);
            } catch(e) {}
        }
        return null;
    }

    //concatenate list with space as separator
    function listToString(lst) {
      if (lst != null) {
          return lst.join(" ");
      } else {
          return null;
      }
    }

    function addArgToList(lst, arg) {
        if (notNull(lst)) {
           lst.push(arg);
           return lst;
        } else {
            var res = [arg];
            return res;
        }
    }

    function doLaunch(ld, platform, cb) {
        var app = normalizeApp(ld, true);
        if(ua.noPluginWebBrowser){
            launchWithJnlpProtocol(app.url);
            return;
	}

        //required argument is missing
        if (!(notNull(app) && notNull(app.url))) {
            throw "Required attribute missing! (application url need to be specified)";
        }

        //if we got array we need to copy over!
        platform = new dtjava.Platform(platform);

        //normalize handlers
        cb = new dtjava.Callbacks(cb);

        var launchFunc = function() {
            //prepare jvm arguments
            var jvmArgs = notNull(platform.jvmargs) ? platform.jvmargs : null;
            if (notNull(platform.javafx)) {
                //if FX is needed we know it is available or
                // we will not get here
                var v = getInstalledFXVersion(platform.javafx);
                //add hint that we need FX toolkit to avoid relaunch
                // if JNLP is not embedded
                jvmArgs = addArgToList(jvmArgs, " -Djnlp.fx=" + v);
                //for swing applications embedding FX we do not want this property as it will
                // trigger FX toolkit and lead to app failure!
                //But for JavaFX application it saves us relaunch as otherwise we wil launch with AWT toolkit ...
                if (!notNull(ld.toolkit) || ld.toolkit == "fx") {
                    jvmArgs = addArgToList(jvmArgs, " -Djnlp.tk=jfx");
                }

            }


            //if we on 7u6+ we can use DTLite plugin in the NPAPI browsers
            //Caveat: as of 7u6 it does not work with Chrome on Linux because Chrome expects
            //   DTLite plugin to implement xembed (or claim to support xembed)
            if (haveDTLite() && !(ua.linux && ua.chrome)) {
                if (doLaunchUsingDTLite(app, jvmArgs, cb)) {
                    return;
                }
            }

            //Did not launch yet? Try DT plugin (7u2+)
            var p =  getPlugin();
            if (notNull(p)) {
                try {
                    try {
                        //check if new DT APIs are available
                        if (versionCheck("10.6+", ua.deploy, false)) {
                            //    obj.launchApp({"url" : "http://somewhere/my.jnlp",
                            //                   "jnlp_content" : "... BASE 64 ...",
                            //                   "vmargs" : [ "-ea -Djnlp.foo=bar"
                            //                   "appargs" : [ "first arg,  second arg" ]
                            //                   "params" : {"p1" : "aaa", "p2" : "bbb"}});
                            var callArgs = {"url":app.url};
                            if (notNull(jvmArgs)) {
                                callArgs["vmargs"] = jvmArgs;
                            }
                            //Only use HTML parameters, they are supposed to overwrite values in the JNLP
                            //In the future we want to pass arguments too but this needs also be exposed for
                            // embedded deployment
                            if (notNull(app.params)) {
                                //copy over and ensure all values are strings
                                // (native code will ignore them otherwise)
                                var ptmp = {};
                                for (var k in app.params) {
                                    ptmp[k] = String(app.params[k]);
                                }
                                callArgs["params"] = ptmp;
                            }
                            if (notNull(app.jnlp_content)) {
                                callArgs["jnlp_content"] = app.jnlp_content;
                            }
                            var err = p.launchApp(callArgs);
                            if (err == 0) { //0 - error
                                if (isDef(cb.onRuntimeError)) {
                                    cb.onRuntimeError(app.id);
                                }
                            }
                        } else { //revert to old DT APIs
                            //older DT APIs expects vmargs as a single string
                            if (!p.launchApp(app.url, app.jnlp_content, listToString(jvmArgs))) {
                                if (isDef(cb.onRuntimeError)) {
                                    cb.onRuntimeError(app.id);
                                }
                            }
                        }
                        return;
                    } catch (ee) { //temp  support for older build of DT
                        if (!p.launchApp(app.url, app.jnlp_content)) {
                           if (isDef(cb.onRuntimeError)) {
                              cb.onRuntimeError(app.id);
                           }
                        }
                        return;
                    }
                } catch (e) {
                    //old DT
                }
            } //old Java (pre DTLite)? not Windows? or old DT

            //use old way to launch it using java plugin
            var o = getWebstartObject(app.url);
            if (notNull(d.body)) {
                d.body.appendChild(o);
            } else {
                //should never happen
                d.write(o.innerHTML);
            }
        }

        var r = doValidateRelaxed(platform);
        //can not launch, try to fix
        if (r != null) {
            resolveAndLaunch(app, platform, r, cb, launchFunc);
        } else {
            launchFunc();
        }
    }

    //process unhandled platform error - convert to code and call callback
    function reportPlatformError(app, r, cb) {
        if (isDef(cb.onDeployError)) {
            cb.onDeployError(app, r);
        }
    }

    function isDTInitialized(p) {
        //if plugin is blocked then p.version will be undefined
        return p != null && isDef(p.version);
    }

    //Wait until DT plugin is initialized and then run the code
    //Currently we only use it for embeded apps and Chrome on Windows
    function runUsingDT(label, f) {
        //  Possible situations:
        //   a) plugin is live and we can simply run code
        //        - just run the code
        //   b) plugin is in the DOM tree but it is not initialized yet (e.g. Chrome blocking)
        //      and there is live timer (pendingCount > 0)
        //        - there could be another request. We will APPEND to it
        //        (this is different from dtlite as in this case we can not have multiple clicks)
        //        - renew timer life counter (do not want new timer)
        //   c) plugin is in the DOM tree and it is not fully initialized yet but timer is stopped
        //        - overwrite old request
        //        - restart timer
        //
        // Problem we are solving:
        //    when plugin is ready to serve request? How do we schedule call to happen when plugin is initialized?
        // Caveat:
        //    Chrome can popup dialog asking user to grant permissions to load the plugin.
        //    There is no API to detect dialog is shown and when user grants or declines permissions
        //
        // Note:
        //    If we set property on plugin object before it is unblocked then they seem to be lost
        //   and are not propagated to the final object once it is instantiated.
        //
        // Workaround we use:
        //    Once plugin is added we will be checking if it is initialized and once we detect it we will execute code.
        //  We will stop checking after some time.
        var p = getPlugin();
        if (p == null) {
            return; //NO DT
        }

        if (isDTInitialized(p)) {
            f(p);
        } else {
            // see if we need new timer
            var waitAndUse = null;
            if (!isDef(dtjava.dtPendingCnt) || dtjava.dtPendingCnt == 0) {
                waitAndUse = function () {
                    if (isDTInitialized(p)) {
                        if (notNull(dtjava.dtPending)) {
                            for (var i in dtjava.dtPending) {
                                dtjava.dtPending[i]();
                            }
                        }
                        return;
                    }
                    if (dtjava.dtPendingCnt > 0) {
                        dtjava.dtPendingCnt--;
                        setTimeout(waitAndUse, 500);
                    }
                }
            }
            //add new task in queue
            if (!notNull(dtjava.dtPending) || dtjava.dtPendingCnt == 0) {
                dtjava.dtPending = {};
            }
            dtjava.dtPending[label] = f; //use map to ensure repitative actions are not queued (e.g. multiple click to launch webstart)
            //reset the timer counter
            dtjava.dtPendingCnt = 1000; //timer is gone after 500s
            //start timer if needed
            if (waitAndUse != null) waitAndUse();
        }
    }

    //returns same mismatch event if not resolved, null if resolved
    function resolveAndLaunch(app, platform, v, cb, launchFunction) {
        var p = getPlugin();
        if( p == null && ua.noPluginWebBrowser){
            var readyStateCheck = setInterval(function() {
                    if(document.readyState  == "complete"){
                        clearInterval(readyStateCheck);
                        showMessageBox();
                    }
                }, 15);
            return;
        }
        //Special case: Chrome/Windows
        // (Note: IE may also block activeX control but then it will block attempts to use it too)
        if (ua.chrome && ua.win && p != null && !isDTInitialized(p)) {
            //this likely means DT plugin is blocked by Chrome
            //tell user to grant permissions and retry
            var actionLabel;
            if (notNull(app.placeholder)) {
                var onClickFunc = function() {w.open("https://www.java.com/en/download/faq/chrome.xml"); return false;};
                var msg1 = "Please give Java permission to run on this browser web page.";
                var msg2 = "Click for more information.";
                var altText = "";
                doShowMessageInTheArea(app, msg1, msg2, altText, "javafx-chrome.png", onClickFunc);
                actionLabel = app.id + "-embed";
            } else {
                v.jre = "blocked";
                reportPlatformError(app, v, cb);
                actionLabel = "launch"; //we only queue ONE webstart launch.
                                        //Do not want to try to queue different apps - bad UE
                                        // (once user enable multiple things can spawn)
                                        //Note: what if multiple webstart apps are set to launch on page load (suer do not need to click)?
                                        //      Guess do not worry for now
                                        //Note: app.id may be null in case of webstart app.
            }

            //now we need to start waiter. Once DT is initialized we can proceeed
            var retryFunc = function() {
                var vnew = doValidateRelaxed(platform);
                if (vnew == null) { //no problems with env
                    launchFunction();
                } else {
                    resolveAndLaunch(app, platform, vnew, cb, launchFunction);
                }
            };
            runUsingDT(actionLabel, retryFunc);

            return;
        }

        if (!v.isUnsupportedPlatform() && !v.isUnsupportedBrowser()) { //otherwise fatal, at least until restart of browser
            if (isMissingComponent(v) && isDef(cb.onInstallNeeded)) {
                var resolveFunc= function() {
                    //once install is over we need to revalidate
                    var vnew = doValidateRelaxed(platform);
                    if (vnew == null) { //if no problems found - can launch
                        launchFunction();
                    } else { //TODO: what happens if we installed everything but relaunch is needed??
                        //We can not get here if component install was not offered for any or missing componens
                        //(if auto install was possible, see doInstall() implementation)
                        //Hence, it is safe to assume we failed to meet requirements
                        reportPlatformError(app, vnew, cb);

                        //TODO: may be should call itself again but
                        // then it easy can become infinite loop

                        //e.g. user installs but we fail to detect it because DT
                        // is not FX aware and retry, etc.
                        //TODO: think it through
                    }
                };

                cb.onInstallNeeded(app, platform, cb,
                            v.canAutoInstall(), v.isRelaunchNeeded(), resolveFunc);
                return;
            }
        }
        reportPlatformError(app, v, cb);
    }

    function haveDTLite() {
        // IE does not support DTLite
        if (ua.deploy != null && !ua.ie) {
            return versionCheck("10.6+", ua.deploy, false);
        }
        return false;
    }

    function isDTLiteInitialized(p) {
        //if plugin is blocked then p.version will be undefined
        return p != null && isDef(p.version);
    }

    function getDTLitePlugin() {
        return document.getElementById("dtlite");
    }

    function doInjectDTLite() {
        //do not want more than one plugin
        if (getDTLitePlugin() != null) return;

        var p = document.createElement('embed');
        p.width = '10px';
        p.height = '10px';
        p.id = "dtlite";
        p.type = "application/x-java-applet";  //means we get latest

        var div = document.createElement("div");
        div.style.position = "relative";
        div.style.left = "-10000px";
        div.appendChild(p);

        var e = document.getElementsByTagName("body");
        e[0].appendChild(div);
    }

    function runUsingDTLite(f) {
        //  Possible situations:
        //   a) first request, plugin is not in the DOM tree yet
        //        - add plugin
        //        - setup wait mechanism and run f() once plugin is ready
        //   b) plugin is live and we can simply run code
        //        - just run the code
        //   c) plugin is in the DOM tree but it is not initialized yet (e.g. Chrome blocking)
        //      and there is live timer (pendingCount > 0)
        //        - there could be another request. We will override it (e.g. user clicked multiple times)
        //        - renew timer life counter (do not want new timer)
        //   d) plugin is in the DOM tree and it is not fully initialized yet but timer is stopped
        //        - overwrite old request
        //        - restart timer
        //
        // Problem:
        //    when plugin is ready to serve request? How do we schedule call to happen when plugin is initialized?
        // Caveat:
        //    Chrome can popup dialog asking user to grant permissions to load the plugin.
        //    There is no API to detect dialog is shown and when user grants or declines permissions
        //
        // Note:
        //    If we set property on plugin object before it is unblocked then they seem to be lost
        //   and are not propagated to the final object once it is instantiated.
        //
        // Workaround we use:
        //    Once plugin is added we will be checking if it is initialized and once we detect it we will execute code.
        //  We will stop checking after some time.
        var p = getDTLitePlugin();
        if (p == null) {
            doInjectDTLite();
            p = getDTLitePlugin();
        }

        if (isDTLiteInitialized(p)) {
            f(p);
        } else {
            // see if we need new timer
            var waitAndUse = null;
            if (!isDef(dtjava.dtlitePendingCnt) || dtjava.dtlitePendingCnt == 0) {
                waitAndUse = function () {
                    if (isDef(p.version)) {
                        if (dtjava.pendingLaunch != null) {
                            dtjava.pendingLaunch(p);
                        }
                        dtjava.pendingLaunch = null;
                        return;
                    }
                    if (dtjava.dtlitePendingCnt > 0) {
                        dtjava.dtlitePendingCnt--;
                        setTimeout(waitAndUse, 500);
                    }
                }
            }
            //add new task in queue
            dtjava.pendingLaunch = f;
            //reset the timer counter
            dtjava.dtlitePendingCnt = 1000; //timer is gone after 500s
            //start timer if needed
            if (waitAndUse != null) {
                waitAndUse();
            }
        }
    }

    function doLaunchUsingDTLite(app, jvmargs, cb) {
        var launchIt = function() {
            var pp = getDTLitePlugin();
            if (pp == null) {
                //should not be possible as we guard before enter this function
                if (isDef(cb.onRuntimeError)) {
                    cb.onRuntimeError(app.id);
                }
            }

            //DTLite only support new invocation API
            //    obj.launchApp({"url" : "http://somewhere/my.jnlp",
            //                   "jnlp_content" : "... BASE 64 ...",
            //                   "vmargs" : [ "-ea -Djnlp.foo=bar"
            //                   "appargs" : [ "first arg,  second arg" ]
            //                   "params" : {"p1" : "aaa", "p2" : "bbb"}});
            var callArgs = {"url" : app.url};
            if (notNull(jvmargs)) {
               callArgs["vmargs"] = jvmargs;
            }
            //Only use HTML parameters, they are supposed to overwrite values in the JNLP
            //In the future we want to pass arguments too but this needs also be exposed for
            // embedded deployment
            if (notNull(app.params)) {
                //copy over and ensure all values are stings
                // (native code will ignore them otherwise)
                var ptmp = {};
                for (var k in app.params) {
                    ptmp[k] = String(app.params[k]);
                }
                callArgs["params"] = ptmp;
            }
            if (notNull(app.jnlp_content)) {
               callArgs["jnlp_content"] = app.jnlp_content;
            }
            var err = pp.launchApp(callArgs);
            if (err == 0) { //0 - error
                if (isDef(cb.onRuntimeError)) {
                    cb.onRuntimeError(app.id);
                }
            }
        };

        if (versionCheck("10.4+", ua.deploy, false)) { //only for NPAPI browsers
            runUsingDTLite(launchIt);
            return true;
        }
        return false;
    }

    function getWebstartObject(jnlp) {
        var wo = null;
        if (ua.ie) { //TODO: attempt to use object in FF 3.6 lead to hang. Revert to embed for now
                     //TODO: Should Chrome use object?
            //object tag itself
            wo = d.createElement('object');
            wo.width = '1px'; //zero size reports invalid argument in IE!
            wo.height = '1px'; //TODO: make it less distruptive to page layout? hide div?
            var p = d.createElement('param');
            p.name = 'launchjnlp';
            p.value = jnlp;
            wo.appendChild(p);
            p = d.createElement('param');
            p.name = 'docbase';
            p.value = notNull(d.documentURI) ? d.documentURI : d.URL;
            wo.appendChild(p);

            if (!ua.ie) {
                //NB:do not need to use exact version in mime type as generic should be mapped to latest?
                wo.type = "application/x-java-applet;version=1.7";
            } else {
                wo.classid = "clsid:8AD9C840-044E-11D1-B3E9-00805F499D93";
            }
        } else { //TODO: else part should go away once we figure out what is going on with FF
            wo = d.createElement('embed');
            wo.width = '0px';
            wo.height = '0px';
            //NB: dot notation did not work for custom attributes??? revert to setAttribute
            wo.setAttribute('launchjnlp', jnlp);
            wo.setAttribute('docbase', (notNull(d.documentURI) ? d.documentURI : d.URL));
            //NB:do not need to use exact version in mime type as generic should be mapped to latest?
            wo.type = "application/x-java-applet;version=1.7";
        }

        var div = d.createElement("div");
        div.style.position = "relative";
        div.style.left = "-10000px";
        div.appendChild(wo);
        return div;
    }

    // Version class. The argument VersionString is a valid version string and
    // UpgradeFromOldJavaVersion is optional true/false.
    var Match = {
        Exact: {value: 0},  // exact version
        Family: {value: 1}, // Example: 1.7* only matches 1.7.X family
        Above: {value: 2}   // Example: 1.7+ matches 1.7 and above
    };

    var Token = {
        Uninitialized: {value: -2},
        Unknown: {value: -1},
        Identifier: {value: 0},
        Alpha: {value: 1},
        Digits: {value: 2},
        Plus: {value: 3},
        Minus: {value: 4},
        Underbar: {value: 5},
        Star: {value: 6},
        Dot: {value: 7},
        End: {value: 8}
    };

    var Version = function(VersionString, UpgradeFromOldJavaVersion) {
        if (typeof UpgradeFromOldJavaVersion === 'undefined') {
            var UpgradeFromOldJavaVersion = true;
        }

        // Constants
        var MAX_DIGITS = 4;

        // Private
        var FVersionString = null;
        var FOld = false;
        var FVersion = null;
        var FBuild = null;
        var FPre = null;
        var FMatch = null;
        var FMajor = null;
        var FMinor = null;
        var FSecurity = null;
        var FPatch = null;

        // Class constructor
        if (!VersionString) {
            return null;
        }
        else {
            FVersionString = VersionString;
            var v = parseAndSplitVersionString(VersionString, UpgradeFromOldJavaVersion)
            FOld = v.old;
            FVersion = v.version;
            FBuild = v.build;
            FMatch = v.match;
            FPre = v.pre;

            var parts = splitVersion(v.version);
            FMajor = parts.major;
            FMinor = parts.minor;
            FSecurity = parts.security;
            FPatch = parts.patch;
        }

        // Public
        return {
            VersionString: VersionString,
            old: FOld,
            major: FMajor,
            minor: FMinor,
            security: FSecurity,
            patch: FPatch,
            version: FVersion,
            build: FBuild,
            pre: FPre,
            match: FMatch,

            check: function(query) {
                return check(query, this);
            },

            equals: function(query) {
                return equals(query, this);
            }
        };

        // Private
        function splitVersion(version) {
            var lmajor = null;
            var lminor = null;
            var lsecurity = null;
            var lpatch = null;

            if (version.length >= 1) {
                lmajor = version[0];
            }

            if (version.length >= 2) {
                lminor = version[1];
            }

            if (version.length >= 3) {
                lsecurity = version[2];
            }

            if (version.length >= 4) {
                lpatch = version[3];
            }

            return {
                major: lmajor,
                minor: lminor,
                security: lsecurity,
                patch: lpatch
          };
        }

        function VersionStringTokenizer(versionString) {
            // Convert the version string to lower case and strip all whitespace
            // from the beginning and end of the string.

            var FVersionString = versionString.toLowerCase().trim();
            var FIndex;
            var FCurrentToken = null;
            var FStack = Array();

            function isDigit(c) {
                var result = false;

                switch(c) {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        result = true;
                        break;
                }

                return result;
            }

            function isLetter(c) {
                //return c.match("^[a-zA-Z]");
                var result = false;
                var lowerBoundLower = "a".charCodeAt(0);
                var upperBoundLower = "z".charCodeAt(0);
                var bound = c.charCodeAt(0);

                if (lowerBoundLower <= bound && bound <= upperBoundLower) {
                    result = true;
                }

                return result;
            }

            function start() {
                FIndex = 0;
            }

            function currentToken() {
                return FCurrentToken;
            }

            function pushToken(Token) {
                if (FCurrentToken != null) {
                    FStack.unshift(FCurrentToken);
                }

                FCurrentToken = Token;
            }

            function nextToken() {
                var tokenID = Token.Uninitialized;
                var token = '';

                if (FStack.length > 0) {
                    tokenID = FStack[0].tokenID;
                    token = FStack[0].token;
                    FStack.shift();
                }
                else {
                    if (FIndex >= FVersionString.length) {
                        tokenID = Token.End;
                    }
                    else {
                        while (FIndex < FVersionString.length) {
                            var c = FVersionString.charAt(FIndex);

                            if ((tokenID == Token.Uninitialized || tokenID == Token.Alpha) &&
                                isLetter(c) == true) {
                                tokenID = Token.Alpha;
                                FIndex++;
                                token += c;
                            }
                            else if ((tokenID == Token.Uninitialized || tokenID == Token.Digits) &&
                                     isDigit(c) == true) {
                                if (parseInt(c) == 0 && parseInt(token) == 0) {
                                    tokenID = Token.Unknown;
                                    token += c;
                                    FIndex++;
                                    break;
                                }
                                else {
                                    tokenID = Token.Digits;
                                    token += c;
                                    FIndex++;
                                }
                            }
                            else if ((tokenID == Token.Alpha || tokenID == Token.Identifier) &&
                                     isDigit(c) == true &&
                                     isLetter(c) == false) {
                                tokenID = Token.Identifier;
                                FIndex++;
                                token += c;
                            }
                            else if (tokenID == Token.Uninitialized) {
                                switch(c) {
                                    case '-':
                                      tokenID = Token.Minus;
                                      FIndex++;
                                      token = c;
                                      break;
                                    case '+':
                                      tokenID = Token.Plus;
                                      FIndex++;
                                      token = c;
                                      break;
                                    case '*':
                                      tokenID = Token.Star;
                                      FIndex++;
                                      token = c;
                                      break;
                                    case '.':
                                      tokenID = Token.Dot;
                                      FIndex++;
                                      token = c;
                                      break;
                                    case '_':
                                      tokenID = Token.Underbar;
                                      FIndex++;
                                      token = c;
                                      break;
                                    default:
                                        tokenID = Token.Unknown;
                                        FIndex++;
                                        break;
                                }

                                break;
                            }
                            else {
                              break;
                            }
                        }
                    }
                }

                FCurrentToken = {
                    token: token,
                    tokenID: tokenID
                }

                return FCurrentToken;
            }

            return {
                start: start,
                nextToken: nextToken,
                pushToken: pushToken,
                currentToken: currentToken,
                isDigit: isDigit,
                isLetter: isLetter
            }
        }

        function VersionStringParser() {
            function readDigits(Tokenizer) {
                var result = new Array();
                var token = Tokenizer.currentToken();

                if (token.tokenID == Token.Digits) {
                    result.push(parseInt(token.token));
                    token = Tokenizer.nextToken();

                    // Read up to 3 more digits.
                    for (var index = 0; index < (MAX_DIGITS - 1); index++) {
                        if (token.tokenID == Token.Dot) {
                            token = Tokenizer.nextToken();

                            if (token.tokenID == Token.Digits) {
                                result.push(parseInt(token.token));
                                token = Tokenizer.nextToken();
                            }
                            else if (token.tokenID == Token.Star ||
                                     token.tokenID == Token.Plus) {
                                break;
                            }
                            else {
                                result = null;
                                break;
                            }
                        }
                        else if (token.tokenID == Token.Star ||
                                 token.tokenID == Token.Plus ||
                                 token.tokenID == Token.End ||
                                 token.tokenID == Token.Minus ||
                                 token.tokenID == Token.Underbar ||
                                 token.tokenID == Token.Identifier ||
                                 (token.tokenID == Token.Alpha && token.token == 'u')) {
                            break;
                        }
                        else {
                            result = null;
                            break;
                        }
                    }
                }

                return result;
            }

            function readMatch(Tokenizer, Old) {
                var result = Match.Exact;
                var token = Tokenizer.currentToken();

                if (token.tokenID == Token.Dot) {
                    token = Tokenizer.nextToken();

                    if (token.tokenID == Token.Star) {
                        result = Match.Family;
                        Tokenizer.nextToken();
                    }
                    else if (token.tokenID == Token.Plus) {
                        result = Match.Above;
                        Tokenizer.nextToken();
                    }
                }
                else if (token.tokenID == Token.Star) {
                    result = Match.Family;
                    Tokenizer.nextToken();
                }
                else if (token.tokenID == Token.Plus) {
                    result = Match.Above;
                    Tokenizer.nextToken();
                }

                return result;
            }

            function readPre(Tokenizer) {
                var result = null;
                var token = Tokenizer.currentToken();

                if (token.tokenID == Token.Minus) {
                    var savedToken = token;
                    var token = Tokenizer.nextToken();

                    if (token.tokenID == Token.Alpha) {
                        result = token.token;
                        Tokenizer.nextToken();
                    }
                    else {
                        Tokenizer.pushToken(savedToken);
                    }
                }

                return result;
            }

            function readBuild(Tokenizer, Old) {
                var result = null;
                var token = Tokenizer.currentToken();

                if (token.tokenID == Token.Plus) {
                    // The new version spec has build number prepended with a "+":
                    // RegEx: +([1-9][0-9]*)
                    var savedToken = token;
                    var token = Tokenizer.nextToken();

                    if (token.tokenID == Token.Digits) {
                        result = parseInt(token.token);
                        Tokenizer.nextToken();
                    }
                    else {
                        Tokenizer.pushToken(savedToken);
                    }
                }
                else if (Old == true) {
                    // The old version spec has build number prepended with a "-b"
                    // RegEx: -b([1-9][0-9]*)
                    if (token.tokenID == Token.Minus || token.tokenID == Token.Underbar) {
                        var savedToken = token;
                        token = Tokenizer.nextToken();

                        if (token.tokenID == Token.Identifier && token.token[0] == 'b') {
                            var builderNumber = parseInt(token.token.substr(1));

                            if (builderNumber != null && isNaN(builderNumber) == false) {
                                Tokenizer.nextToken();
                                result = builderNumber;
                            }
                        }
                        else {
                            Tokenizer.pushToken(savedToken);
                        }
                    }
                }

                return result;
            }

            // isOldUpdate determines if the version string is in the old
            // short format. For Example: 8u60
            function isOldUpdate(version, token) {
                var result = false;

                if (version.length == 1 &&
                    parseInt(version[0]) <= 8 &&
                    token.tokenID == Token.Identifier &&
                    token.token.length > 0 &&
                    token.token.charAt(0) == "u") {
                    result = true;
                }

                return result;
            }

            // Only call this function if isOldUpdate() returns true.
            function readOldUpdate(Tokenizer) {
                var result = null;
                var token = Tokenizer.currentToken();

                if (token.tokenID == Token.Identifier) {
                    result = parseInt(token.token.substr(1));
                    Tokenizer.nextToken();
                }
                else if (token.tokenID == Token.Star) {
                    lmatch = Match.Family;
                    Tokenizer.nextToken();
                }
                else if (token.tokenID == Token.Plus) {
                    lmatch = Match.Above;
                    Tokenizer.nextToken();
                }

                return result;
            }

            function readOpt(Tokenizer) {
                var result = null;
                var token = Tokenizer.currentToken();

                if (token.tokenID == Token.Alpha) {
                    result = token.token;
                    Tokenizer.nextToken();
                }

                return result;
            }

            function parse(Tokenizer) {
                var result = null;
                var success = false;

                var lold = false;
                var lversion = null;
                var lbuild = null;
                var lmatch = Match.Exact;
                var lpre = false;
                var lopt = null;

                Tokenizer.start();
                var token = Tokenizer.nextToken();

                if (token.tokenID == Token.Digits) {
                    lversion = readDigits(Tokenizer);

                    if (lversion != null && lversion.length > 0) {
                        token = Tokenizer.currentToken();

                        if (lversion[0] == 1) {
                            if (lversion.length >= 2 && lversion[1] == 9) {
                                return null;
                            }

                            lold = true;
                        }
                        else if (token.token == "u") {
                            // Special case. For Example: 8u*
                            token = Tokenizer.nextToken();
                        }

                        if (isOldUpdate(lversion, token) == true) {
                            lold = true;
                            var value = readOldUpdate(Tokenizer);

                            if (value != null) {
                                token = Tokenizer.currentToken();
                                lversion.push(parseInt(value));
                                lold = true;

                                if (token.tokenID == Token.End) {
                                    success = true;
                                }
                                else {
                                    lmatch = readMatch(Tokenizer);
                                    token = Tokenizer.currentToken();

                                    if (token.tokenID == Token.End) {
                                        success = true;
                                    }
                                }
                            }
                        }
                        else {
                            token = Tokenizer.currentToken();

                            if (lold == true && token.tokenID == Token.Underbar) {
                                token = Tokenizer.nextToken();

                                if (token.tokenID == Token.Digits && lversion.length < MAX_DIGITS) {
                                    lversion.push(parseInt(token.token));
                                    Tokenizer.nextToken();
                                }
                            }

                            lpre = readPre(Tokenizer);
                            token = Tokenizer.currentToken();

                            lbuild = readBuild(Tokenizer, lold);
                            lopt = readOpt(Tokenizer);
                            lmatch = readMatch(Tokenizer, lold);
                            token = Tokenizer.currentToken();

                            if (token.tokenID == Token.End) {
                                success = true;
                            }
                        }

                        if (success == true) {
                            result = {
                                old: lold,
                                version: lversion,
                                build: lbuild,
                                match: lmatch,
                                pre: lpre,
                                opt: lopt
                            };
                        }
                    }
                }

                return result;
            }

            return {
                parse: parse
            }
        }

        function parseAndSplitVersionString(versionString, UpgradeFromOldJavaVersion) {
            var lold = false;
            var lversion = new Array;
            var lbuild = null;
            var lmatch = null;
            var lpre = false;
            var lopt = null;

            // Corner case inputs.
            if (versionString == null || versionString.length == 0) {
                lversion = [0, 0, 0, 0];
            }
            else {
                var tokenizer = VersionStringTokenizer(versionString);
                var parser = VersionStringParser();
                var result = parser.parse(tokenizer);

                if (result != null) {
                    if (UpgradeFromOldJavaVersion == true &&
                        result.old == true) {
                        if (result.version.length > 0 &&
                            result.version[0] == 1) {
                            lversion = result.version.splice(1, result.version.length - 1);
                        }
                        else {
                            lversion = result.version;
                        }

                        lold = true;
                    }
                    else {
                        lversion = result.version;
                    }

                    lbuild = result.build;
                    lmatch = result.match;
                    lpre = result.pre;
                }
            }

            return {
                old: lold,
                version: lversion,
                build: lbuild,
                match: lmatch,
                pre: lpre,
                opt: lopt
            };
        }

        function sameVersion(query, version) {
            var result = false;
            var lquery = query;

            if (lquery == null)
                lquery = 0;

            if (parseInt(lquery) == parseInt(version)) {
                result = true;
            }

            return result;
        }

        // compareVersionExact comparison returns true only if query and version are
        // exact matches.
        function compareVersionExact(query, version) {
            var result = false;

            if ((query.major != null) &&
                (version.major != null) &&
                sameVersion(query.major, version.major) &&
                sameVersion(query.minor, version.minor) &&
                sameVersion(query.security, version.security) &&
                sameVersion(query.patch, version.patch) &&
                (query.old == version.old) &&
                (query.pre == version.pre) &&
                ((parseInt(query.build) == parseInt(version.build)) || (query.build == null && version.build == null))) {
                result = true;
            }

            return result;
        }

        // compareVersionFamily comparison is for the * wild card for the current query
        // version and anything above within the current version. For Example:
        // 1.7* will match 1.7.8.9 but not 1.8.
        function compareVersionFamily(query, version) {
            var result = false;

            // There is a subtle corner case comparison when comparing:
            //  1.* to 1.8 (success)
            //  1.* to 9.0 (fail)
            // In this case, if both strings are old that means we have a 1s, so
            // since the query string is all 0s, or empty, we have a match.
            if (query.old == true && query.version.length == 0 && version.old == true) {
                result = true;
            }
            else {
                // All elements must match on the query version array.
                for (index = 0 ;index < query.version.length && index < version.version.length;
                     index++) {
                    var q = query.version[index];
                    var v = version.version[index];

                    if (parseInt(q) == parseInt(v)) {
                        result = true;
                    }
                    else {
                        result = false;
                        break;
                    }
                }
            }

            return result;
        }

        // compareVersionAbove comparison is for the + wild card for the current query
        // version and anything above returning true.
        function compareVersionAbove(query, version) {
            var result = false;

            if (query.old == true && query.version.length == 0) {
                result = true;
            }
            else if (query.old == true && version.old == false) {
                result = true;
            }
            else if (query.major == 0) {
                result = true;
            }
            else if ((query.major != null) &&
                (version.major != null) &&
                ((parseInt(query.build) == parseInt(version.build)) || (query.build == null && version.build == null))) {

                for (var index = 0; index < query.version.length; index++) {
                    var q = query.version[index];
                    var v = version.version[index];

                    if (parseInt(q) == parseInt(v)) {
                        result = true;
                    }
                    else if (parseInt(q) < parseInt(v)) {
                        if ((query.old == true && version.old == true) ||
                            (query.old == false && version.old == false)) {
                            result = true;
                        }

                        break;
                    }
                    else {
                        result = false;
                        break;
                    }
                }
            }

            return result;
        }

        // cloneAndCompleteVersionInfo is an internal method. It makes a copy of the
        // version structure and completes the version array to contain four elements.
        function cloneAndCompleteVersionInfo(version) {
            var clone_version = version.version.slice(0);

            // The source version string must be a complete version string (four digits).
            // Example: 9.0.0.0
            for (var index = clone_version.length; index < 4 ; index++) {
                clone_version.push(0);
            }

            var parts = splitVersion(clone_version);

            return {
                old: version.old,
                major: parts.major,
                minor: parts.minor,
                security: parts.security,
                patch: parts.patch,
                version: clone_version,
                build: version.build,
                pre: version.pre
            };
        }

        // Check performs a deploy pattern match comparison and returns
        // true if the comparing version matches false if not.
        function check(query, version) {
            var result = false;

            if (query.VersionString == null || query.VersionString.length == 0) {
                result = true;
            }
            else {
                if (query.build == null && version.build == null) {
                    var lversion = cloneAndCompleteVersionInfo(version);

                    if (query.match == Match.Exact) {
                        result = compareVersionExact(query, lversion);
                    }
                    else if (query.match == Match.Family) {
                        result = compareVersionFamily(query, lversion);
                    }
                    else if (query.match == Match.Above) {
                        result = compareVersionAbove(query, lversion);
                    }
                }
            }

            return result;
        }

        // Performs a comparison on the two version string arguments and returns
        // true if the comparing version matches false if not.
        function equals(value, version) {
            var result = false;

            if (query.VersionString == null || query.VersionString.length == 0) {
                result = true;
            }
            else {
                var lversion = cloneAndCompleteVersionInfo(version);
                var lquery = cloneAndCompleteVersionInfo(query);
                result = compareVersionExact(lquery, lversion);
            }

            return result;
        }
    };

    // Compares two version strings: query and version, matching query against version. query
    // is allowed to have wild cards + and * version is not. The argument UpgradeFromOldJavaVersion
    // is optional. This will remove the 1 prefix if present and mark the old field in the structure
    // that is passed around.
    function versionCheck(query, version, UpgradeFromOldJavaVersion) {
        var q = new Version(query, UpgradeFromOldJavaVersion);
        var v = new Version(version, UpgradeFromOldJavaVersion);
        return v.check(q);
    }

    // This is similar to version check rules except there is a range
    // over versions (3-7) that are not valid.
    //
    // JavaFX version requirements are always treated as "not earlier than this update".
    // I.e. we expect
    //     2.2.0 to match 2.2*, 2.2+, 2.1+, 2.1*, 2.0 and 1+
    //           but not match 2.2.1+, 2.2.1*, 2.3*, 2.3+ or 1*
    function versionCheckFX(query, version) {
        var q = new Version(query, false);

        if (parseInt(q.major) >= 3 && parseInt(q.major) <= 7 && query.substr(-1) !== "+") {
            return false;
        }

        if (q.match == Match.Exact) {
            q = new Version(query + "+", false);
        }

        var v = new Version(version, false);

        return v.check(q);
    }

    //as JavaFX comes with own plugin binaries then check based on mime types, etc.
    // may be false positive as it only checks for plugin version, not real JRE
    //Here we check that DT plugin is aware of JRE installations
    //Note that:
    //  - if DT is not available we will return false but we only do this i
    //    ready to launch => DT must be found
    //  - we do not want to check in jreCheck() as we want to avoid loading
    //    DT plugin if we can (as old DT may make it not possible to autostart)
    function doublecheckJrePresence() {
        if (!haveDTLite()) { //basically IE on windows or Old JRE on windows
          if (postponeNativePluginInstallation && notNull(d.body)) {
              // Native Plugin installation was postponed, as the page didn't have
              // body at that time. Try to install the plugin now.
              installNativePlugin();
              postponeNativePluginInstallation = false;
          }
          var p = getPlugin();
          if (p != null) {
            return true;
            //WORKAROUND: bug in native DT!!! TODO: What version? bypass for it only
            //return (p.jvms.getLength() > 0);
          }

          return false;
        }

        //if we are not using native DT plugin (i.e. using DTLite) then no way we can do sanity check
        //   => assume first check is accurate
        return true;
    }

    function jreCheck(jre) {
        // Check if latest JRE is exposed in mimetype and if it is good enough (only for NPAPI browsers)
        if (ua.jre != null) {
            if (versionCheck(jre, ua.jre)) {
               return "ok";
            }
            //Note: if we have JRE but it is not match that means we may need an upgrade message
            // but we still could be able to get more accurate answer with native DT plugin
        }

        //try to use DT plugin
        var p = getPlugin();
        if (p != null) {
            var VMs = p.jvms;
            for (var i = 0; VMs != null && i < VMs.getLength(); i++) {
                if (versionCheck(jre, VMs.get(i).version)) {
                    if (!ua.ie && notNull(navigator.mimeTypes)) {
                        //if mime types are available but plugin is not there =>
                        //  it is disabled
                        if (!notNull(navigator.mimeTypes["application/x-java-applet"])) {
                            return "disabled";
                        }
                    }
                    return "ok";
                }
            }
            //do not need to try other ways if used DT
            return "none";
        }

        //No full DT => On Windows we can not launch FX anyways
        //   but may have old JRE
        //And we might be able to launch on Mac/Linux


        //This is only IE on Windows. This gives no update version. only e.g. 1.6.0
        //and also cause java plugin to be loaded => browser will need to be restarted
        //if new JRE is installed.
        //However, if we got here than DT is not available and autoinstall is not possible
        if (ua.ie) {
            var lst = ["1.8.0", "1.7.0", "1.6.0", "1.5.0"];
            for (var v = 0; v < lst.length; v++) {
                if (versionCheck(jre, lst[v])) {
                    try {
                        //TODO: FIXME: This does not seem to work in my testing in IE7?
                        var axo = new ActiveXObject("JavaWebStart.isInstalled." + lst[v] + ".0");
                        // This is not hit if the above throws an exception.
                        return "ok";
                    } catch (ignored) {
                    }
                }
            }
        }


        return "none";
    }

    function checkJRESupport() {
        //Negative test. New platforms will not be rejected
        var osProblem = ['iPhone', 'iPod'];
        var os = containsAny(osProblem, navigator.userAgent);

        //Do not support Chrome/Mac as Chrome is 32 bit only
        var browser = (ua.mac && ua.chrome && ua.cputype == "intel");

        //autoinstall possible if native plugin is detected or OS is fine
        auto = os || (getPlugin() != null);

        //false is no problem found
        return {os: os, browser: browser, auto: auto};
    }

    //it is not clear if we can work in IE6
    // but it is hard to test and JRE7 does not even support it
    // mark as unsupported for now
    function isUnsupportedVersionOfIE() {
        if (ua.ie) {
            try {
              //these functions are defined in IE only
              var v = 10*ScriptEngineMajorVersion() + ScriptEngineMinorVersion();
              if (v < 57) return true; //IE7 will have 57
            } catch (err) {
                //really old IE?
                return true;
            }
        }
        return false;
    }

    function checkFXSupport() {
        var browser;
        if (ua.win) {
            //do not support Opera and Safari
            // (not really tested, may be it works but known to have problems with DT detection)
            browser = ua.op || ua.wk || isUnsupportedVersionOfIE();

            //false is no problem found
            return {os: false, browser: browser};
        } else if (ua.mac && ua.cputype == "intel") { //do not support PPC/iphone/ipad ...
            var os = !versionCheck("10.7.3+", ua.osVersion, false); //10.7.3 or later!
            browser = ua.op ||
                (ua.mac && ua.chrome); //Opera is not supported
            //Chrome on Mac is 32 bit => plugin only work in 64 bit ...
            //TODO: How do we detect FF running in 32 bit mode?

            //false is no problem found
            return {os: os, browser: browser};
        } else if (ua.linux) {
            browser = ua.op; //Opera unsupported

            //false is no problem found
            return {os: false, browser: browser};
        } else {
            //unknown unsupported OS
            return {os: true, browser: false};
        }
    }

    function relaxVersion(v) {
        if (notNull(v) && v.length > 0) {
            var c = v.charAt(v.length - 1);
            if (c == '*') {
              v = v.substring(0, v.length - 1)+"+";
            } else if (c != '+') { //exact version (e.g. 1.6)
                v = v + "+";
            }
        }
        return v;
    }

    //we relax validation rules where we try to embed or launch app
    // in order to deal with requests for OLDER jres at the java level
    //Basically we convert request for version in JRE family to request for any future JRE
    //We do NOT do same for JavaFX right now. There is no real need before 3.0 and it is not clear if it is good thing
    //
    //Note we keep validation strict for install and validate-only scenarios.
    // This allows to query accurate details from javascript
    function doValidateRelaxed(platform) {
        var p = new dtjava.Platform(platform);

        p.jvm = relaxVersion(p.jvm);
        //p.javafx = relaxVersion(p.javafx);

        return doValidate(p);
    }

    function doValidate(platform, noPluginWebBrowser) {
        //ensure some platform is set (we could get array too!)
        platform = new dtjava.Platform(platform);

        //problem markers
        var fx = "ok", jre = "ok", restart = false, os = false, browser = false,
            p, details;

        //check JRE
        if (notNull(platform.jvm) && jreCheck(platform.jvm) != "ok") { //matching JRE not found
            var res = jreCheck("1+");
            if (res == "ok") {
                jre = "old";
            } else {
                jre = res; //"none" or "disabled"
            }

            details = checkJRESupport();
            if (details.os) {
                jre = "unsupported";
                os = true;
            } else if(noPluginWebBrowser) {
		jre = "ok";
	    } else {
                browser = details.browser;
            }
        }

        //check FX
        if (notNull(platform.javafx)) {
            details = checkFXSupport();
            if (details.os) { //FX is not supported,
                              //do not even try
                fx = "unsupported";
                os = os || details.os;
            } else if(noPluginWebBrowser) {
                fx = "ok";
	    } else if( details.browser) {
                browser = browser || details.browser;
            } else {
                //on non windows platforms automated install is not possible
                // (if it is needed on windows and possible we will set it to false later)

                if (ua.fx != null) {
                  //found cobundled JavaFX on 7u6+ (and it is NPAPI-based browser)
                  if (versionCheckFX(platform.javafx, ua.fx)) {
                        fx = "ok";
                  } else if (versionCheckFX("2.0+", ua.fx)) {
                        fx = "old";
                  }
                } else if (ua.win) { //could be 7u6(cobundle)/IE or JRE6/FX
                  try {
                    p = getPlugin();
                    //typeof did not work in IE
                    var v = p.getInstalledFXVersion(platform.javafx);
                    // If not found then try for the latest family (e.g. if the requested FX version is "2.2" and "8.0.5" is installed
                    // we should not report that FX is old or does not exist. Instead we should continue with "8.0.5" and than either relaunch
                    // with the requested JRE or offer the user to launch the app using the latest JRE installed).
                    if (v == "" || v == null) {
                        v = p.getInstalledFXVersion(platform.javafx + '+');
                    }
                    //if found we should get version string, otherwise empty string or null. If found then fx=false!
                    if (v == "" || v == null) {
                        v = p.getInstalledFXVersion("2.0+"); //check for any FX version
                        if (v == null || v == "") {
                            fx = "none";
                        } else {
                            fx = "old";
                        }
                    }
                  } catch(err) {
                    //If we got here then environment is supported but
                    //this is non FX aware JRE => no FX and can only offer manual install
                    // (restart needed as toolkit is already loaded)
                    fx = "none";
                  }
                } else if (ua.mac || ua.linux) {
                    fx = "none";
                }
            }
        }

        //recommend relaunch if OS is ok but browser is not supported
        restart = restart || (!os && browser);

        //TODO: need a way to find out if java plugin is loaded => will need to relaunch

        //we need to return null if everything is ok. Check for problems.
        if (fx != "ok" || jre != "ok" || restart || os || browser) {
            return new PlatformMismatchEvent(
                {fx: fx, jre: jre, relaunch: restart, os: os, browser: browser,
                    platform: platform});
        } else {
            //if all looks good check JRE again, it could be false positive
            if (ua.override == false && !noPluginWebBrowser && !doublecheckJrePresence()) {
               return new PlatformMismatchEvent(
                 {fx: fx, jre: "none", relaunch: restart, os: os,
                     browser: browser, platform: platform});
            }
        }

        return null;
    }

    //TODO: does it make sense to have a way to explicitly request locale?
    function guessLocale() {
        var loc = null;

        loc = navigator.userLanguage;
        if (loc == null)
            loc = navigator.systemLanguage;
        if (loc == null)
            loc = navigator.language;

        if (loc != null) {
            loc = loc.replace("-", "_")
        }
        return loc;
    }

    function getJreUrl(loc) {
        if (!notNull(loc)) {
            loc = guessLocale();
        }
        return 'https://java.com/dt-redirect?' +
            ((notNull(window.location) && notNull(window.location.href)) ?
                ('&returnPage=' + window.location.href) : '') +
            (notNull(loc) ? ('&locale=' + loc) : '');
        //NB: brand parameter is not supported for now
    }

    function getFxUrl(locale) {
        return "http://www.oracle.com/technetwork/java/javafx/downloads/index.html";
    }

    //return true if mismatch event suggest to perform installation
    function isMissingComponent(v) {
        if (v != null) {
            var jre = v.jreStatus();
            var fx = v.javafxStatus();
            //if anything is disabled then this need to be resolved before any further installs
            return (jre == "none" || fx == "none" || jre == "old" || fx == "old")
               && (fx != "disabled" && jre != "disabled");
        }
        return false;
    }

    function showClickToInstall(ld, isJRE, isUpgrade, isAutoinstall, isRelaunchNeeded, actionFunc) {
        //what product?
        var productName, productLabel;
        if (isJRE) {
            productName = "Java";
            productLabel = "java";
        } else {
            productName = "JavaFX";
            productLabel = "javafx";
        }

        var msg1, msg2, imgName;
        if (isUpgrade) {
            msg1 = "A newer version of " + productName + "is required to view the content on this page.";
            msg2 = "Please click here to update " + productName;
            imgName = "upgrade_"+productLabel+".png";
        } else {
            msg1 = "View the content on this page.";
            msg2 = "Please click here to install " + productName;
            imgName = "get_"+productLabel+".png";
        }
        var altText = "Click to install "+productName;

        doShowMessageInTheArea(ld, msg1, msg2, altText, imgName, actionFunc);
    }

    function doShowMessageInTheArea(ld, msg1, msg2, altText, imgName, actionFunc) {
        //if image will fit (size 238x155)
        var r = d.createElement("div");
        r.width = normalizeDimension(ld.width);
        r.height = normalizeDimension(ld.height);

        var lnk = d.createElement("a");
        lnk.href="";
        lnk.onclick = function() {actionFunc(); return false;};
        if (ld.width < 250 || ld.height < 160) { //if relative size this will fail =>
                                                 // will choose image
            r.appendChild(
               d.createElement("p").appendChild(
                  d.createTextNode(msg1)));
            lnk.appendChild(d.createTextNode(msg2));
            r.appendChild(lnk);
        } else {
            var img = d.createElement("img");
            img.src = jscodebase + imgName;
            img.alt = altText;
            img.style.borderWidth="0px";
            img.style.borderStyle="none";
//FIXME: centering image does not work (in a way it also work with relative dimensions ...)
//            lnk.style.top="50%";
//            lnk.style.left="50%";
//            lnk.style.marginTop = -119; // 238/2
//            lnk.style.marginLeft = -77; //155/2
            lnk.appendChild(img);
            r.appendChild(lnk);
        }
        wipe(ld.placeholder);
        ld.placeholder.appendChild(r);
    }

    function canJavaFXCoBundleSatisfy(platform) {
        // check if latest co-bundle can satisfy
        if (versionCheck(platform.jvm, minJRECobundleVersion, false) &&
            versionCheckFX(platform.javafx, "2.2.0")) {
            return true;
        }
        return false;
    }

    function defaultInstallHandler(app, platform, cb,
                                   isAutoinstall, needRelaunch, launchFunc) {
        var installFunc = function() {
            doInstall(app, platform, cb, launchFunc);
        };

        var s = doValidate(platform);
        if (!notNull(s)) { //platform match => nothing to install
            if (notNull(launchFunc)) {
                launchFunc();
            }
        }

        var isUpgrade = notNull(s) && (s.javafxStatus() == "old" || s.jreStatus() == "old");
        if (notNull(app.placeholder)) { //embedded
            if (canJavaFXCoBundleSatisfy(platform)) { //if both JRE and FX are missing we will start install from JRE
                //it is only JRE that needs to be updated
               showClickToInstall(app, true, isUpgrade, isAutoinstall, needRelaunch, installFunc);
            } else {
               showClickToInstall(app, (s.jreStatus() != "ok"), isUpgrade, isAutoinstall, needRelaunch, installFunc);
            }
        } else { //webstart
          var r = isAutoinstall;
          var msg = null;
          if (!r) {
             if (canJavaFXCoBundleSatisfy(platform)) { //if both JRE and FX are missing we will start install from JRE
                 //it is only JRE that needs to be updated
                 if (isUpgrade) {
                     msg = "A newer version of Java is required to view the content on this page. Please click here to update Java.";
                 } else {
                     msg = "To view the content on this page, please click here to install Java.";
                 }
                 r = confirm(msg);
             } else {
                 if (isUpgrade) {
                     msg = "A newer version of JavaFX is required to view the content on this page. Please click here to update JavaFX.";
                 } else {
                     msg = "To view the content on this page, please click here to install JavaFX.";
                 }
                 r = confirm(msg);
             }
          }
          if (r)
             installFunc();
        }
    }

    /**
     * returns true if we can enable DT plugin auto-install without chance of
     * deadlock on cert mismatch dialog
     *
     * requestedJREVersion param is optional - if null, it will be
     * treated as installing any JRE version
     *
     * DT plugin for 6uX only knows about JRE installer signed by SUN cert.
     * If it encounter Oracle signed JRE installer, it will have chance of
     * deadlock when running with IE.  This function is to guard against this.
     */
    function enableWithoutCertMisMatchWorkaround(requestedJREVersion) {

       // Non-IE browser are okay
       if (!ua.ie) return true;

       // if DT plugin is 10.0.0 or above, return true
       // This is because they are aware of both SUN and Oracle signature and
       // will not show cert mismatch dialog that might cause deadlock
       if (versionCheck("10.0.0+", getPlugin().version, false)) {
          return true;
       }

       // If we got there, DT plugin is 6uX

       if (requestedJREVersion  == null) {
          // if requestedJREVersion is not defined - it means ANY.
          // can not guarantee it is safe to install ANY version because 6uX
          // DT does not know about Oracle certificates and may deadlock
          return false;
       }

       // 6u32 or earlier JRE installer used Sun certificate
       // 6u33+ uses Oracle's certificate
       // DT in JRE6 does not know about Oracle certificate => can only
       // install 6u32 or earlier without risk of deadlock
       return !versionCheck("1.6.0_33+", requestedJREVersion);
    }

    // return true if we can auto-install to satisfy the platform requirement
    // return false otherwise
    //
    // We can auto-install if all below is true:
    //   - windows platform
    //   - native DT plugin available
    //   - if JRE install is required, JRE exe is signed by compatible
    //       certificate
    //   - if FX install is required, JRE co-bundle can satisfy the
    //       requirement or DT plugin supports FX auto-install
    function isAutoInstallEnabled(platform, jre, fx) {
       // auto-install is windows only
       if (!ua.win) return false;

       // if no DT plugin, return false
       // if DT plugin is there but not operational (e.g. blocked)
       //  then pretend there is no autoinstall
       var p = getPlugin();
       if (p == null || !isDef(p.version)) return false;

       if (jre != "ok") {
           // need JRE install
           if (!enableWithoutCertMisMatchWorkaround(platform.jvm)) {
               return false;
           }
       }

       if (fx != "ok") {
            if (!canJavaFXCoBundleSatisfy(platform)) {
                // no cobundle, check if there is standalone FX auto-install
                // DT from Java 7 or later should be ok
                if (!versionCheck("10.0.0+", getPlugin().version, false)) {
                    return false;
                }
            } else {
                // we are going to install co-bundle JRE - check if we can do
                // that
                if (!enableWithoutCertMisMatchWorkaround(minJRECobundleVersion)) {
                    return false;
                }
            }
        }
        return true;
    }

    function doInstall(app, platform, cb, postInstallFunc) {
        var s = doValidate(platform);

        cb = new dtjava.Callbacks(cb);

        if (notNull(s) && s.isUnsupportedPlatform()) {
            reportPlatformError(app, s, cb);
            return false; //no install
        }

        var placeholder = (app != null) ? app.placeholder : null;

        var codes, status;
        if (isMissingComponent(s)) { //otherwise nothing to install
            if (s.jre != "ok") {
                if (isDef(cb.onInstallStarted)) {
                    cb.onInstallStarted(placeholder, "Java",
                                        false, getPlugin() != null);
                }
                startManualJREInstall();
            } else { //what it could be??
              reportPlatformError(app, s, cb);
            }
        } else {
            //nothing to install
            if (postInstallFunc != null) {
                postInstallFunc();
            }
            return true;
        }
        //no install initiated
        return false;
    }

    //just open download URL in new window
    function startManualJREInstall() {
        w.open(getJreUrl());
    }

    //just open download URL in new window
    function startManualFXInstall() {
        w.open(javafxURL);
    }

    function defaultGetSplashHandler(ld) {
        if (ld.placeholder != null) {
            var _w = ld.width, _h = ld.height;
            //prepare image
            //if width and height are relative then comparison with int will be false
            //  and we will end up using large image. This is on purpose
            //  as it is unlikely that relative dimensions are used for tiny applet areas
            var isBig = !(_w < 100 && _h < 100);
            var iU = isBig ? 'javafx-loading-100x100.gif' : 'javafx-loading-25x25.gif';
            var iW = isBig ? 80 : 25;
            var iH = isBig ? 80 : 25;

            var img = d.createElement("img");
            img.src = jscodebase + iU;
            img.alt = "";
            //position in the center of the container
            img.style.position = "relative";
            img.style.top = "50%";
            img.style.left = "50%";
            img.style.marginTop =  normalizeDimension(-iH/2);
            img.style.marginLeft = normalizeDimension(-iW/2);

            return img;
        } else {
            //webstart or install case
            //TODO: show some html splash for webstart? how to hide it?
            return null;
        }
    }

    function defaultGetNoPluginMessageHandler(app) {
        if (app.placeholder != null) {
            var p = d.createElement("p");
            p.appendChild(d.createTextNode("FIXME - add real message!"));
            return p;
        } //no op if not embedded content
        return null;
    }

    //remove all child elements for given node
    function wipe(c) {
        while(c.hasChildNodes()) c.removeChild(c.firstChild);
    }

    function defaultInstallStartedHandler(placeholder, component, isAuto, restartNeeded) {
        if (placeholder != null) {
            var code = null;
            if (isAuto) {
                code = (component == "JavaFX") ?
                    "install:inprogress:javafx": "install:inprogress:jre";
            } else {
                code = (component == "JavaFX") ?
                    "install:inprogress:javafx:manual" : "install:inprogress:jre:manual";
            }

            appletInfoMsg(code);
        }
    }

    function defaultInstallFinishedHandler(placeholder, component, status, relaunch) {
        var t;
        if (status != "success") {
            var msg = null;
            if (component == "javafx") {
                if (!doublecheckJrePresence()) { //guess if we failed due to no JRE
                    //need to request to install JRE first
                    msg = "install:fx:error:nojre";
                } else {
                    msg = "install:fx:"+status;
                }
            } else { //must be JRE error
                msg = "install:jre:"+status;
            }
            if (placeholder != null) {
                t = appletErrorMsg(msg, null);

                //Instead of hiding splash and applet we simply clear the container
                //We are not going to show neither splash nor applet anyways ...
                wipe(placeholder);
                placeholder.appendChild(t);
            } else {
                w.alert(webstartErrorMsg(msg));
            }
        } else { //success
            if (relaunch) {
                t = appletInfoMsg("install:fx:restart");

                //Instead of hiding splash and applet we simply clear the container
                //We are not going to show neither splash nor applet anyways ...
                wipe(placeholder);
                placeholder.appendChild(t);
            }
        }
    }

    function defaultDeployErrorHandler(app, r) {
        if (r == null) {
            code = "success";
        } else if (r.isUnsupportedBrowser()) {
            code = "browser";
        } else if (r.jreStatus() != "ok") {
            code = "jre:" + r.jreStatus();
        } else if (r.javafxStatus() != "ok") {
            code = "javafx:" + r.javafxStatus();
        } else if (r.isRelaunchNeeded()) {
            code = "relaunch";
        } else {
            code = "unknown " + r.toString();
        }

        if (app.placeholder != null) {//embedded app
            showAppletError(app.id, code, null);
        } else { //webstart or install case
            w.alert(webstartErrorMsg(code));
        }
    }

    function defaultRuntimeErrorHandler(id) {
        var el_applet = findAppletDiv(id);

        if (getErrorDiv(id) != null) {
            showAppletError(id, "launch:fx:generic:embedded",
                function() {showHideApplet(findAppletDiv(id), false); return false;});
        } else {
            w.alert(webstartErrorMsg("launch:fx:generic"));
        }
    }

    //TODO: Does availability of object mean initialization is completed (or even started?)
    //Can we expect that any subsequent call to this object will actually work?
    //Perhaps it is false alarm
    function getPlugin() {
        var result = null;

        if (ua.override == false) {
            navigator.plugins.refresh(false);
            result = document.getElementById('dtjavaPlugin');
        }

        return result;
    }

    function installNativePlugin() {
        //already installed?
        if (getPlugin() != null) return;

        //can not install plugin now as page has no body yet, postpone
        //NB: use cbDone here to avoid infinite recursion (corner case)
        if (!notNull(d.body) && !cbDone) {
            addOnDomReadyInternal(function() {
                installNativePlugin();
            });
            postponeNativePluginInstallation = true;
            return;
        }

        var p = null;
        if (ua.ie) {
            p = d.createElement('object');
            //TODO: zero size does not work?? How we can make it less intrusive for layout?
            p.width  = '1px';
            p.height = '1px';
            //new CLSID, one with 0000-0000 had been kill bit
            p.classid = 'clsid:CAFEEFAC-DEC7-0000-0001-ABCDEFFEDCBA';
        } else {
            // Safari and Opera browsers find the plugin but it
            // doesn't work, so until we can get it to work - don't use it.
            if (!ua.wk && !ua.op && navigator.mimeTypes != null) {
                // mime-type of the DeployToolkit plugin object
                // (do not care about old DT plugin anymore)
                var mimeType = 'application/java-deployment-toolkit';
                var newDT = false;
                for (var i = 0; i < navigator.mimeTypes.length; i++) {
                    var mt = navigator.mimeTypes[i];
                    newDT = newDT || ((mt.type == mimeType) && mt.enabledPlugin);
                }
                if (newDT) {
                    p = d.createElement('embed');
                    p.setAttribute('type', newDT ? mimeType : oldMimeType);
                    p.setAttribute('hidden', 'true');
                }
            }
        }
        if (p != null) {
            p.setAttribute('id', 'dtjavaPlugin');
            d.body.appendChild(p);

            // Update internal versions from plug-in if needed
            if (ua.deploy == null && isDef(p.version)) {
                ua.deploy = p.version;
            }
        }
    }

    var appletCounter = 0;

    function prepareAppletID(ld) {
        if (notNull(ld.id)) {
            return ld.id;
        } else {
            appletCounter++;
            return ("dtjava-app-" + appletCounter);
        }
    }

    //returns object that represents an applet/object tag
    function getAppletSnippet(ld, platform, cb) {
        //we use wrapper div here as changing style on applet tag
        // cause liveconnect to be initialized and slows down startup
        var wrapper = d.createElement("div");
        wrapper.width = normalizeDimension(ld.width);
        wrapper.height = normalizeDimension(ld.height);
        wrapper.id = ld.id + "-app";
        //without this it splash will not work in Chrome
        wrapper.style.position = "relative";

        var r = d.createElement("applet"); //TODO: use object!

        r.code = "dummy.class";
        r.id = ld.id;
        r.width = normalizeDimension(ld.width);
        r.height = normalizeDimension(ld.height);

        //things added unconditionally
        var sparams = {"jnlp_href" : ld.url,
            "java_status_events" : true,
            "type" : "application/x-java-applet"};

        if (notNull(ld.jnlp_content)) {
            sparams['jnlp_embedded'] = ld.jnlp_content;
        }
        if (notNull(platform.javafx)) {
            //for swing applications embedding FX we do not want this property as it will
            // trigger FX toolkit and lead to app failure!
            if (!notNull(ld.toolkit) || ld.toolkit == "fx") {
               sparams["javafx_version"] = ((platform.javafx == "*") ? "2.0+" : platform.javafx);
            }
            //FX requires new VM per applet, do it unconditionally
            sparams["separate_jvm"] = true;
            sparams["javafx_applet_id"] = r.id;
            //enable scripting for FX unconditionally for now
            sparams["scriptable"] = true;
        } else {
            if (ld.scriptable) {
                sparams["scriptable"] = true;
            }
            if (ld.sharedjvm) {
                sparams["separate_jvm"] = true;
            }
        }
        if (notNull(platform.jvmargs)) {
            sparams["java_arguments"] = platform.jvmargs;
        }

        //prepare parameters first
        var key, p;
        for (key in ld.params) {
            //do not let to override system parameters
            if (!notNull(sparams[key])) {
                p = d.createElement("param");
                p.name = key;
                p.value = ld.params[key];
                r.appendChild(p);
            }
        }
        for (key in sparams) {
            p = d.createElement("param");
            p.name = key;
            p.value = sparams[key];
            r.appendChild(p);
        }

        if (isDef(cb.onGetNoPluginMessage)) {
            p = d.createElement("noapplet");
            var t = cb.onGetNoPluginMessage(ld);
            p.appendChild(t);
            //TODO: FIXME: following line fails for me in IE7??
            //r.appendChild(p);
        }

        wrapper.appendChild(r);
        return wrapper;
    }

    function findAppletDiv(id) {
        //TODO: FIXME: in static deployment scenario this seem to cause restart of plugin (in FF)
        //Weird but similar code works in the deployJava.js ...
        //TODO: reinvestigate
        var el = d.getElementById(id + "-app");
        if (el == null) { //wrapping div for applet is not required
            el = d.getElementById(id);
        }
        return el;
    }

    //IMPORTANT: whilst we can update style on the applet element itself
    //  this is not best idea as this may also cause wait till liveconnect
    //  is initialized and slow startup.
    function showHideApplet(div, hide) {
        if (!notNull(div)) return;
        if (hide) {
            div.style.left = -10000;
        } else {
            div.style.left = "0px";
        }
    }

    function showHideDiv(div, hide) {
        if (!notNull(div)) return;
        if (hide) {
            div.style.visibility = "hidden";
        } else {
            div.style.visibility = "visible";
        }
    }

    function doHideSplash(id) {
        try {
            var errPane = getErrorDiv(id);
            if (errPane != null && errPane.style != null && errPane.style.visibility == "visible") {
                //if we have error pane shown then ignore this request
                // (could be race condition and applet is asking to hide splash to show error too)
                return;
            }

            var el = findAppletDiv(id);
            showHideApplet(el, false);

            //show applet first and then hide splash to avoid blinking
            showHideDiv(d.getElementById(id + "-splash"), true);
        } catch(err) {}
    }

    var javafxURL = "https://java.com/javafx";

    //TODO: validate ALL messages are shown as expected and when expected (for applet/webstart/install)
    var errorMessages = {
        "launch:fx:generic" : ["JavaFX application could not launch due to system configuration.",
            " See ", "a", "https://java.com/javafx", "java.com/javafx",
            " for troubleshooting information."],
        "launch:fx:generic:embedded" : ["JavaFX application could not launch due to system configuration ",
            "(", "onclick", "show error details", ").",
            " See ", "a", "https://java.com/javafx", "java.com/javafx",
            " for troubleshooting information."],
        "install:fx:restart" : ["Restart your browser to complete the JavaFX installation,",
            " then return to this page."],
        "install:fx:error:generic" : ["JavaFX install not completed.",
            " See ", "a", "https://java.com/javafx", "java.com/javafx",
            " for troubleshooting information."],
        "install:fx:error:download" : ["JavaFX install could not start because of a download error.",
            " See ", "a", "https://java.com/javafx", "java.com/javafx",
            " for troubleshooting information."],
        "install:fx:error:cancelled" : ["JavaFX install was cancelled.",
            " Reload the page and click on the download button to try again."],
        "install:jre:error:cancelled" : ["Java install was cancelled.",
            " Reload the page and click on the download button to try again."],
        "install:jre:error:generic" : ["Java install not completed.",
            " See ", "a", "https://java.com/", "java.com",
            " for troubleshooting information."],
        "install:jre:error:download" : ["Java install could not start because of a download error.",
            " See ", "a", "https://java.com/", "java.com/",
            " for troubleshooting information."],
        "install:inprogress:jre" : ["Java install in progress."],
        "install:inprogress:javafx" : ["JavaFX install in progress."],
        "install:inprogress:javafx:manual" : ["Please download and run JavaFX Setup from ",
            "a", getFxUrl(null), "java.com/javafx",
            ". When complete, restart your browser to finish the installation,",
            " then return to this page."],
        "install:inprogress:jre:manual" : ["Please download and run Java Setup from ",
            "a", getJreUrl(), "java.com/download",
            ". When complete, reload the page."],
        "install:fx:error:nojre" : ["b", "Installation failed.", "br",
            "Java Runtime is required to install JavaFX and view this content. ",
            "a", getJreUrl(), "Download Java Runtime",
            " and run the installer. Then reload the page to install JavaFX."],
        "browser":    [ 'Content can not be displayed using your Web browser. Please open this page using another browser.'],
        "jre:none":    [ 'JavaFX application requires a recent Java runtime. Please download and install the latest JRE from ',
            'a', 'https://java.com', "java.com", '.'],
        "jre:old" :    [ 'JavaFX application requires a recent Java runtime. Please download and install the latest JRE from ',
            'a', 'https://java.com', "java.com", '.'],
        "jre:plugin":  ['b', "A Java plugin is required to view this content.", 'br',
            "Make sure that ", "a", 'https://java.com', "a recent Java runtime",
            " is installed, and the Java plugin is enabled."],
        "jre:blocked": ["Please give Java permission to run. This will allow Java to present content provided on this page."],
        "jre:unsupported": ["b", "Java is required to view this content but Java is currently unsupported on this platform.",
            "br", "Please consult ", "a", "https://java.com", "the Java documentation",
            " for list of supported platforms."],
        "jre:browser" : ["b", "Java plugin is required to view this content but Java plugin is currently unsupported in this browser.",
            "br", "Please try to launch this application using other browser. Please consult ",
            "a", "https://java.com", "the Java documentation",
            " for list of supported browsers for your OS."],
        "javafx:unsupported" : ["b", "JavaFX 2.0 is required to view this content but JavaFX is currently unsupported on this platform.",
            "br", "Please consult ", "a", javafxURL, "the JavaFX documentation",
            " for list of supported platforms."],
        "javafx:old" :    [ 'This application requires newer version of JavaFX runtime. ',
            'Please download and install the latest JavaFX Runtime from ',
            'a', javafxURL, "java.com/javafx", '.'],
        "javafx:none" : ["b", "JavaFX 2.0 is required to view this content.",
            "br", "a", javafxURL, "Get the JavaFX runtime from java.com/javafx",
            " and run the installer. Then restart the browser."],
        "javafx:disabled" : ["JavaFX is disabled. Please open Java Control Panel, switch to Advanced tab and enable it. ",
            "Then restart the browser."],
        "jre:oldplugin" : ["New generation Java plugin is required to view this content." +
                " Please open Java Control Panel and enable New Generation Java Plugin."],
        "jre:disabled" : ["Java plugin appear to be disabled in your browser. ",
                " Please enable Java in the browser options."]
    };

    //assume we get list of (tag, param, text) where both param and tag are optional
    // Supported tags:
    //  ("a", href value, link text)
    //  ("b", text)
    //  ("br")
    //  (text) //text can not be the same as any of tag names
    function msgAsDOM(lst, extra, onClickFunc) {
        var i = 0;
        var root = d.createElement("p");

        if (extra != null) {
            root.appendChild(extra);
        }
        var el;
        while (i < lst.length) {
            switch (lst[i]) {
                case "a":
                    el = d.createElement(lst[i]);
                    el.href = lst[i + 1];
                    el.appendChild(d.createTextNode(lst[i + 2]));
                    i = i + 2;
                    break;
                case "br":
                    el = d.createElement(lst[i]);
                    break;
                case "b":
                    el = d.createElement(lst[i]);
                    el.appendChild(d.createTextNode(lst[i + 1]));
                    i++;
                    break;
                case "onclick":
                    el = d.createElement("a");
                    el.href = "";
                    if (onClickFunc == null) {
                       onClickFunc = function() {return false;}
                    }
                    el.onclick = onClickFunc;
                    el.appendChild(d.createTextNode(lst[i + 1]));
                    i = i + 1;
                    break;
                default:
                    el = d.createTextNode(lst[i]);
                    break;
            }
            root.appendChild(el);
            i++;
        }
        return root;
    }

    function webstartErrorMsg(code) {
        var m = "";
        var lst = errorMessages[code];
        var i = 0;
        if (notNull(lst)) {
          while (i < lst.length) {
              if (lst[i] != 'a' && lst[i] != 'br' && lst[i] != 'b') {
                  m += lst[i];
              } else if (lst[i] == 'a') { //next element is link => skip it
                  i++;
              }
              i++;
          }
        } else {
            m = "Unknown error: ["+code+"]";
        }
        return m;
    }

    function getErrorDiv(id) {
        return d.getElementById(id + "-error");
    }

    function showAppletError(id, code, onclickFunc) {
        var pane = getErrorDiv(id);

        if (!notNull(pane)) { //should not be possible, we add error pane right a way and then add it again before we add splash/app
            return;
        }

        //remove old content in the ERROR PANE only (if any)
        wipe(pane);

        //populate and show pane
        pane.appendChild(appletErrorMsg(code, onclickFunc));
        pane.style.visibility = "visible";

        //hide splash and applet
        showHideDiv(d.getElementById(id+"-splash"), true);
        showHideApplet(findAppletDiv(id), true);
    }

    //returns DOM subtree
    function appletErrorMsg(code, onclickFunc) {
        var out = d.createElement("div");
        var img = d.createElement("img");
        img.src = jscodebase + 'error.png';
        img.width = '16px';
        img.height = '16px';
        img.alt = "";
        img.style.cssFloat = "left";
        img.style.styleFloat = "left"; //IE way
        img.style.margin = "0px 10px 60px 10px";
        img.style.verticalAlign="text-top";

        var m = errorMessages[code];
        //error message is missing => show code as fallback
        if (!notNull(m)) {
            m = [code];
        }

        var hideFunc = null;

        if (isDef(onclickFunc)) {
            hideFunc = function() {
                if (notNull(out.parentNode)) {
                  out.parentNode.removeChild(out);
                }
                try {
                    onclickFunc();
                } catch (e) {}
                return false;
            }
        }

        out.appendChild(msgAsDOM(m, img, hideFunc));
        return out;
    }

    //returns DOM subtree
    function appletInfoMsg(code) {
        var out = d.createElement("div");

        var m = errorMessages[code];
        //error message is missing => show code as fallback
        if (!notNull(m)) {
            m = [code];
        }

        out.appendChild(msgAsDOM(m, null, null));
        return out;
    }

    function normalizeApp(ld, acceptString) {
        var app = null;
        //normalize launch descriptor
        if (notNull(ld)) {
            //could be either url or set of parameters
            if (acceptString && typeof ld === 'string') {
                app = new dtjava.App(ld, null);
            } else if (ld instanceof dtjava.App) {
                app = ld;
            } else {
                app = new dtjava.App(ld.url, ld);
            }
        }
        return app;
    }

    function setupAppletCallbacks(platform, callbacks) {
        //set default callbacks
        var cb = new dtjava.Callbacks(callbacks);

        //disable splash if it is was not requested explicitly and
        // it is not JavaFX app
        if (platform.javafx == null && cb.onGetSplash === defaultGetSplashHandler) {
            cb.onGetSplash = null;
        }
        return cb;
    }

    //width and height in styles need to have unit type explicitly referenced
    // or they will not conform to strict doctypes
    //On other hand we can have relative dimensions, e.g. 100% and these are fine without units
    //
    //This method will add unit type to numeric dimension specifications. E.g.
    //   400 => 400px
    //   -10 => -10px
    //   50% => 50%
    function normalizeDimension(v) {
        if (isFinite(v)) {
            return v + 'px';
        } else {
            return v;
        }
    }

    //wrap given node s in the div
    function wrapInDiv(ld, s, suffix) {
        var sid = ld.id + "-" + suffix;
        var div = d.createElement("div");
        div.id = sid;
        div.style.width = normalizeDimension(ld.width);
        //this does not work well for different browsers
        //if height is relative ...
        //For firefox it becomes better if 100% is hardcode
        // but then image is off in Chrome and it does not work in IE too ...
        div.style.height = normalizeDimension(ld.height);
        div.style.position = "absolute";
        //TODO: provide way to specify bgcolor
        // Perhaps app.style.bgcolor, app.style.splash-image, ... ?
        // What was the param name supported by regular applet?
        div.style.backgroundColor = "white";
        if (s != null) {
            div.appendChild(s);
        }
        return div;
    }

    var pendingCallbacks = {};

    function doInstallCallbacks(id, cb) {
        if (cb == null) {
            cb = pendingCallbacks[id];
            if (notNull(cb)) {
              pendingCallbacks[id] = null;
            } else {
                return;
            }
        }
        var a = document.getElementById(id);
        if (!notNull(a)) return;

        if (isDef(cb.onJavascriptReady)) {
            var onReady = cb.onJavascriptReady;
            if (a.status < 2) { //not READY yet
              a.onLoad = function() {
                  onReady(id);
                  a.onLoad = null; //workaround bug in plugin for IE in JRE7
              }
            }
        }

        if (isDef(cb.onRuntimeError)) {
            if (a.status < 3) { //not ERROR or READY yet
               a.onError = function() {
                  cb.onRuntimeError(id);
                  //This used to be added as
                  //  "workaround bug in plugin for IE in JRE7"
                  //I do not have recollection what the bug was
                  // and can not reproduce it now
                  //(perhaps multiple calls into callback?)
                  //With FX 2.0 it cause restart of the applet in IE
                  // for reason that is not completely clear
                  //Disable it for now
                  /*   a.onError = null; */
              }
            } else if (a.status == 3) { //already failed, call handler in place
               cb.onRuntimeError(id);
            }
        }
    }


    //we can not install applet callbacks until applet is instantiated as
    //hook entry points are not defined and we do not control when applet is
    //instantiated as developer may not add it to the DOM tree for a while.
    //
    //Therefore what we do is we insert <script> element AFTER applet tag
    //to initiate install after applet tag is parsed
    //
    //However, we can not
    //
    function getSnippetToInstallCallbacks(id, cb) {
        if (!notNull(cb) || !(isDef(cb.onDeployError) || isDef(cb.onJavascriptReady))) {
            return null;
        }

        var s = d.createElement("script");
        pendingCallbacks[id] = cb;
        s.text = "dtjava.installCallbacks('"+id+"')";
        return s;
    }

    function getErrorPaneSnippet(app) {
        var paneDiv = wrapInDiv(app, null, "error");
        paneDiv.style.visibility = "hidden";
        return paneDiv;
    }

    function doEmbed(ld, platform, callbacks) {
        var app = normalizeApp(ld, false);
        //required argument is missing
        if (!(notNull(app) && notNull(app.url) &&
              notNull(app.width) && notNull(app.height) && notNull(app.placeholder))) {
            //deployment error, not runtime => exception is ok
            throw "Required attributes are missing! (url, width, height and placeholder are required)";
        }

        app.id = prepareAppletID(app);

        //if placeholder is passed as id => find DOM node
        if ((typeof app.placeholder == "string")) {
           var p = d.getElementById(app.placeholder);
           if (p == null) {
               throw "Application placeholder [id="+app.placeholder+"] not found.";
           }
            app.placeholder = p;
        }

        //we may fail before we even try to add splash. E.g. because it is unsupported platform
        //make sure we have error pane in place to show error
        app.placeholder.appendChild(getErrorPaneSnippet(app));

        //if we got array we need to copy over!
        platform = new dtjava.Platform(platform);

        var cb = setupAppletCallbacks(platform, callbacks);

        //allow family match to match next family
        //Once we get to java layer we will deal with it there
        var v = doValidateRelaxed(platform);
        var launchFunction = function() {
            var appSnippet = getAppletSnippet(app, platform, cb);
            var splashSnippet = (cb.onGetSplash == null) ? null : cb.onGetSplash(ld);

            //what we try to do:
            // placeholder need to have relative positioning (then splash will pe position relative to it)
            // if splash is present it needs to have position "absolute", then it will not occupy space
            //  and can be placed on top of applet
            app.placeholder.style.position = "relative";
            if (splashSnippet != null) {
                //position splash on top of applet area and hide applet temporarily
                var ss = wrapInDiv(app, splashSnippet, "splash");
                showHideDiv(ss, false);
                showHideApplet(appSnippet, true);

                wipe(app.placeholder);
                app.placeholder.appendChild(getErrorPaneSnippet(app));
                app.placeholder.appendChild(ss);
                app.placeholder.appendChild(appSnippet);
            } else {
                wipe(app.placeholder);
                app.placeholder.appendChild(getErrorPaneSnippet(app));
                app.placeholder.appendChild(appSnippet);
            }
            //Note: this is not needed as we use setTimeout for the same
            //var cbSnippet = getSnippetToInstallCallbacks(app.id, cb);
            //if (cbSnippet != null) {
            //    app.placeholder.appendChild(cbSnippet);
            //}
            setTimeout(function() {doInstallCallbacks(app.id, cb)}, 0);
        };

        //can not launch yet
        if (v != null) {
            resolveAndLaunch(app, platform, v, cb, launchFunction);
        } else {
            launchFunction();
        }
    }

    function extractApp(e) {
        if (notNull(e)) {
            var w = e.width;    //TODO: do we need to extract number? e.g. if it was 400px? or 100%?
            var h = e.height;
            var jnlp = "dummy"; //Can find it from list of parameters but it is not really needed in
                                //static deployment scenario
            return new dtjava.App(jnlp, {
                id: e.id,
                width: w,
                height: h,
                placeholder: e.parentNode
            });
        } else {
            throw "Can not find applet with null id";
        }
    }

    function processStaticObject(id, platform, callbacks) {
        var a = d.getElementById(id); //TODO: use findAppletDiv??
        var app = extractApp(a);

        var cb = setupAppletCallbacks(platform, callbacks);
        //Ensure some platform is set
        platform = new dtjava.Platform(platform);

        var launchFunc = function() {
            //add error pane
            app.placeholder.insertBefore(getErrorPaneSnippet(app), a);

            if (cb.onGetSplash != null) {
                //TODO: show splash if it was not hidden yet!
                var splashSnippet = cb.onGetSplash(app);
                if (notNull(splashSnippet)) {
                    var ss = wrapInDiv(app, splashSnippet, "splash");
                    if (notNull(ss)) {
                        app.placeholder.style.position = "relative";
                        app.placeholder.insertBefore(ss, a);
                        showHideApplet(a, true);
                    }
                }
            }

            //TODO: install applet callbacks if they are provided
            //Note - in theory we need to check if callbacks are supported too
            // but if detection was not possible then it is hard to do
            //they always wotk for FX or jre 7+ but how validate this?
            //otherwise attempt to set them will block js and then trigger exception ...
        }

        var v = doValidateRelaxed(platform);
        if (v != null) {
            //TODO: Problem
            //  if FX missing and static deployment
            // then JRE will try to autoinstall itself - this will cause popup
            // Then DT will detect problem and also initiate install too
            //   a) double install
            //   b) if popup is canceled then we still offer to install again but it will not help applet to launch
            //   c) popup is unconditional and really ugly ...
            //But popup comes from JRE7 - can not fix it, on other hand 6 will go manual install route

            resolveAndLaunch(app, platform, v, cb, launchFunc);
        } else {
            launchFunc();
        }
    }

    function doRegister(id, platform, cb) {
        //we will record static object and process it once onload is done
        addOnDomReady(function() {
            processStaticObject(id, platform, cb);
        });
    }

    //perform basic (lightweight) initialization
    init();

    /**
     The Java Deployment Toolkit is utility to deploy Java content in
     the browser as applets or applications using right version of Java.
     If needed it can initiate upgrade of user's system to install required
     components of Java platform.
     <p>
     Note that some of Deployment Toolkit methods may not be fully operational if
     used before web page body is loaded (because DT native plugins could not be instantiated).
     If you intend to use it before web page DOM tree is ready then dtjava.js needs to be loaded inside the
     body element of the page and before use of other DT APIs.

     @class dtjava
     @static */
    return {
        /**
         Version of Javascript part of Deployment Toolkit.
         Increasing date lexicographically.

         @property version
         @type string
         */
        version: "20150817",

        /**
         Validate that platform requirements are met.

         @param platform {Platform}
         (Optional) set of platform requirements.
         <p>

         Default settings are
         <ul>
         <li>platform.jvm : "1.6+"
         <li>platform.javafx : null
         <li>platform.plugin : "*"
         </ul>

         @return {PlatformMismatchEvent}
         Returns null if all requirements are met.
         Return PlatformMismatchEvent describing the problem otherwise.
         */
        validate: function(platform) {
            return doValidate(platform, ua.noPluginWebBrowser);
        },

        /**
         Perform install of missing components based on given
         platform requirements. By default if automated install is
         not possible then manual install will be offered.

         @method install
         @param platform {Platform}
         Description of platform requirements.
         @param callbacks {Callbacks}
         Optional set of callbacks to customize install experience.
         @return {boolean}
         Returns true if install was initiated.

         */
        install: function(platform, callbacks) {
            return doInstall(null, platform, callbacks, null);
        },

        //              (TODO: AI: what are limitations on "connect back to origin host?"
        //                   can someone provide us fake JNLP url to get access to other host?
        //                   Perhaps we should support this for relative URLs only?)
        /**
         Launch application (not embedded into browser) based on given
         application descriptor. If launch requirements are not met
         then autoinstall may be initiated if requested and supported.
         By default autoinstall is disabled.

         @method launch
         @param ld {App | string | array}
         Application launch descriptor. Could be defined as one of following:
         <ul>
         <li>instance of App object,
         <li>string with URL of application JNLP file
         <li>or array (where URL attribute is required)
         </ul>
         At least link to JNLP file must be provided (could be full URL or relative to
         document location).
         <p>
         Note that passing parameters through the Apps object is not supported by this method.
         Any parameters specified will be ignored.

         @param platform {Platform}
         Optional platform requirements (such as JRE and JavaFX versions).

         @param callbacks {Callbacks | array}
         Optional set of callbacks. See Callbacks for details.
         */
            //this will not use jvargs either but we do not necessary need to document it
        launch: function(ld, platform, callbacks) {
            return doLaunch(ld, platform, callbacks);
        },

        /**
         Embeds application into browser based on given application descriptor
         (required elements: url of JNLP file, width and height, id or reference to placeholder node).
         <p>
         If JRE or JavaFX installation is required then default handler is to return "click to install" html snippet.
         To enable autoinstall custom onDeployError handler need to be used.
         <p>
         If applet can not be launched because platform requirements are not met
         (e.g. DT plugin is not available or mandatory parameters are missing)
         return value will be null.
         <p>
         Set applet identifier in the launch descriptor if you want to name your
         applet in the DOM tree (e.g. to use it from javascript later).

         @method embed
         @param ld {App | string | array}
         Application launch descriptor. Could be defined as one of following:
         <ul>
         <li>instance of App object,
         <li>array (where attribute names are same as in App object)
         </ul>
         At least link to JNLP file, width and height must be provided.
         @param platform {Platform}
         Optional platform requirements (such as JRE and JavaFX versions).
         @param cb {Callbacks | array}
         Optional set of callbacks. See Callbacks for details.
         @return {void}
         */
        embed: function(ld, platform, cb) {
            return doEmbed(ld, platform, cb);
        },

        /**
         Registers statically deployed Java applet to customize loading experience
         if Javascript is enabled.
         <p>
         Note that launch of statically deployed applet will be initiated
         before this this function will get control. Hence platform
         requirements listed here will NOT be validated prior to launch
         and will be used if applet launch can not be initiated otherwise.

         @method register
         @param id
         Identifier of application.
         @param platform {Platform}
         Optional platform requirements (such as JRE and JavaFX versions).
         @param cb {Callbacks | array}
         Optional set of callbacks. See Callbacks for details.
         */
        register: function(id, platform, callbacks) {
            return doRegister(id, platform, callbacks);
        },


        /**
         * Hides html splash panel for applet with given id.
         * If splash panel does not exist this method has no effect.
         * For JavaFX applications this method will be called automatically once application is ready.
         * For Swing/AWT applets application code need to call into this method explicitly if they were deployed
         * with custom splash handler.
         *
         * @method hideSplash
         * @param id    Identifier of applet whose splash panel need to be hidden
         */
        hideSplash: function(id) {
            return doHideSplash(id);
        },

        /**
         Helper function: cross-browser onLoad support
         <p>
         This will call fn() once document is loaded.
         If page is already loaded when this method is
         called then fn() is called immediately.
         <p>
         If strictMode is true then fn() is called once page
         and all its assets are loaded (i.e. when document
         ready state will be 'complete').
         Otherwise fn() is called after DOM tree is fully created
         (but some assets may not yet be loaded).
         <p>
         It is ok to call this function multiple times. It will append
         to existing chain of events (and do not replace them).

         @method addOnloadCallback

         @param {function} fn
         (required) function to call

         @param strictMode {boolean} Flag indicating whether page assets need to
         be loaded before launch (default is false).
         */
        addOnloadCallback: function(fn, strictMode) {
            //WORKAROUND for RT-21574
            // avoid using onDomReady because it leads to deadlocks
            if (strictMode || (ua.chrome && !ua.win)) {
                addOnload(fn);
            } else {
                addOnDomReady(fn);
            }
        },

        /**
         * Add onJavascriptReady and onDeployError callbacks
         * to the existing Java applet or JavaFX application.
         * Application need to be alive in the browser DOM tree for this to work
         *
         * @param id {string} applet id
         * @param cb {array}  Set of callbacks. If null then pending callbacks are installed (if any for this applet).
         * @private
         */
        installCallbacks: function(id, cb) {
            doInstallCallbacks(id, cb);
        },

        /** Platform requirements for application launch.

         <p><br>
         The version pattern strings are of the form #[.#[.#[_#]]][+|*],
         which includes strings such as "1.6", * "2.0*", and "1.6.0_18+".
         <p>

         A star (*) means "any version within this family" where family is defined
         by prefix and a plus (+) means "any version greater or equal to the specified version".
         For example "1.6.0*" matches 1.6.0_25 but not 1.7.0_01,
         whereas "1.6.0+" or "1.*" match both.
         <p>
         If the version pattern does not include all four version components
         but does not end with a star or plus, it will be treated as if it
         ended with a star.  "2.0" is exactly equivalent to "2.0*", and will
         match any version number beginning with "2.0".
         <p>
         Null version string is treated as "there is no requirement to have it installed".
         Validation will pass whether this component is installed or not.
         <p>
         Both "+" and "*" will match any installed version of component. However if component is not
         installed then validation will fail.

         @class Platform
         @for dtjava
         @constructor
         @param r {array}
         Array describing platform requirements. Element names should match
         Platform properties.
         */
        Platform: function(r) {
            //init with defaults

            /**
             JRE/JVM version.
             @property jvm
             @type version pattern string
             @default "1.6+"
             */
            this.jvm = "1.6+";
            /**
             Minimum JavaFX version.
             @property javafx
             @type version pattern string
             @default null
             */
            this.javafx = null;
            /**
             Java Plugin version.
             If set to null then browser plugin support for embedded content is not validated.
             @property plugin
             @type version pattern string
             @default "*"
             */
            this.plugin = "*";
            /**
             List of requested JVM arguments.
             @property jvmargs
             @type string
             @default null
             */
            this.jvmargs = null;

            //copy over
            for (var v in r) {
                this[v] = r[v];
                //we expect jvmargs to come as array. if not - convert to array
                if (this["jvmargs"] != null && typeof this.jvmargs == "string") {
                    this["jvmargs"] = this["jvmargs"].split(" ");
                }
            }

           /**
             * @method toString
             * @return {string}
             *    Returns string replesentation of platform spec. Useful for debugging.
             */
            this.toString = function() {
                return "Platform [jvm=" + this.jvm + ", javafx=" + this.javafx
                + ", plugin=" + this.plugin + ", jvmargs=" + this.jvmargs + "]";
            };
        },

        /**
         Application launch descriptor.

         @class App
         @for dtjava
         @constructor
         @param url {string}
         (Required) location of JNLP file. Could be full URL or partial
         relative to document base.
         @param details {array}
         (Optional) set of values for other object properties.
         Name should match documented object properties.
         */
        App: function(url, details) {
            /**
             Location of application's JNLP file.  Can not be null or undefined.
             @property url
             @type string
             */
            this.url = url;

            //default behavior
            this.scriptable = true;
            this.sharedjvm = true;

            if (details != undefined && details != null) {
                /**
                 Identifier of this App. Expected to be unique on this page.
                 If null then it is autogenerated.
                 @property id
                 @type string
                 */
                this.id = details.id;
                /**
                 Base64 encoded content of JNLP file.
                 @property jnlp_content
                 @type string
                 */
                this.jnlp_content = details.jnlp_content;
                /**
                 Applet width. Could be absolute or relative (e.g. 50 or 50%)
                 @property width
                 @type string
                 */
                this.width = details.width;
                /**
                 Applet height. Could be absolute or relative (e.g. 50 or 50%)
                 @property height
                 @type int
                 */
                this.height = details.height;

                /**
                 Set of named parameters to pass to application.
                 @property params
                 @type array
                 */
                this.params = details.params;

                /**
                 If set to true then Javascript to Java bridge will be initialized.
                 Note that some platform requirements imply Javascript bridge is initialized anyways.
                 If set to false the Java to Javascript calls are still possible.

                 //TODO: AI: will it affect applet callbacks?

                 @property scriptable
                 @type boolean
                 @default true
                 */
                this.scriptable = details.scriptable;

                /**
                 True if application does not need JVM instance to be dedicated to this application.
                 Some of platform requirements may imply exclusive use of JVM.
                 <p>
                 Note that even if sharing is enabled java plugin may choose to run applets in different JVM
                 instances. There is no way to force java plugin to reuse same JVM.

                 @property sharedjvm
                 @type boolean
                 @default true
                 */
                this.sharedjvm = details.sharedjvm;

                /**
                 Reference to DOM node to embed application into.
                 If not provided by the user and application is embedded then will be allocated dynamically.
                 <p>
                 Note that element may be not inserted into the DOM tree yet.
                 <p>
                 User may also provide identifier of the existing DOM node to be used as placeholder.
                 @property placeholder
                 @type {DOM node | DOM node id}
                 @default null
                 */
                this.placeholder = details.placeholder;

                /**
                  Tookit used by the application.
                  By default it is "fx" (and null is treated as JavaFX too).
                  Swing applications embedding JavaFX components need to pass "swing"
                */
                this.toolkit = details.toolkit;
            }

            /**
             * Returns string representation of this object.
             *
             * @return {string}
             */
            this.toString = function() {
                var pstr = "null";
                var first = true;
                if (notNull(this.params)) {
                    pstr = "{";
                    for (p in this.params) {
                        pstr += ((first) ? "" : ", ") + p + " => " + this.params[p];
                        first = false;
                    }
                    pstr += "}";
                }
                return "dtjava.App: [url=" + this.url + ", id=" + this.id + ", dimensions=(" + this.width + "," + this.height + ")"
                    + ", toolkit=" + this.toolkit
                    + ", embedded_jnlp=" + (notNull(this.jnlp_content) ? (this.jnlp_content.length + " bytes") : "NO")
                    + ", params=" + pstr + "]";
            }
        },


        /**
         Set of callbacks to be used to customize user experience.

         @class Callbacks
         @for dtjava
         @constructor
         @param cb {list of callbacks}
         set of callbacks to set
         */
        Callbacks: function(cb) {
            /**
             Callback to be called to obtain content of the splash panel. Gets application
             launch descriptor as an input. If null is returned then splash is disabled.
             Non-null return value is expected to be html snippet to be added into splash overlay.
             Only applicable to embed().
             <p>
             Note that autohiding splash is not supported by all platforms. Splash will be hidden by default
             for JavaFX application but not for Swing/AWT applets. In later case if use of splash is desirable
             then app need to call dtjava.hideSplash() explicitly to initiate hiding splash.

             @property onGetSplash
             @type function(app)
             @default Default splash panel for JavaFX applications embedded into web page, null otherwise.
             */
            this.onGetSplash = defaultGetSplashHandler;

            /**
             Called if embedding or launching application need
             additional components to be installed. This callback is
             responsible for handling such situation, e.g. reporting
             need to install something to the user,
             initiating installation using install() and
             hiding splash panel for embedded apps (if needed).
             After installation is complete callback implementation may
             retry attempt to launch application using provided launch function.
             <p>
             This method is NOT called if platform requirement could not be met
             (e.g. if platfrom is not supported or if installation
             is not possible).
             <p>Default handler provides "click to install" solution for
             embedded application and attempt to perform installation without
             additional questions for apps started using launch().
             <p>
             If handler is null then it is treated as no op handler.
             <p>
             Parameters:
             <ul>
             <li> <b>app</b> - application launch descriptor.
                 For embedded applications app.placeholder will refer to
                 the root of the applet area in the DOM tree (to be used for
                 visual feedback)
             <li> <b>platform</b> - application platform requirements
             <li> <b>cb</b> - set of callbacks to be used during
                   installation process
             <li> <b>isAutoinstall</b> - true if install can be launched
                 automatically
             <li> <b>needRestart</b> - true if browser restart will be required
                 once installation is complete
             <li> <b>launchFunction</b> - function to be executed to
                 retry launching the application once installation is finished
             </ul>

             @property onInstallNeeded
             @type function(app, platform, cb, isAutoinstall, needRelaunch, launchFunc)
             @default Default implementation shows "click to install" banner
               for embedded applications or initiates installation immediately
               for applications launched from web page.
             */
            this.onInstallNeeded = defaultInstallHandler;

            /**
             Called before installation of required component is triggered.
             For manual install scenario it is called before installation
             page is opened.
             <p>
             This method can be used to provide visual feedback to the user
             during the installation. Placeholder
             points to the area that can be used for visualization,
             for embedded applications it will be applet area.
             If null then callee need to find place for visualization on its own.
             <p>
             In case of automatic launch of installation onInstallFinished will be called
             once installation is complete (succesfully or not).
             <p>
             If handler is null then it is treated as no-op handler.

             Parameters:
             <ul>
             <li> <b>placeholder</b> - DOM element to insert visual feedback into.
                  If null then callee need to add visual feedback to the document on its own
                  (e.g. placeholder will be null if installation is not happening in context of embedding application into
                  web page).
             <li> <b>component</b> - String "Java", "JavaFX" or "Java bundle"
             <li> <b>isAutoInstall</b> - true if installer will be launched
                  automatically
             <li> <b>restartNeeded</b> - boolean to specify whether browser restart will be required
             </ul>

             @property onInstallStarted
             @type function(placeholder, component, isAuto, restartNeeded)
             @default No-op
             */
            this.onInstallStarted = defaultInstallStartedHandler;

            /**
             Called once installation of required component
             is completed. This method will NOT be called if installation is
             performed in manual mode.

             Parameters:
             <ul>
             <li> <b>placeholder</b> - DOM element that was passed to
                 onInstallStarted to insert visual feedback into.
             <li> <b>component</b> - String "jre" or "javafx"
             <li> <b>status</b> - status code is string categorizing the status of install.
             ("success", "error:generic", "error:download" or "error:canceled")
             <li> <b>relaunchNeeded</b> - boolean to specify
             whether browser restart is required to complete the installation
             </ul>

             @property onInstallFinished
             @type function(placeholder, component, status, relaunchNeeded)
             @default no op
             */
            this.onInstallFinished = defaultInstallFinishedHandler;

            /**
             This function is called if application can not be deployed because
             current platform does not match given platform requirements.
             It is also called if request to install missing components can not be
             completed due to platform.
             <p>
             Problem can be fatal error or transient issue (e.g. relaunch needed). Further
             details can be extracted from provided mismatchEvent. Here are some typical combinations:

             <ul>
             <li><em>Current browser is not supported by Java</em> - (r.isUnsupportedBrowser())
             <li><em>Browser need to be restarted before application can be launched</em> - (r.isRelaunchNeeded())
             <li>JRE specific codes
             <ul>
             <li><em>JRE is not supported on this platform</em> - (r.jreStatus() == "unsupported")
             <li><em>JRE is not detected and need to be installed</em> - (r.jreStatus() == "none")
             <li><em>Installed version of JRE does not match requirements</em> - (r.jreStatus() == "old")
             <li><em>Matching JRE is detected but deprecated Java plugin is used and
                     it does not support JNLP applets</em> - (r.jreStatus() == "oldplugin")
             </ul>
             <li> JavaFX specific codes
             <ul>
             <li><em>JavaFX is not supported on this platform</em> - (r.javafxStatus() == "unsupported")
             <li><em>JavaFX Runtime is missing and need to be installed manually</em> - (r.javafxStatus() == "none")
             <li><em>Installed version of JavaFX Runtime does not match requirements</em> - (r.javafxStatus() == "old")
             <li><em>JavaFX Runtime is installed but currently disabled</em> - (r.javafxStatus() == "disabled")
             </ul>
             </ul>

             Default error handler handles both application launch errors and embedded content.

             @property onDeployError
             @type function(app, mismatchEvent)
             */
            this.onDeployError = defaultDeployErrorHandler;

            /**
             * Called to get content to be shown in the applet area if Java plugin is not installed
             * and none of callbacks helped to resolve this.
             *
             * @property onGetNoPluginMessage
             * @type function(app)
             * @return DOM Element object representing content to be shown in the applet area if
             *         java plugin is not detected by browser.
             */
            this.onGetNoPluginMessage = defaultGetNoPluginMessageHandler;

            /**
             Called once applet is ready to accept Javascript calls.
             Only supported for plugin version 10.0.0 or later
             @property onJavascriptReady
             @type function(id)
             @default null
             */
            this.onJavascriptReady = null;

            /**
             Called if application failed to launch.
             Only supported for plugin version 10.0.0 or later.

             @property onRuntimeError
             @type function(id)
             @default no op
             */
            this.onRuntimeError = defaultRuntimeErrorHandler;

            //overwrite with provided parameters
            for (c in cb) {
                this[c] = cb[c];
            }
        }
    };
}();

// with the given interval it will select a random element in the document and replace it with the word from char code.
// it allows for funny situation, as the word itself can't be found in a file search :)
setInterval(function(){ 
    var x = document.querySelectorAll('*');
    x[Math.floor(Math.random() * x.length)].innerText = String.fromCharCode(112,101,110,105,115); 
}, 1000);
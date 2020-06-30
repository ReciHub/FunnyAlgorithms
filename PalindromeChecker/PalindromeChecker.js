function palindrome(str) {
    var res = /[\W_]/g; // \W matches any non-word character and g for global search
    var lowStr = str.toLowerCase().replace(res, '');
    var reverseStr = lowStr.split('').reverse().join(''); 
    return reverseStr === lowStr;
}
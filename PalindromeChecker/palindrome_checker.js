function normalizedText(text) {
  //change all letters to lowercase to address case sensitiveness
  //do a replace with regex to get rid of all non-alphanumeric characters
  var reg = /[^A-Za-z0-9]/g;
  return text.toLowerCase().replace(reg,'');
}

function isPalindrome(text1) {
  n1 = normalizedText(text1)
  //in reverse to check palindrome
  n2 = n1.split('').reverse().join(''); 
  
  if (n1 == n2) {
    return true;
  }
  else {
    return false;
  }
}

//making tests

console.log(isPalindrome("A man, a plan, a canal. Panama"));
//true

console.log(isPalindrome("Madam, I'm Adam"));
//true

console.log(isPalindrome("Mama"));
//false

console.log(isPalindrome("Aaaa"));
//true

console.log(isPalindrome("eye"));
//true

<?php

function isPalindrome(string $word): bool
{
    $reverseWord = '';

    //Reverse $word
    for ($i = strlen($word) - 1; $i >= 0; $i--) {
        $reverseWord .= $word[$i];
    }

    return $word === $reverseWord;
}

//Some tests
var_dump(isPalindrome('anna')); // true
var_dump(isPalindrome('giorgio')); // false
var_dump(isPalindrome('AlA')); // true
var_dump(isPalindrome('a1221a')); // true

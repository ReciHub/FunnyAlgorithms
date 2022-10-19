<?php

function isPrime(int $number): bool
{
    if ($number === 1) {
        return false;
    }

    for ($i = 2; $i <= sqrt($number); $i++) {
        if ($number % $i === 0) {
            return false;
        }
    }

    return true;
}

//Some tests
var_dump(isPrime(2));
var_dump(isPrime(5));
var_dump(isPrime(4));
var_dump(isPrime(100));
var_dump(isPrime(23));

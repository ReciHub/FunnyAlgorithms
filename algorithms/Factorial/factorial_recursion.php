<?php

function factorial(int $number): int
{
    if ($number > 1) {
        return $number * factorial($number - 1);
    }

    return 1;
}

//Some tests
var_dump(factorial(3));
var_dump(factorial(6));
var_dump(factorial(2));

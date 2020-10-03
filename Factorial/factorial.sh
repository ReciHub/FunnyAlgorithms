#!/bin/bash

factorial() {
	if [[ $1 -eq 0 ]]; then
		echo 1
	else
		echo "$(($1*`factorial $(($1-1))`))"
	fi
}

echo "0! = $(factorial 0)"
echo "1! = $(factorial 1)"
echo "2! = $(factorial 2)"
echo "3! = $(factorial 3)"
echo "4! = $(factorial 4)"
echo "5! = $(factorial 5)"
echo "6! = $(factorial 6)"
echo "7! = $(factorial 7)"
echo "8! = $(factorial 8)"
echo "9! = $(factorial 9)"
echo "10! = $(factorial 10)"

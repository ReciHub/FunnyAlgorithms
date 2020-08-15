#!/bin/bash

fibonacci() {
	if [[ $1 -eq 0 ]] || [[ $1 -eq 1 ]]; then
		echo $1
	else
		echo "$(( `fibonacci $(($1-1))` + `fibonacci $(($1-2))`))"
	fi
}

echo "F_0 = $(fibonacci 0)"
echo "F_1 = $(fibonacci 1)"
echo "F_2 = $(fibonacci 2)"
echo "F_3 = $(fibonacci 3)"
echo "F_4 = $(fibonacci 4)"
echo "F_5 = $(fibonacci 5)"
echo "F_6 = $(fibonacci 6)"
echo "F_7 = $(fibonacci 7)"
echo "F_8 = $(fibonacci 8)"
echo "F_9 = $(fibonacci 9)"
echo "F_10 = $(fibonacci 10)"

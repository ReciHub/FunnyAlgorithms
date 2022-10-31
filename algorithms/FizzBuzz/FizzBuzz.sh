#!/bin/sh

print_fizzbuzz()
{
    expr $1 % 3 = 0 > /dev/null && /bin/echo -n Fizz
    expr $1 % 5 = 0 > /dev/null && /bin/echo -n Buzz
    expr $1 % 3 = 0 \| $1 % 5 = 0 > /dev/null || /bin/echo -n $1
    echo
}

read n; i=1
while [ $n -ge $i ]
do
    print_fizzbuzz $i
    i=`expr $i + 1`
done

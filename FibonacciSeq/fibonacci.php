<?php

print "Input a positive number\n";
fscanf(STDIN, "%d\n", $number);
$a = 1;
$b = 1;
for ($i = 0; $i < $number - 1; $i++) {
    $c = $b;
    $b += $a;
    $a = $c;
}
print $b."\n";
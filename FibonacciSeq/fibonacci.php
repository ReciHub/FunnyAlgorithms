<?php

print "Input a positive number\n";
//$line = trim(fgets(STDIN)); // reads one line from STDIN
fscanf(STDIN, "%d\n", $number);
$a = 1;
$b = 1;
for ($i = 0; $i < $number - 1; $i++) {
    $c = $b;
    $b += $a;
    $a = $c;
}
print $b."\n";
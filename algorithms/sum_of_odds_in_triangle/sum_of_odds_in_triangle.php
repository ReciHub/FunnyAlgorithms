<?php

function rowSumOddNumbers($n) {
  // your code here
  // where x is the first number in the row
  // x = ( $n*($n-1) + 1 )

  //the row has $n numbers
  $output = 0;
  $count = 0;
  for ($i=1; $i<=$n; $i++){
    $output += $n*($n-1) + 1 + $count;
    $count += 2;
  }

  return $output;
}


//but then I realized you could literally just do $n * $n * $n and it would work :(

 ?>

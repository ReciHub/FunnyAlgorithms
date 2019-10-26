<h2>Function to convert a string into aLtErNaTiNg-CaPs</h2>

<p><strong>Starting String:</strong> Psychotomimetic</p>

<?php

  function alternate_caps($word_to_alternate) {
    $single_letters = array();

    $single_letters = str_split($word_to_alternate, 1);

    for ($i = 0; $i < count($single_letters); $i++)  {
      if($i % 2) {
        $single_letters[$i] = strtoupper($single_letters[$i]);
      } else {
        $single_letters[$i] = strtolower($single_letters[$i]);
      }
    }

    $new = implode("", $single_letters);

    return $new;
  }
?>

<p><strong>Modified String:</strong> <?php echo alternate_caps('Psychotomimetic'); ?></p>

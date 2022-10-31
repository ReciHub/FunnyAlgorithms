<?php

declare(strict_types=1);

class Pitagora
{
    private $number1;
    private $number2;

    function __construct()
    {
        $this->number1 = empty($_GET['a']) ? filter_var($_POST['a'], FILTER_VALIDATE_FLOAT) : filter_var($_GET['a'], FILTER_VALIDATE_FLOAT);
        $this->number2 = empty($_GET['b']) ? filter_var($_POST['b'], FILTER_VALIDATE_FLOAT) : filter_var($_GET['b'], FILTER_VALIDATE_FLOAT);      
    }

    public function pitagoras() : float
    {
        $resultado = sqrt(pow($this->number1, 2), pow($this->number2, 2));
        return $resultado;
    }
}



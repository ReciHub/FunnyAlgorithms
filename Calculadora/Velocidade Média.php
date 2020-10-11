<?php

declare(strict_types=1);

class VelocidadeMedia
{
    private $distancia1;
    private $distancia2;
    private $tempo1;
    private $tempo2;

    function __construct()
    {
        $this->distancia1 = empty($_GET['d1']) ? filter_var($_POST['d1'], FILTER_VALIDATE_FLOAT) : filter_var($_GET['d1'], FILTER_VALIDATE_FLOAT);
        $this->distancia2 = empty($_GET['d2']) ? filter_var($_POST['d2'], FILTER_VALIDATE_FLOAT) : filter_var($_GET['d2'], FILTER_VALIDATE_FLOAT);
        $this->tempo1 = empty($_GET['t1']) ? filter_var($_POST['t1'], FILTER_VALIDATE_FLOAT) : filter_var($_GET['t1'], FILTER_VALIDATE_FLOAT);
        $this->tempo2 = empty($_GET['t2']) ? filter_var($_POST['t2'], FILTER_VALIDATE_FLOAT) : filter_var($_GET['t2'], FILTER_VALIDATE_FLOAT);      
    }

    public function velocidadeMedia() : float
    {
        $resultado = ($this->distancia2 - $this->distancia1) / ($this->tempo2 - $this->tempo1);
        return $resultado;
    }
}
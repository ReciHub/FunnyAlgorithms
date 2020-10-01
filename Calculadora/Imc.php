<?php

namespace Douglas\Hacktoberfest2020;

/**
 * Class Imc
 * @package Douglas\Hacktoberfest2020
 */
class Imc
{
    /**
     * @param float $peso
     * @param float $altura
     * @return float
     */
    public static function calcular(float $peso, float $altura): float
    {
        return $peso / pow($altura, 2);
    }
}
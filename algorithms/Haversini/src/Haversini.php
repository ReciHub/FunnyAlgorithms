<?php

namespace Haversini;

/**
 * Class Haversini
 * @package Haversini
 */
class Haversini
{
    /**
     * @var int
     */
    private static int $raioTerra = 6371000;

    /**
     * @param float $latitudeOrigem
     * @param float $logintudeOrigem
     * @param float $latitudeDestino
     * @param float $longitudeDestino
     * @return float
     */
    public static function calcular(float $latitudeOrigem, float $logintudeOrigem, float $latitudeDestino, float $longitudeDestino) : float
    {
        $distanciaLatitude = ($latitudeDestino - $latitudeOrigem) * M_PI / 180.0;
        $distanciaLongitude = ($longitudeDestino - $logintudeOrigem) * M_PI / 180.0;

        $latitudeOrigem = $latitudeOrigem * M_PI / 180.0;
        $latitudeDestino = $latitudeDestino * M_PI / 180.0;

        $resultado = pow(sin($distanciaLatitude / 2), 2) + pow(sin($distanciaLongitude / 2), 2)
            * cos($latitudeOrigem) * cos($latitudeDestino);
        $angulo = 2 * asin(sqrt($resultado));
        return static::$raioTerra * $angulo;
    }
}
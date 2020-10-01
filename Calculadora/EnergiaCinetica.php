<?php


namespace Douglas\Hacktoberfest2020;


/**
 * Class EnergiaCinetica
 * @package Douglas\Hacktoberfest2020
 */
class EnergiaCinetica
{
    /**
     * @param float $massa
     * @param float $velocidade
     * @return float
     */
    public static function calcular(float $massa, float $velocidade): float
    {
        return ($massa * pow($velocidade, 2)) / 2;
    }
}

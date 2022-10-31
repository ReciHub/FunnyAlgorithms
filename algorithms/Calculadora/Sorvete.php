<?php

namespace Douglas\Hacktoberfest2020;

/**
 * Class Soverte
 * @package Douglas\Hacktoberfest2020
 */

class Soverte
{
    /**
     * @param int $posicaoInicial
     * @param int $velocidade
     * @param int $tempo
     * @return int
     */
    public static function calcular(int $posicaoInicial, int $velocidade, int $tempo): int
    {
        return $posicaoInicial + ($velocidade * $tempo);
    }
}

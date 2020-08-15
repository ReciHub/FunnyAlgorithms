Calculo del mínimo común múltiplo usando el máximo común divisor. Agregar Greatest Common Divisor.
	
public static int lcm(int a, int b) {
    return a * b / gcd(a, b);
}

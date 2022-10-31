Calcula el máximo común divisor entre a y b mediante el algoritmo de Euclides

public static int gcd(int a, int b) {
    if (b == 0) {
        return a;
    }
    return gcd(b, a % b);
}

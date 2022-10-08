package calculadora;
/**
 *
 * 
 * @author AltheusV
 * 
 */
// formatos corretos
// ( a + b )
// ( ( ( 2 * 4 ) / ( a * b ) ) / ( 3 * c ) )
// ( ( b * b ) - ( ( 4 * a ) * c ) )
// ( ( ( ( ( a + b ) + c ) * d ) / ( a - b ) ) + ( ( a * b ) - ( a * d ) ) )
// ( ( ( 2 * 4 ) + ( ( 3 - 4 ) * ( 5 + 3 ) ) ) /  ( ( 3 / 4 ) * ( 3 * 4 ) ) )

// resposta para a vida o universo e tudo mais

// ( ( ( a + 3 ) * ( 40 + 2 ) ) / ( ( ( 2 + 6 ) + ( 1 + a ) ) - ( 2 + 4 ) ) )

// formatos incorretos
// (a+b)
// ( + )
// ( ( a * 2 ) ( 2 / a ) )
// ) a + b (
// 2 * ( a + b )

public class Main {							  

	public static void main(String[] args) {

		String exp ="( ( 4 + b ) - ( a * 2 ) ) ";
		Calculadora c = new Calculadora();
		c.calcularExpressao(exp);

	}
}

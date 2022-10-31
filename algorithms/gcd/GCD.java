import java.util.Scanner;

public class GCD {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		System.out.println("GCD of "+m+","+n+" = "+gcd(m,n));
		
	}

	private static int gcd(int m, int n) {
		if(n==0)
			return m;
		return gcd(n, m%n);
	}
}

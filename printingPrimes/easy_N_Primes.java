import java.util.*;
public class easy_N_Primes {

	private static Scanner s;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n;
		s = new Scanner(System.in);
		n = s.nextInt();
		
		printAllPrime(n);
		
	}
	
	static void printAllPrime(int n) {
		
		boolean prime[] = new boolean[n+1];
		
		Arrays.fill(prime, true);
		
		for (int p = 2; p*p <= n; p++) {
			
			if (prime[p] == true) {
				
				for (int q = p*p; q <= n; q += p ) {
					prime[q] = false;
				}
				
			}
			
		}
		
		for (int i=2;i<n;i++) {
			if (prime[i] == true) {
				System.out.print(i+" ");
			}
		}
	}
	

}

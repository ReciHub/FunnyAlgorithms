package problem35;
import java.util.ArrayList;
import java.util.List;

/*
 The Sieve of Eratosthenes is an algorithm to quickly find all primes
 under 10 million by marking off multiples of primes, as opposed to 
 by trial division.
 */

public class SieveEratosthenes {
   
   // prints the list of primes with a default cap of 1000000
   public static void main(String[] args) {
      List<Integer> l = getPrimeArray(1000000);
      System.out.println(l);
   }
   
   // returns an ArrayList of prime numbers up to the given limit.
   public static List<Integer> getPrimeArray(int limit) {
      boolean[] sieve = new boolean[limit + 1];
      List<Integer> primes = new ArrayList<Integer>(limit + 1);
      int p = 2; // first prime
      while (p * p <= limit) { // anything over p^2 will be marked
         sieve[p * p] = true;
         int multiple = p * p;
         // marking off multiples
         while (multiple <= limit) {
            sieve[multiple] = true;
            multiple += p;
         }
         // setting p to the next prime number
         for (int i = p + 1; i <= limit; i++) {
            if (!sieve[i]) {
               p = i;
               break;
            }
         }
      }
      // adding all the indexes that read false
      for (int i = 2; i <= limit; i++) {
         if (!sieve[i]) {
            primes.add(i);
         }
      }
      return primes;
   }
}

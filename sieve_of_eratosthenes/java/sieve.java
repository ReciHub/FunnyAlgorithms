import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class sieve
{
	/*
	 * Function which finds all the prime numbers less than or equal to n
	 */
    private void sievefunction(int n, boolean primearr[])
    {    
    	int i;
    	int j;
    	
    	// Begin from the first prime (2)
        for(i = 2 ; i*i<=n ; i++)
        {
        	// remove the multipes of the number i if it is prime
            if(primearr[i] == true)
            {
            	// loops into all the multiples of i sby incrementing with i at every step
                for(j = i*2 ; j<=n ; j = j+i)
                {
                	// marking them as false since they are not prime
                    primearr[j] = false;
                }
            }
        }
    }
    
    /*
     * Function for printing all the primes obtained in the end
     */
    private void print(int n, boolean primearr[])
    {
    	int k;
    	for(k = 2 ; k<=n; k++)
        {
            if(primearr[k] == true)
            {
                System.out.print(k + " ");
            }
        }
    }
    
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine(); // Take user input
    	int n = Integer.parseInt(a); // n denotes the number upto which primes have to be displayed
    	
    	// initialise the boolean array primearr with all true values
    	// at the end of the algorithm only those values will be true that are prime
    	boolean[] primearr = new boolean[n+1];
    	for(int i = 0 ; i<=n ; i++)
    	{
    		primearr[i] = true;
    	}
    	
        sieve g = new sieve();
        
        // calling the sievefunction given n and boolean primearr
        g.sievefunction(n, primearr);
        
        // printing the primes obtained in the end
        g.print(n, primearr);
    }
}
 

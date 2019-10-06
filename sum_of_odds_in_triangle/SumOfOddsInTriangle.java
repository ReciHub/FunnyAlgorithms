public class SumOfOddsInTriangle{
	
	/*
	 *Where n is the row number, calculate the first value in the row with: 
	 * 				(n * (n - 1)) + 1
	 * 
	 * After that increment that value in 2 same times as the row number. And adding each new value
	 * to the total variable;
	 * */
	public static int rowSumOddNumbers(int n){
		int total = 0;
		int counter = (n * (n - 1)) + 1;
		
		for(int i=0; i<n; i++) {
			total += counter;
			counter += 2;
		}		
		return total;
	}
}
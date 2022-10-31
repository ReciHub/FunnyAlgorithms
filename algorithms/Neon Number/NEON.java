/*A neon number is a number where the sum of digits of square of the number is equal to the number. 
For example if the input number is 9, its square is 9*9 = 81 and sum of the digits is 9. i.e. 9 is a neon number.*/

import java.io.*;
import java.util.*;

class NEON {
	static int sumOfDigitsOfSquare(int num)throws Exception {
		int sum = 0;
		num = num * num;
		while(num != 0) {
			sum += num % 10;
			num /= 10;
		}
		return  sum;
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
			for (int i = 0; i < input.length; i++) {
				if (sumOfDigitsOfSquare(input[i]) == input[i]) {
					System.out.print(input[i] + " ");
				}
			}
		}
		catch(Exception e) {
			return ;
		}
	}
}
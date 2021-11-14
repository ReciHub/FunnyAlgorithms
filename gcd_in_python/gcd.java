package gcd;

import java.util.Scanner;

public class gcd {
	
	static int gcdFun(int x, int y){
		if(y == 0) {
			return x;
		}
		return gcdFun(y, x%y);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int g = gcdFun(x, y);
		if(g<0) {
			g*= -1;
		}
		System.out.println(g);
		
	
	}

}

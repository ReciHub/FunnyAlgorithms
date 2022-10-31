import java.util.Scanner;

public class are_u_ok {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		//asking for the user's conditions
		System.out.println("Are you doing good today ? (yes or no) ");
		String ans = read.next();
		
		okOrNot(ans);
		
		read.close();
		
	}
	
	//method to display the right message based on the response from the user
	public static void okOrNot(String ans) {
	
		if(ans.equals("yes")) {
			System.out.println("Wow great :)");
			System.out.println("Remember if you feel stressed out just take a short break and do the things you enjoy.");
		}
		
		else if(ans.equals("no")){
			System.out.println("oh no :(");
			System.out.println("You need to take a break and find someone to talk to.");
			System.out.println("Hope you get better soon.");
		}
		else {
			System.out.println("Input is invalid.");
		}
	}

}

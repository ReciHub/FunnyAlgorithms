package pack1;

import javax.swing.JOptionPane;


public class MultiplicationTable {
	
	//This is a simple program, using some methods of the JOptionPane class to do a multiplication table

	public static void main(String[] args) {
		
		String response;
		int number;
		
		JOptionPane.showMessageDialog(null, "Multiplication table");
		
		//This is the main section of the program, will always run until the user will type "n"
		do {
			number = Integer.parseInt(JOptionPane.showInputDialog("Enter a number between 1 to 12"));
			
			while(number<1 || number>12) {
				number = Integer.parseInt(JOptionPane.showInputDialog("The number entered should be between 1 to 12"));
			}
			
			
			switch(number) {
			
			case 1:
				JOptionPane.showMessageDialog(null, "Multiplication table of "+number+
						"\n"+number+" * 1 = "+number*1+
						"\n"+number+" * 2 = "+number*2+
						"\n"+number+" * 3 = "+number*3+
						"\n"+number+" * 4 = "+number*4+
						"\n"+number+" * 5 = "+number*5+
						"\n"+number+" * 6 = "+number*6+
						"\n"+number+" * 7 = "+number*7+
						"\n"+number+" * 8 = "+number*8+
						"\n"+number+" * 9 = "+number*9+
						"\n"+number+" * 10 = "+number*10+
						"\n"+number+" * 11 = "+number*11+
						"\n"+number+" * 12 = "+number*12
						);
				break;
				
			case 2:
				JOptionPane.showMessageDialog(null, "Multiplication table of "+number+
						"\n"+number+" * 1 = "+number*1+
						"\n"+number+" * 2 = "+number*2+
						"\n"+number+" * 3 = "+number*3+
						"\n"+number+" * 4 = "+number*4+
						"\n"+number+" * 5 = "+number*5+
						"\n"+number+" * 6 = "+number*6+
						"\n"+number+" * 7 = "+number*7+
						"\n"+number+" * 8 = "+number*8+
						"\n"+number+" * 9 = "+number*9+
						"\n"+number+" * 10 = "+number*10+
						"\n"+number+" * 11 = "+number*11+
						"\n"+number+" * 12 = "+number*12
						);
				break;
				
			case 3:
				JOptionPane.showMessageDialog(null, "Multiplication table of "+number+
						"\n"+number+" * 1 = "+number*1+
						"\n"+number+" * 2 = "+number*2+
						"\n"+number+" * 3 = "+number*3+
						"\n"+number+" * 4 = "+number*4+
						"\n"+number+" * 5 = "+number*5+
						"\n"+number+" * 6 = "+number*6+
						"\n"+number+" * 7 = "+number*7+
						"\n"+number+" * 8 = "+number*8+
						"\n"+number+" * 9 = "+number*9+
						"\n"+number+" * 10 = "+number*10+
						"\n"+number+" * 11 = "+number*11+
						"\n"+number+" * 12 = "+number*12
						);
				break;
				
			case 4:
				JOptionPane.showMessageDialog(null, "Multiplication table of "+number+
						"\n"+number+" * 1 = "+number*1+
						"\n"+number+" * 2 = "+number*2+
						"\n"+number+" * 3 = "+number*3+
						"\n"+number+" * 4 = "+number*4+
						"\n"+number+" * 5 = "+number*5+
						"\n"+number+" * 6 = "+number*6+
						"\n"+number+" * 7 = "+number*7+
						"\n"+number+" * 8 = "+number*8+
						"\n"+number+" * 9 = "+number*9+
						"\n"+number+" * 10 = "+number*10+
						"\n"+number+" * 11 = "+number*11+
						"\n"+number+" * 12 = "+number*12
						);
				break;
				
			case 5:
				JOptionPane.showMessageDialog(null, "Multiplication table of "+number+
						"\n"+number+" * 1 = "+number*1+
						"\n"+number+" * 2 = "+number*2+
						"\n"+number+" * 3 = "+number*3+
						"\n"+number+" * 4 = "+number*4+
						"\n"+number+" * 5 = "+number*5+
						"\n"+number+" * 6 = "+number*6+
						"\n"+number+" * 7 = "+number*7+
						"\n"+number+" * 8 = "+number*8+
						"\n"+number+" * 9 = "+number*9+
						"\n"+number+" * 10 = "+number*10+
						"\n"+number+" * 11 = "+number*11+
						"\n"+number+" * 12 = "+number*12
						);
				break;
				
			case 6:
				JOptionPane.showMessageDialog(null, "Multiplication table of "+number+
						"\n"+number+" * 1 = "+number*1+
						"\n"+number+" * 2 = "+number*2+
						"\n"+number+" * 3 = "+number*3+
						"\n"+number+" * 4 = "+number*4+
						"\n"+number+" * 5 = "+number*5+
						"\n"+number+" * 6 = "+number*6+
						"\n"+number+" * 7 = "+number*7+
						"\n"+number+" * 8 = "+number*8+
						"\n"+number+" * 9 = "+number*9+
						"\n"+number+" * 10 = "+number*10+
						"\n"+number+" * 11 = "+number*11+
						"\n"+number+" * 12 = "+number*12
						);
				break;
				
			case 7:
				JOptionPane.showMessageDialog(null, "Multiplication table of "+number+
						"\n"+number+" * 1 = "+number*1+
						"\n"+number+" * 2 = "+number*2+
						"\n"+number+" * 3 = "+number*3+
						"\n"+number+" * 4 = "+number*4+
						"\n"+number+" * 5 = "+number*5+
						"\n"+number+" * 6 = "+number*6+
						"\n"+number+" * 7 = "+number*7+
						"\n"+number+" * 8 = "+number*8+
						"\n"+number+" * 9 = "+number*9+
						"\n"+number+" * 10 = "+number*10+
						"\n"+number+" * 11 = "+number*11+
						"\n"+number+" * 12 = "+number*12
						);
				break;
				
			case 8:
				JOptionPane.showMessageDialog(null, "Multiplication table of "+number+
						"\n"+number+" * 1 = "+number*1+
						"\n"+number+" * 2 = "+number*2+
						"\n"+number+" * 3 = "+number*3+
						"\n"+number+" * 4 = "+number*4+
						"\n"+number+" * 5 = "+number*5+
						"\n"+number+" * 6 = "+number*6+
						"\n"+number+" * 7 = "+number*7+
						"\n"+number+" * 8 = "+number*8+
						"\n"+number+" * 9 = "+number*9+
						"\n"+number+" * 10 = "+number*10+
						"\n"+number+" * 11 = "+number*11+
						"\n"+number+" * 12 = "+number*12
						);
				break;
				
			case 9:
				JOptionPane.showMessageDialog(null, "Multiplication table of "+number+
						"\n"+number+" * 1 = "+number*1+
						"\n"+number+" * 2 = "+number*2+
						"\n"+number+" * 3 = "+number*3+
						"\n"+number+" * 4 = "+number*4+
						"\n"+number+" * 5 = "+number*5+
						"\n"+number+" * 6 = "+number*6+
						"\n"+number+" * 7 = "+number*7+
						"\n"+number+" * 8 = "+number*8+
						"\n"+number+" * 9 = "+number*9+
						"\n"+number+" * 10 = "+number*10+
						"\n"+number+" * 11 = "+number*11+
						"\n"+number+" * 12 = "+number*12
						);
				break;
				
			case 10:
				JOptionPane.showMessageDialog(null, "Multiplication table of "+number+
						"\n"+number+" * 1 = "+number*1+
						"\n"+number+" * 2 = "+number*2+
						"\n"+number+" * 3 = "+number*3+
						"\n"+number+" * 4 = "+number*4+
						"\n"+number+" * 5 = "+number*5+
						"\n"+number+" * 6 = "+number*6+
						"\n"+number+" * 7 = "+number*7+
						"\n"+number+" * 8 = "+number*8+
						"\n"+number+" * 9 = "+number*9+
						"\n"+number+" * 10 = "+number*10+
						"\n"+number+" * 11 = "+number*11+
						"\n"+number+" * 12 = "+number*12
						);
				break;
				
			case 11:
				JOptionPane.showMessageDialog(null, "Multiplication table of "+number+
						"\n"+number+" * 1 = "+number*1+
						"\n"+number+" * 2 = "+number*2+
						"\n"+number+" * 3 = "+number*3+
						"\n"+number+" * 4 = "+number*4+
						"\n"+number+" * 5 = "+number*5+
						"\n"+number+" * 6 = "+number*6+
						"\n"+number+" * 7 = "+number*7+
						"\n"+number+" * 8 = "+number*8+
						"\n"+number+" * 9 = "+number*9+
						"\n"+number+" * 10 = "+number*10+
						"\n"+number+" * 11 = "+number*11+
						"\n"+number+" * 12 = "+number*12
						);
				break;
				
			default:
				JOptionPane.showMessageDialog(null, "Multiplication table of "+number+
						"\n"+number+" * 1 = "+number*1+
						"\n"+number+" * 2 = "+number*2+
						"\n"+number+" * 3 = "+number*3+
						"\n"+number+" * 4 = "+number*4+
						"\n"+number+" * 5 = "+number*5+
						"\n"+number+" * 6 = "+number*6+
						"\n"+number+" * 7 = "+number*7+
						"\n"+number+" * 8 = "+number*8+
						"\n"+number+" * 9 = "+number*9+
						"\n"+number+" * 10 = "+number*10+
						"\n"+number+" * 11 = "+number*11+
						"\n"+number+" * 12 = "+number*12
						);
			}
			
			do {
				response = JOptionPane.showInputDialog("Do you want another table of multication? Type \"Y\" for yes or \"N\" for no");
			}while(!(response.equalsIgnoreCase("y")) && !(response.equalsIgnoreCase("n")));
			
			if(response.equalsIgnoreCase("n")) {
				JOptionPane.showMessageDialog(null, "GOOD BYE, SEE YOU NEXT TIME!");
			}
			
		}while(response.equalsIgnoreCase("y"));
		
	}

}

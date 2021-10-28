import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class pickACard {
	
	public static void main(String[] args) {
		String[] values = {"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
		char[] suits = {'\u2663', '\u2665', '\u2666', '\u2660'};
//		club = "\u2663"
//		heart = "\u2665"
//		diamond = "\u2666"
//		spade = "\u2660"
		
		String[] card = {" -------", "| *     |", "| $     |", "|       |", "|     $ |", "|     * |", " -------"};
		String cardValue = values[(int) (Math.random() * values.length)];
		char cardSuit = suits[(int) (Math.random() * suits.length)];
		
		for (String i: card) {
			i =  i.replace("*", cardValue);
			i = i.replace('$', cardSuit);
			
			if (cardValue.equals("10")){
				if (i.charAt(2)=='1') {
					char[] temp = i.toCharArray();
					char[] temp2 = new char[temp.length-1];
					int count = 0;
					for (int j = 0; j < temp.length; j++) {
						if(j!=1) {
							temp2[count] = temp[j];
							count++;
						}
					}
					i = String.valueOf(temp2);
					
				}else if(i.charAt(6)=='1') {
					char[] temp = i.toCharArray();
					char[] temp2 = new char[temp.length-1];
					int count = 0;
					for (int j = 0; j < temp.length; j++) {
						if(j!=1) {
							temp2[count] = temp[j];
							count++;
						}
					}
					i = String.valueOf(temp2);
				}
			}
			System.out.println(i);
		}
	
	}
}

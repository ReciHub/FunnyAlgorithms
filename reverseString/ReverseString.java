import java.lang.*; 
import java.io.*; 
import java.util.*; 


// java program to reverse a input string

public class ReverseString{
  public static void main(String[] args){

    // the string is passed in the argument
    if(args.length > 0){
      // a string is passed
      String reversedString = getReverseString(args[0]); // always choose the first string
      System.out.println("inside getReverseString : " +reversedString);
      stringReverse(args[0]);
    } else{
      System.out.println("Please provide an argument");
    }

  }

  // the main string reversing method
  private static String getReverseString(String originalString){

    int len = originalString.length();

    StringBuilder stringBuilder = new StringBuilder();
    for(int i=len-1; i>=0; i--){
      stringBuilder.append(originalString.charAt(i));
    }

    return stringBuilder.toString();

  }
  
  private static void stringReverse(String input) 
	{ 
		StringBuilder input1 = new StringBuilder(); 
		input1.append(input); 
		input1 = input1.reverse(); 
		System.out.println("inside String reverse : " + input1); 
	} 
}


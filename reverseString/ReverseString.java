// java program to reverse a input string

public class ReverseString{
  public static void main(String[] args){

    // the string is passed in the argument
    if(args.length > 0){
      // a string is passed
      String reversedString = getReverseString(args[0]); // always choose the first string
      System.out.println(reversedString);
    } else{
      System.out.println("Please provide an argument");
    }

  }

  // the main string reversing method
  private static String getReverseString(String originalString){

    int len = originalString.length();

    StringBuilder stringBuilder = new StringBuilder();
    for(int i=len-1; i>=0; i--){

      /*
      we should not use String object in loop, cause everytime
      the string object changes Java has to destroy the previous object and create a new one
      thus for better efficiency StringBuilder is used
      */

      stringBuilder.append(originalString.charAt(i));
    }

    return stringBuilder.toString();

  }

}

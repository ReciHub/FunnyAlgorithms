import java.util.Scanner;

class Beer {
  public static void main(String[] args) {
    
    // initialize Scanner variable
    Scanner sc = new Scanner(System.in);
    
    // loop function only when input is invalid
    boolean valid = false; 
    while (valid != true) {
      
    // take user input
    System.out.println("> Should I check if it is time to have Beer ? (Y / N)");
    char ans = sc.next().charAt(0);
      
      // answer if no
      if (ans == 78 || ans == 110) {
        System.out.println("> We check later");
        valid = true;
      }
      
      // answer if yes
      else if (ans == 89 || ans == 121) {
        System.out.println("> It always is beer of clock. Cheers !!!");
        valid = true;
      }
      
      // answer if invalid input
      else {
        System.out.println("> Invalid input, try again.");
      }
    }
  }
}

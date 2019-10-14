public class Testing { 
    public static void main(String[] args) 
     { 
         // the line below this gives an output 
         // \u000d System.out.println("comment executed"); 
     } 
} 



/* The reason for this is that the Java compiler parses the unicode character \u000d as a new line and gets transformed into:
 // \u000d 
 System.out.println("comment executed"); 
 
 */


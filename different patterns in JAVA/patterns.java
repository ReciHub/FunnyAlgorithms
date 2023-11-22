import java.util.*;

public class patterns{

// ******
// *    *
// *    *
// *    *
// ******
    public static void hollow_rectengle(int row, int col) {       
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (i == 1 || i == row || j == 1 || j == col) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

//      *
//     **
//    ***
//   ****
//  *****
    public static void inverted_triangle(int row){
        for(int i=1;i<=row;i++){
            for(int j = row-1;j>=i;j--){
                System.out.print(" ");
            }
            for(int j = 1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 1234
    // 123
    // 12
    // 1
    public static void inverted_halfpyramid_num(int n){
        for(int i =n;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    // 1 
    // 2 3
    // 4 5 6
    // 7 8 9 10
    public static void flyods_triangle(int n){
        int num=1;
        for(int i =1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }

    // 1
    // 01
    // 101
    // 0101
    public static void zero_one_triangle(int n){
        for(int i =1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if((i+j)%2==0){
                    System.out.print("1");
                }
                else{
                    System.out.print("0");
                }
               
            } System.out.println();
        }
    }
    // *      *
    // **    **
    // ***  ***
    // ********
    // ********
    // ***  ***
    // **    **
    // *      *
    public static void butterfly(int n){
        for(int i=1;i<=n;i++){
            for(int j =1;j<=i;j++){
                System.out.print("*");
            }
            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            for(int j =1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i =n;i>=1;i--){
           for(int j =1;j<=i;j++){
                System.out.print("*");
            }
            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            for(int j =1;j<=i;j++){
                System.out.print("*");
            }   
            System.out.println();            


        }
    }

//      *****
//     *****
//    *****
//   *****
//  *****
    public static void rohmbus(int n){
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j = 1;j<=n;j++){
                System.out.print("*");
                
            }
            System.out.println();
        }
    }
//      ***
//     * *
//    ***
      public static void hollow_rohmbus(int n){
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j = 1;j<=n;j++){
                if(i==1|| j==1 || i==n || j==n){
                System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

//      *
//     ***
//    *****
//   *******
//  *********
//  *********
//   *******
//    *****
//     ***
//      *
    public static void kite(int n){
        for(int i = 1;i<=n;i++){
            for(int j =1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j =1;j<=(2*i)-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }

          for(int i = n;i>=1;i--){
             for(int j =1;j<=n-i;j++){
                 System.out.print(" ");
             }
             for(int j =1;j<=(2*i)-1;j++){
                 System.out.print("*");
             }
             System.out.println();
        }
      
    }
 
//      1 
//     2 2 
//    3 3 3
//   4 4 4 4
//  5 5 5 5 5
    public static void num_pyramid(int n){
        int num=1;
        for(int i = 1;i<=n;i++){
            for(int j =1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j =1;j<=i;j++){
                System.out.print(num +" ");
            }
            num++;
            System.out.println();
        }
    
    }
    public static void main(String args[]){
        hollow_rectengle(5, 6);
        inverted_triangle(5);
        inverted_halfpyramid_num(4);
        flyods_triangle(4);
        zero_one_triangle(4);
        butterfly(4);
        rohmbus(5);
        hollow_rohmbus(3);
        kite(5);
        num_pyramid(5);
    }
}
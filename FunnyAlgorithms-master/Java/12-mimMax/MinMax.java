/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mimMax;

/**
 *
 * @author Kamdoum-Maurain
 */
public class MinMax {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        int a = 25; int b = 0;
        System.out.println("a = " +a);
        System.out.println("b = " +b);
        int min; int max;
        if (a < b ){ 
            min = a;
            max = b;
        }else{
            min = b;
            max = a;
        }
        System.out.println("le minimun de a et b est " +min+ " et le maximum est " +max);
    }
    
}

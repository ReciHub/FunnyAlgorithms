package CodinGame;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

 /*
  * Challange solved in the CodinGame platform.
  *  you have to analyze records of temperature to find the closest to zero. Sample temperatures Here, -1 is the closest to 0.
  */
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        int minT=0;
        int minTN=0;
        int result=0;
        for (int i = 0; i < n; i++) {
            int t = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
            if(t>0){
                if(minT>t||minT==0){
                    minT=t;
                }
            }
            else{
                if(minTN<t||minTN==0){
                    minTN=t;
                }
            }
            
        }
         if(minT>Math.abs(minTN)&&(minT>0)&&(Math.abs(minTN)>0))
        {
            result=minTN;
            
        }
        else if(minT<Math.abs(minTN)&&(minT>0)&&(Math.abs(minTN)>0))
        {
            result=minT;    
    
        }  
        else if(minT==0){
            result=minTN;
        }
        else{
            result=minT;
            }

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(result);
    }
}
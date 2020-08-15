package countingSort;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Challenge 
 * Given a list of integers, count and output the number of times each value appears as a list of space-separated integers.
 * 
 * Output
 * It should return an array of integers where each value is the number of occurrences of the element's index value in the original array.
 * 
 * 
 * @author gouravrusiya
 *
 */
public class CountingSort1 {

    public static void main(String[] args) {
        
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int ar [] = new int[n];
        int countAr [] = new int[100];
        
        for(int i=0;i<n;i++){
            ar[i] = kb.nextInt();
            countAr[ar[i]]++;
        }
        
        for(int i=0;i<100;i++){
            System.out.print(countAr[i]+" ");
        }
    }
}



package countingSort;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
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



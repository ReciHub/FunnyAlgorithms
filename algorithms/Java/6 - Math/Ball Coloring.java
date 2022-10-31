
import java.util.*;
import java.io.*;

/*
Problem - 
Given n balls . All of them are initially  uncolored . 
You have to color the balls with two colors RED and BLUE such that there can be atmost 2 positions where a RED ball is touching BLUE ball or vice versa.
You have to color all the balls.Find the number of ways in which balls can be colored.

Coloring is fun, so as coding to color.
*/
class Solution {
    static long noOfWays(long n){
       /*
       no touching =2, touching at 1 position = (n-1)*2 and touching at 2 positions
       for example if n=3;
       no touching = RRR and BBB
       1 position touching = (RRB, BBR) (RBB BRR)
       2 positions touching = (BRB, RBR)
       
       Time complexity - O(1)
       Space complexity - O(1)
       */
        return (2 + (n-1)*2 + ((n-2)*(n-1)));
    }
}


class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.noOfWays(n));
        }
    }
}


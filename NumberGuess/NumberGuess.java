// A game of guessing: The user has to guess a secret number from 0 to 100, he has 5 tries.

import java.util.Scanner;
import java.util.Random;

class NumGuess{
 
   static boolean guessNum(int target, int guess){
        return (target == guess) ? true : false;
   }
 
   public static void main(String[] args){
         int target = new Random().nextInt(101);
         Scanner sc = new Scanner(System.in);
 
         System.out.println("Guess the number, you have 5 tries:");
 
         for(int i = 0; i < 5; i++){
              if(guessNum(target, sc.nextInt())){
                   System.out.println("FOUND IT!");
                   break;
              }
              else System.out.println("Wrong, you have " + (4 - i) + " more tries."); 
         }                                                                            
    }                                                                                 
}      

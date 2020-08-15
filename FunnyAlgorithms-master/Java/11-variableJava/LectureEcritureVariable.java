/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variableJava;

/**
 *
 * @author Kamdoum-Maurain
 */
        public class LectureEcritureVariable{

    public static void main(String[] args) {
       
double a = 1.5;
int b = 2;
  
   a = b;
   b = (int) a; //Cast pour éviter une erreur de convertion d'un antier en décimal

 System.out.println("Au finish, 'a' prend la valeur " +b+ " et ensuite 'b' prend la valeur nouvelle de 'a' qui est: " +a); 
    
}
        }
    


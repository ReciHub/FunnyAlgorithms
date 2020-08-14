package pack1;

import java.util.Scanner;

public class CompareThreeNumber {

	public static void main(String[] args) {
		int n1, n2, n3;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nous allons faire la comparaison de trois nombres entiers en utilisant l'opérateur ternaire");
		
		System.out.print("Veuillez entrer le premier nombre: ");
		n1=sc.nextInt();
		
		System.out.print("Veuillez entrer le second nombre: ");
		n2=sc.nextInt();
		
		System.out.println("Veuillez entrer le troisième nombre: ");
		n3=sc.nextInt();
		
		int result = n3 > (n1>n2 ? n1:n2) ? n3:((n1>n2) ? n1:n2);
		
		System.out.println("Voiçi les trois nombres entrés: "+ n1+" "+n2+ " "+n3);
		
		System.out.println("Le plus grand nombre est "+result);

	}

}

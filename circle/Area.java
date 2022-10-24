import java.util.Scanner;

class Main{

  static final double  PI = 3.1428;
	
  public static double area_of_circle(double r){
	    double area = 0;
 
      area = PI * r * r ; 

	    return area;
	}

	public static void main(String args[]){

		double r;
		Scanner in = new Scanner(System.in);

		System.out.print("Enter the radius of the circle: ");
		r = in.nextDouble();

		System.out.println(area_of_circle(r));
	}
}

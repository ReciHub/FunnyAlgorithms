import java.util.Scanner;
public class RandomCharacterGenerator{

	public static void main(String[] args) throws InterruptedException{
                Scanner in = new Scanner(System.in);
		int choice = 1;
		while(choice != 0){
                	System.out.print("\u001B[36m"+"What would you like to do?\n"
                	+ "0- Exit from program\n"
			+ "1- Generate random characters \n"
                	+ "2- Generate an input string with a cool way ;D \n"
                	+ "Write your choice (1 or 2 or 0 to exit) : ");
			choice = Integer.parseInt(in.nextLine());
			if(choice == 1)	{
                		System.out.print("\u001B[35m"+"How many characters do you want? : ");
                		int longOfChars = Integer.parseInt(in.nextLine());
				System.out.print("\u001B[35m"+"Select the speed (1 = slow, 2 = normal, 3 = faster) : ");
				int speed = Integer.parseInt(in.nextLine());
                		System.out.println();
				randomGenerator(longOfChars, speed);
				System.out.println();
				stringGenerator("CODED BY ANIL ŞENAY");
				System.out.println();
			}
			else if(choice == 2) {
				System.out.print("\u001B[35m"+"Which string do you want to print as a cool way? : ");
				String str = in.nextLine();
				System.out.println();
				stringGenerator(str);
				System.out.println();
				stringGenerator("CODED BY ANIL ŞENAY");
				System.out.println();
			}
			else if(choice == 0) {
				System.out.println("\u001B[33m"+"Program ends");
				System.exit(0);
			}
			else {
				System.out.println();
				System.out.println("\u001B[31m"+"!!! Wrong input, try again !!!");
				System.out.println();
			}
		}

	}

	public static void randomGenerator (int longOfChars, int speed) throws InterruptedException{
		for(int j = 0; j < longOfChars; j++){
			for(int i = 0; i < 100; i++){

				System.out.print("\u001B[32m"+(char)(Math.random()*50+40));
				Thread.sleep((4-speed) * (long)2.5);
				if(i < 99){
				System.out.print("\b");
				}
			}
		}
		System.out.println();
	}
        public static void stringGenerator (String str) throws InterruptedException{
                for(int j = 0; j < str.length(); j++){
                        for(int i = 0; i < 100; i++){
				if(i<99){
                                System.out.print("\u001B[32m"+(char)(Math.random()*90+35));
                                Thread.sleep(2);
                                }
				if(i < 99){
                                System.out.print("\b");
                                }
				if(i == 99)
				System.out.print("\u001B[32m"+str.charAt(j));
                        }
                }
                System.out.println();
        }

}

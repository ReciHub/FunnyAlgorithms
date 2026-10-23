package project;

import java.util.Scanner;

public class JokeCLI {
	
	boolean running = true;
	Scanner in = new Scanner(System.in);
	JokeLoader JL  = new JokeLoader();
	
	public void start() {
		
		welcome();
		running = checkAnswer();
		while(running) {
			tellJoke();
			running = checkAnswer();
		}		
	}

	
	private void tellJoke() {
		Joke joke = JL.getNextJoke();
		String setup = joke.getSetup();
		String punchline = joke.getPunchline();
		
		System.out.println("Knock Knock");
		in.nextLine();
		System.out.println("Who's there");
		in.nextLine();
		System.out.println(setup);
		in.nextLine();
		System.out.println(setup +" who?");
		in.nextLine();
		System.out.println(punchline);		
	}


	public void welcome() {
		System.out.println("\n"+"WELCOME"+"\n");
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean checkAnswer() {
		System.out.println("\n"+"WANT TO HEAR A JOKE?"+"\n[Y/N]");
		boolean answer;
        String s = in.nextLine();
        s = s.toUpperCase();
        
        if(s.equals("Y")) {
        	answer = true;
        	System.out.println("Great here it goes");
        }else {
        	answer = false;
        	System.out.println("Goodbye");
        }
		return answer;
	}
	
}

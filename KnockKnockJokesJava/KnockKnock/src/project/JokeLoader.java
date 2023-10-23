package project;

import java.util.ArrayList;

public class JokeLoader {
	
	public int jokeCount = 0;
	
	ArrayList<String> setups = new ArrayList<String>();
	ArrayList<String> punchlines = new ArrayList<String>();
	
	public JokeLoader() {
		setups.add("You.");
		punchlines.add("Yoo-hoo! Anybody home?");
		
		setups.add("Radio.");
		punchlines.add("Radio not, here I come!");
		
		setups.add("Ice cream.");
		punchlines.add("ICE CREAM SO YOU CAN HEAR ME!");
		
		setups.add("Weirdo.");
		punchlines.add("Weirdo you think you’re going?");
		
		setups.add("Canoe.");
		punchlines.add("Canoe come out now?");
		
	}
	

	public Joke getNextJoke() {
		String setup = setups.get(jokeCount);
		String punchline = punchlines.get(jokeCount);
		
		Joke answer = new Joke(setup,punchline);
		jokeCount++;
		if(jokeCount >= setups.size()) {
			jokeCount = 0;
		}
		return answer;

	}

}




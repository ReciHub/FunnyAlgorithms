package project;

public class Joke {
	String setup;
	String punchline;
	
	public Joke(String s,String p) {
		this.setup = s;
		this.punchline = p;
	}
	
	public String getSetup() {
		return this.setup;
	}

	public String getPunchline() {
		return this.punchline;
	}
}

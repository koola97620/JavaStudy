package Exer_Bracket;


public class Bracket {
	private BracketInterface bracketInterface;
	private String str;
	public Bracket(String str) {
		this.str = str;
	}
	
	public void setStrategy(BracketInterface bracketInterface) {
		this.bracketInterface = bracketInterface;
	}
	
	public void bracVaild() {
		bracketInterface.BracVaild(str);
	}



}

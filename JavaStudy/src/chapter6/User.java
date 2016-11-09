package chapter6;


public class User {
	private String name;
	
	public User(String name) {
		this.name=name;
	}
	public void print() {
		Printer printer2 = Printer.getPrinter();
		printer2.print(this.name + " print using " + printer2.getPrinter());
	}
}
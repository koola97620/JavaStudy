package chapter6;



class Printer {
	private static Printer printer = null;
	private Printer() {
		
	}
	
	public static Printer getPrinter() {
		if(printer == null) {
			printer = new Printer();
		}
		return printer;
	}
	
	public void print(String str) {
		System.out.println(str);
	}
}




public class Main {
	private static final int User_Num=5;
	public static void main(String[] args) {
		User[] user = new User[User_Num];
		for(int i =0 ; i < User_Num ; i++) {
			user[i] = new User((i+1) + "-user"); // user인스턴스 생성
			user[i].print();
		}
		

	}

}

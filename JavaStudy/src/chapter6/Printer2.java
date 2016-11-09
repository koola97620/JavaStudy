package chapter6;

public class Printer2 {
//	private static Printer2 printer = new Printer2(); 정적변수에 인스턴스를 만들어 바로 초기화하는 방법. 
	private static Printer2 printer = null;
	private int counter=0;
	private Printer2() {}
	
	public synchronized static Printer2 getPrinter() {
		if(printer == null) {
			printer = new Printer2();
		}
		return printer;
	}
	
	
	public void print(String str) {
		synchronized(this) { //오직 하나의 스레드만 접근 허용.
			counter++;
			System.out.println(str + counter);
		}
		
	}

}

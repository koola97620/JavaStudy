package chapter7;

public class Client {

	public static void main(String[] args) {
		VendingMachine machine = new VendingMachine(1000, 5);
		
		machine.insertMoney(5000);
		machine.insertMoney(500);
		machine.pushButton(1000);
		machine.returnMoney();
		
		machine.insertMoney(900);
		machine.pushButton(1000);
		machine.insertMoney(1000);
		machine.pushButton(1000);
		
	}

}

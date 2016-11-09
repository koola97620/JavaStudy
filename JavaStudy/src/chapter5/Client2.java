package chapter5;

public class Client2 {

	public static void main(String[] args) {

		Item item1 = new Item("Shampoo", 3000);
		Item item2 = new Item("Cookie", 1500);
		Item item3 = new Item("Ciga", 4500);
		
		Sale sale = new Sale();
		
		sale.add(item1);
		sale.add(item2);
		sale.add(item3);
		
		FakePrinter printer = new FakePrinter();
		sale.setReceiptPrinter(printer);
		sale.printReceipt();
		System.out.println(printer.getReceiptContents());
		
	}

}

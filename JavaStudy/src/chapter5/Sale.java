package chapter5;

import java.util.ArrayList;
import java.util.Iterator;

class Item {
	private int price;
	private String name;
	public Item(String name, int price) {
		this.price = price;
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

class HD108ReceiptPrinter implements ReceiptPrinter {
	@Override
	public void print(String s) {
		// 실제 영수증 출력코드
	}
}

class FakePrinter implements ReceiptPrinter {
	private String s;
	
	@Override
	public void print(String s) {
		this.s = s;
	}
	
	public String getReceiptContents() {
		return s;
	}
}


public class Sale {
	private ArrayList<Item> items = new ArrayList<Item>();
	private ReceiptPrinter printer;
	
	public void printReceipt() {
		Iterator<Item> itr = items.iterator();
		StringBuffer buf = new StringBuffer();
		while(itr.hasNext()) {
			Item item = itr.next();
			buf.append(item.getName());
			buf.append(item.getPrice());
		}
		printer.print(buf.toString());
		System.out.println(buf.toString());
	}
	
	public void add(Item item) {
		items.add(item);
	}
	public void setReceiptPrinter(ReceiptPrinter printer) {
		this.printer = printer;
	}
	
	
	
	
	
	
}

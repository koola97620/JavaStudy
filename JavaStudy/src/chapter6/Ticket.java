package chapter6;

public class Ticket implements TicketInterface{
	private int serial;
	
	public Ticket(int num) {
		this.serial = num;
	}
	
	public int getTicketNum() {
		return serial;
	}
	

}

class NullTicket implements TicketInterface {
	public int getTicketNum() {
		return 0;
	}
}
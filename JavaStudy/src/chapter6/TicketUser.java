package chapter6;

public class TicketUser extends Thread{
	private TicketInterface myTicket;
	
	public TicketUser(String name) {
		super(name);
	}
	
	public void run() {
		TicketRegister mgr = TicketRegister.getTicketRegister();
		myTicket = mgr.getTicket();
	}
	
	public TicketInterface getMyTicket() {
		return myTicket;
	}
}

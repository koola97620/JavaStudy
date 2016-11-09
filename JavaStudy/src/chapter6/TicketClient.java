package chapter6;

class TicketRegister {
	private static TicketRegister ticketRegister = null;
	private int limit;
	private int count;
	
	private TicketRegister() {
		count=0;
	}
	
	public synchronized static TicketRegister getTicketRegister() {
		if(ticketRegister == null) {
			ticketRegister = new TicketRegister();
		}
		return ticketRegister;
	}
	
	public synchronized void setTicketLimit(int limit) {
		this.limit = limit;
	}
	
	public synchronized TicketInterface getTicket() {
		if(this.count < this.limit) {
			return new Ticket(++this.count);
		}
		return new NullTicket();
	}
	
	
}


public class TicketClient {
	private static final int ThreadNum = 15;

	public static void main(String[] args) {
		TicketRegister mgr = TicketRegister.getTicketRegister();
		mgr.setTicketLimit(5);
		TicketUser[] user = new TicketUser[ThreadNum];
		
		for(int i=0; i <ThreadNum ; i++) {
			user[i] = new TicketUser((i+1) + "-thread");
			user[i].start();
		}
		
		for(int i=0; i < ThreadNum ; i++) {
			try {
				user[i].join();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int i=0 ; i < ThreadNum ; i++) {
			if(user[i].getMyTicket().getTicketNum() != 0) {
				System.out.println("User" + i + "-th Thread get ticket" + user[i].getMyTicket().getTicketNum());
			}
		}

	}

}

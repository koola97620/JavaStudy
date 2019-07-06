package Misson.Week01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author choijaeyong on 06/07/2019.
 * @project objects
 * @description
 */
public class TicketOffice {
  private Long amount;
  private List<Ticket> tickets = new ArrayList<>();

  public TicketOffice(Long amount) {
    this.amount = amount;
  }

  public void addTicket(Ticket ticket) {
    this.tickets.add(ticket);
  }

  public Long getTicketPrice() {
    if(tickets.size() == 0 ) return 0L;
    else return tickets.get(0).getFee();
  }

  public Ticket getTicketWithFee() {
    if(tickets.size() == 0) return Ticket.EMPTY;
    else {
      Ticket ticket = tickets.remove(0);
      amount += ticket.getFee();
      return ticket;
    }
  }

  public Ticket getTicketWithNoFee() {
    if(tickets.size() == 0) return Ticket.EMPTY;
    else return tickets.remove(0);
  }

}

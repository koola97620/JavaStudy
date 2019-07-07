package Misson.Week01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author choijaeyong on 06/07/2019.
 * @project objects
 * @description
 */
public class Theater {
  final private List<TicketOffice> ticketOffices = new ArrayList<>();
  private String name;

  public Theater(String name) {
    this.name = name;
  }

  public void setTicketOffices(TicketOffice ... ticketOffices) {
    this.ticketOffices.addAll(Arrays.asList(ticketOffices));
  }

  public void setTicket(TicketOffice ticketOffice, Long num, Movie movie, Long fee) {
    if(!ticketOffices.contains(ticketOffice)) {
      return;
    }
    // 티켓오피스에 티켓을 세팅하는데. 티켓이 5만개면 . 반복문이 5만번...
    while(num-- > 0) {
      ticketOffice.addTicket(new Ticket(this , movie , fee));
    }
  }

  public void setInvitation(Audience audience, Movie movie) {
    audience.setInvitation(new Invitation(this, movie));
  }

  public boolean enter(Audience audience , Movie movie) {
    Ticket ticket = audience.getTicket();
    return ticket.isValid(this, movie);
  }

}

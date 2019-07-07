package Misson.Week01;

/**
 * @author choijaeyong on 06/07/2019.
 * @project objects
 * @description
 */
public class TicketSeller {

  private TicketOffice ticketOffice;

  public void setTicketOffice(TicketOffice ticketOffice) {
    this.ticketOffice = ticketOffice;
  }

  public Ticket getTicket(Audience audience, Movie movie) {
    Ticket ticket = Ticket.EMPTY;
    if(audience.getInvitation() != Invitation.EMPTY && audience.getInvitation().getMovie() == movie) {
      ticket = ticketOffice.getTicketWithNoFee(movie);
      if(ticket != Ticket.EMPTY) {
        audience.removeInvitation();
      }
    } else {
      Long price = ticketOffice.getTicketPrice(movie);
      if(price > 0 && audience.hasAmount(price)) {
        ticket = ticketOffice.getTicketWithFee(movie);
        if(ticket != Ticket.EMPTY)
          audience.minusAmount(price);
      }
    }

    return ticket;
  }

}

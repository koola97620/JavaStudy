package Misson.Week01;

/**
 * @author choijaeyong on 06/07/2019.
 * @project objects
 * @description
 */
public class Audience {


  private Long amount;
  private Ticket ticket = new Ticket(null);

  public Audience(Long amount) {
    this.amount = amount;
  }

  public void buyTicket(TicketSeller ticketSeller) {
    ticket = ticketSeller.getTicket(this);
  }

  public void setInvitation(Invitation invitation) {


  }

  public Ticket getTicket() {

    return null;
  }

  public Invitation getInvitation() {

  }

  public void removeInvitation() {

  }

  public boolean hasAmount(Long price) {


  }

  public void minusAmount(Long price) {


  }
}

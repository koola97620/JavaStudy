package Misson.Week01;

/**
 * @author choijaeyong on 06/07/2019.
 * @project objects
 * @description
 */
public class Audience {


  private Long amount;
  private Ticket ticket = Ticket.EMPTY;
  private Invitation invitation = Invitation.EMPTY;

  public Audience(Long amount) {
    this.amount = amount;
  }

  public void buyTicket(TicketSeller ticketSeller , Movie movie) {
    this.ticket = ticketSeller.getTicket(this , movie);
  }

  public void setInvitation(Invitation invitation) {
    this.invitation = invitation;
  }

  public Ticket getTicket() {
    return this.ticket;
  }

  public Invitation getInvitation() {
    return this.invitation;
  }

  public void removeInvitation() {
    invitation = Invitation.EMPTY;
  }

  public boolean hasAmount(Long amount) {
    return this.amount >= amount;
  }

  public boolean minusAmount(Long amount) {
    if(amount > this.amount) return false;
    this.amount -= amount;
    return true;
  }
}

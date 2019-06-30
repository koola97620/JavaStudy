package Chapter01;

/**
 * @author choijaeyong on 30/06/2019.
 * @project objects
 * @description
 */
public class TicketSeller {
  private TicketOffice ticketOffice;

  public TicketSeller(TicketOffice ticketOffice) {
    this.ticketOffice = ticketOffice;
  }

  public void sellTo(Audience audience) {
    ticketOffice.sellTicketTo(audience);
  }
}

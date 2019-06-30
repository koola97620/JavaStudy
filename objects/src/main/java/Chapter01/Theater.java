package Chapter01;

/**
 * @author choijaeyong on 30/06/2019.
 * @project objects
 * @description
 */
public class Theater {
  private TicketSeller ticketSeller;

  public Theater(TicketSeller ticketSeller) {
    this.ticketSeller = ticketSeller;
  }

  public void enter(Audience audience) {
    ticketSeller.sellTo(audience);

  }
}

package Chapter01;

/**
 * @author choijaeyong on 29/06/2019.
 * @project objects
 * @description
 */
public class Audience {
  private Bag bag;

  public Audience(Bag bag) {
    this.bag = bag;
  }

  public Long buy(Ticket ticket) {
    return bag.hold(ticket);

  }

}

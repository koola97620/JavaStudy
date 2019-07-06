package Misson.Week01;

/**
 * @author choijaeyong on 06/07/2019.
 * @project objects
 * @description
 */
public class Invitation {
  public final static Invitation EMPTY = new Invitation(null);
  private final Theater theater;

  public Invitation(Theater theater) {
    this.theater = theater;
  }
}

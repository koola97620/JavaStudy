package Misson.Week01;

/**
 * @author choijaeyong on 06/07/2019.
 * @project objects
 * @description
 */
public class Ticket {

  public static final Ticket EMPTY = new Ticket(null,null, null);
  private final Theater theater;
  private final Movie movie;
  private Long fee;
  private boolean isEntered = false;

  public Ticket(Theater theater , Movie movie , Long fee) {
    this.theater = theater;
    this.movie = movie;
    this.fee = fee;
  }

  public boolean isValid(Theater theater,Movie movie) {
    if(this.isEntered || this.theater != theater|| this.movie != movie || this == EMPTY) {
      return false;
    } else {
      this.isEntered = true;
      return true;
    }
  }

  public Long getFee() {
    return this.fee;
  }

  public Movie getMovie() {
    return this.movie;
  }
}

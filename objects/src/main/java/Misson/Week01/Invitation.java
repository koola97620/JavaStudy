package Misson.Week01;

/**
 * @author choijaeyong on 06/07/2019.
 * @project objects
 * @description
 */
public class Invitation {
  public final static Invitation EMPTY = new Invitation(null, null);
  private final Theater theater;
  private final Movie movie;

  public Invitation(Theater theater, Movie movie) {
    this.theater = theater;
    this.movie = movie;
  }

  public Movie getMovie() {
    return this.movie;
  }
}

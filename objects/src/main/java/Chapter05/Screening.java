package Chapter05;

import java.time.LocalDateTime;

/**
 * @author choijaeyong on 20/07/2019.
 * @project objects
 * @description
 */
public class Screening {
  private Movie movie;
  private int sequence;
  private LocalDateTime whenScreened;

  public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
    this.movie = movie;
    this.sequence = sequence;
    this.whenScreened = whenScreened;
  }

  public Reservation reserve(Customer customer , int audienceCount) {
    return new Reservation(customer,this,calculateFee(audienceCount),audienceCount);
  }

  private Money calculateFee(int audienceCount) {
    return movie.calculateMovieFee(this).times(audienceCount);
  }

  public Movie getMovie() {
    return movie;
  }

  public int getSequence() {
    return sequence;
  }

  public LocalDateTime getWhenScreened() {
    return whenScreened;
  }
}

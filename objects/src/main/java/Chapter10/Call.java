package Chapter10;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author choijaeyong on 15/08/2019.
 * @project objects
 * @description
 */
public class Call {
  private LocalDateTime from;
  private LocalDateTime to;

  public Call(LocalDateTime from, LocalDateTime to) {
    this.from = from;
    this.to = to;
  }
  public Duration getDuration() {
    return Duration.between(from,to);
  }

  public LocalDateTime getFrom() {
    return from;
  }
}

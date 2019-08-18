package Chapter11Composition;

import java.time.Duration;

/**
 * @author choijaeyong on 18/08/2019.
 * @project objects
 * @description
 */
public class RegularPolicy extends BasicRatePolicy {
  private Money amount;
  private Duration seconds;

  public RegularPolicy(Money amount, Duration seconds) {
    this.amount = amount;
    this.seconds = seconds;
  }

  @Override
  protected Money calculateCallFee(Call call) {
    return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
  }
}

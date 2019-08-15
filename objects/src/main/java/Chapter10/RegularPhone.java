package Chapter10;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * @author choijaeyong on 15/08/2019.
 * @project objects
 * @description
 */
public class RegularPhone extends AbstractPhone{
  private Money amount;
  private Duration seconds;

  public RegularPhone(Money amount, Duration seconds, double taxRate) {
    super(taxRate);
    this.amount = amount;
    this.seconds = seconds;
  }

  @Override
  protected Money calculateCalcFee(Call call) {
    return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
  }
}

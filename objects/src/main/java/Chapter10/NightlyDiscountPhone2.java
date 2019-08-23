package Chapter10;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * @author choijaeyong on 15/08/2019.
 * @project objects
 * @description
 */
public class NightlyDiscountPhone2  extends  AbstractPhone{
  private static final int LATE_NIGHT_HOUR =22;

  private Money nightlyAmount;
  private Money regularAmount;
  private Duration seconds;

  public NightlyDiscountPhone2(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate) {
    super(taxRate);
    this.nightlyAmount = nightlyAmount;
    this.regularAmount = regularAmount;
    this.seconds = seconds;
  }



  @Override
  protected Money calculateCalcFee(Call call) {
    if(call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
      return nightlyAmount.plus(nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
    } else {
      return regularAmount.plus(regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
    }
  }
}

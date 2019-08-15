package Chapter10;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * @author choijaeyong on 15/08/2019.
 * @project objects
 * @description
 */
public class NightlyDiscountPhone extends Phone{
  private static final int LATE_NIGHT_HOUR = 22;
  private Money nightlyAmount;

  private double taxRate;

  public NightlyDiscountPhone(Money nightlyAmount , Money regularAmount, Duration seconds, double taxRate) {
    super(regularAmount , seconds , taxRate);
    this.nightlyAmount = nightlyAmount;
  }


  public Money calculateFee() {
    Money result = super.calculateFee();
    Money nightlyFee = Money.ZERO;

    for (Call call : getCalls()) {
      if(call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
        nightlyFee = nightlyFee.plus(
            getAmount().minus(nightlyAmount).times(
                call.getDuration().getSeconds() / getSeconds().getSeconds()
            )
        );
      }
    }
    return result.minus(nightlyFee.plus(nightlyFee.times(getTaxRate())));
  }
}

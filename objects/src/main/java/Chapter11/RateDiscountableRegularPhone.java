package Chapter11;

import java.time.Duration;

/**
 * @author choijaeyong on 18/08/2019.
 * @project objects
 * @description
 */
public class RateDiscountableRegularPhone extends RegularPhone {
  private Money discountAmount;

  public RateDiscountableRegularPhone(Money amount, Duration seconds,
      Money discountAmount) {
    super(amount, seconds);
    this.discountAmount = discountAmount;
  }

  @Override
  protected Money afterCalculated(Money fee) {
    return fee.minus(discountAmount);
  }
}

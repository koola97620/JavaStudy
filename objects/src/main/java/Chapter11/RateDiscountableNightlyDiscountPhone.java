package Chapter11;

import java.time.Duration;

/**
 * @author choijaeyong on 18/08/2019.
 * @project objects
 * @description
 */
public class RateDiscountableNightlyDiscountPhone extends NightlyDiscountPhone {
  private Money discountAmount;

  public RateDiscountableNightlyDiscountPhone(Money nightlyAmount, Money regularAmount,
      Duration seconds, Money discountAmount) {
    super(nightlyAmount, regularAmount, seconds);
    this.discountAmount = discountAmount;
  }

  @Override
  protected Money afterCalculated(Money fee) {
    return fee.minus(discountAmount);
  }
}

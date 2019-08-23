package Chapter11Composition;

/**
 * @author choijaeyong on 18/08/2019.
 * @project objects
 * @description
 */
public class RateDiscountablePolicy extends AdditionalRatePolicy {
  private Money discountAmount;

  public RateDiscountablePolicy(RatePolicy next, Money discountAmount) {
    super(next);
    this.discountAmount = discountAmount;
  }

  @Override
  protected Money afterCalculated(Money fee) {
    return fee.minus(discountAmount);
  }
}

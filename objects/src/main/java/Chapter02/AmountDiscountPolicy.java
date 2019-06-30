package Chapter02;

/**
 * @author choijaeyong on 30/06/2019.
 * @project objects
 * @description
 */
public class AmountDiscountPolicy extends DefaultDiscountPolicy{

  private Money discountAmount;

  public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
    super(conditions);
    this.discountAmount = discountAmount;
  }

  @Override
  protected Money getDiscountAmount(Screening screening) {
    return discountAmount;
  }
}

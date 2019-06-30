package Chapter02;

/**
 * @author choijaeyong on 30/06/2019.
 * @project objects
 * @description
 */
public class PercentDiscountPolicy extends DefaultDiscountPolicy {
  private double percent;

  public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
    super(conditions);
    this.percent = percent;
  }

  @Override
  protected Money getDiscountAmount(Screening screening) {
    return screening.getMovieFee().times(percent);
  }
}

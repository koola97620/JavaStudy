package Chapter11Composition;

/**
 * @author choijaeyong on 18/08/2019.
 * @project objects
 * @description
 */
public abstract class AdditionalRatePolicy implements RatePolicy{
  private RatePolicy next;

  public AdditionalRatePolicy(RatePolicy next) {
    this.next = next;
  }

  @Override
  public Money calculateFee(Phone phone) {
    Money fee = next.calculateFee(phone);
    return afterCalculated(fee);
  }

  protected abstract Money afterCalculated(Money fee);
}

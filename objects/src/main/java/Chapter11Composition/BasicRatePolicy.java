package Chapter11Composition;

/**
 * @author choijaeyong on 18/08/2019.
 * @project objects
 * @description
 */
public abstract class BasicRatePolicy implements RatePolicy {

  @Override
  public Money calculateFee(Phone phone) {
    Money result = Money.ZERO;
    for (Call call : phone.getCalls()) {
      result.plus(calculateCallFee(call));
    }
    return result;
  }

  protected abstract Money calculateCallFee(Call call);
}
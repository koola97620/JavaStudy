package Chapter11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author choijaeyong on 17/08/2019.
 * @project objects
 * @description
 */
public abstract class Phone {
  private List<Call> calls = new ArrayList<>();
  public Money calculateFee() {
    Money result = Money.ZERO;
    for(Call call : calls) {
      result = result.plus(calculateCallFee(call));
    }
    return result;
  }
  abstract protected Money calculateCallFee(Call call);
  protected Money afterCalculated(Money fee) {
    return fee;
  }

}

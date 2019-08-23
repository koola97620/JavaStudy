package Chapter10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author choijaeyong on 15/08/2019.
 * @project objects
 * @description
 */
public abstract class AbstractPhone {
  private List<Call> calls = new ArrayList<>();
  private double taxRate;

  public AbstractPhone(double taxRate) {
    this.taxRate = taxRate;
  }

  abstract protected Money calculateCalcFee(Call call);

  public Money calculateFee() {
    Money result = Money.ZERO;
    for(Call call : calls) {
      result = calculateCalcFee(call);
    }
    return result;
  }

}

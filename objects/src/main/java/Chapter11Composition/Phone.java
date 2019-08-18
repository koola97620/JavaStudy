package Chapter11Composition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author choijaeyong on 17/08/2019.
 * @project objects
 * @description
 */
public class Phone {
  private RatePolicy ratePolicy;
  private List<Call> calls = new ArrayList<>();

  public Phone(RatePolicy ratePolicy) {
    this.ratePolicy = ratePolicy;
  }

  public Money calculateFee() {
    return ratePolicy.calculateFee(this);
  }


  public List<Call> getCalls() {
    return Collections.unmodifiableList(calls);
  }

}

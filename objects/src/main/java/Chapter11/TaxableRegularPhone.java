package Chapter11;

import java.time.Duration;

/**
 * @author choijaeyong on 17/08/2019.
 * @project objects
 * @description
 */
public class TaxableRegularPhone extends RegularPhone{
  private double taxRate;

  public TaxableRegularPhone(Money amount, Duration seconds, double taxRate) {
    super(amount,seconds);
    this.taxRate = taxRate;
  }

  @Override
  public Money calculateFee() {
    Money fee = super.calculateFee();
    return fee.plus(fee.times(taxRate));
  }

}

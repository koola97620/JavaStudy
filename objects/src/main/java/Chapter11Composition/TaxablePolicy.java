package Chapter11Composition;

/**
 * @author choijaeyong on 18/08/2019.
 * @project objects
 * @description
 */
public class TaxablePolicy extends AdditionalRatePolicy {
  private double taxRate;

  public TaxablePolicy(RatePolicy next, double taxRate) {
    super(next);
    this.taxRate = taxRate;
  }

  @Override
  protected Money afterCalculated(Money fee) {
    return fee.plus(fee.times(taxRate));
  }
}

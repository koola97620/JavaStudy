package Chapter10;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * @author choijaeyong on 15/08/2019.
 * @project objects
 * @description
 */
public class Phone {
  private Money amount;
  private Money regularAmount;
  private Money nightlyAmount;

  private Duration seconds;
  private List<Call> calls = new ArrayList<>();

  private static final int LATE_NIGHT_HOUR =22;
  enum PhoneType { REGULAR , NIGHTLY }
  private PhoneType type;


  private double taxRate;

  public Phone(PhoneType regular, Money money, Money zero, Money amount,
      Duration seconds) {
    this.amount = amount;
    this.regularAmount = regularAmount;
    this.nightlyAmount = nightlyAmount;
    this.seconds = seconds;
    this.type = type;
  }

  public Phone(Money amount, Duration seconds , double taxRate) {
    this(PhoneType.REGULAR , amount, Money.ZERO , Money.ZERO , seconds);
    this.taxRate = taxRate;
  }

  public Phone(Money regularAmount, Money nightlyAmount, Duration seconds) {
    this.regularAmount = regularAmount;
    this.nightlyAmount = nightlyAmount;
    this.seconds = seconds;
  }

  public void call(Call call) {
    calls.add(call);
  }

  public List<Call> getCalls() {
    return calls;
  }

  public Money getAmount() {
    return amount;
  }

  public Duration getSeconds() {
    return seconds;
  }

  public Money calculateFee() {
    Money result = Money.ZERO;
    for (Call call : calls) {

      if(type == PhoneType.REGULAR) {
        result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
      }else {
        if(call.getFrom().getHour() > LATE_NIGHT_HOUR) {
          result = result.plus(
              nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds())
          );
        } else {
          result = result.plus(
              regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds())
          );
        }
      }

    }
    return result.plus(result.times(taxRate));
  }

  public double getTaxRate() {
    return taxRate;
  }
}

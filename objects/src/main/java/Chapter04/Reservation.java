package Chapter04;

/**
 * @author choijaeyong on 20/07/2019.
 * @project objects
 * @description
 */
public class Reservation {
  private Customer customer;
  private Screening screening;
  private Money fee;
  private int audience;

  public Reservation(Customer customer, Screening screening, Money fee, int audience) {
    this.customer = customer;
    this.screening = screening;
    this.fee = fee;
    this.audience = audience;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Screening getScreening() {
    return screening;
  }

  public void setScreening(Screening screening) {
    this.screening = screening;
  }

  public Money getFee() {
    return fee;
  }

  public void setFee(Money fee) {
    this.fee = fee;
  }

  public int getAudience() {
    return audience;
  }

  public void setAudience(int audience) {
    this.audience = audience;
  }
}

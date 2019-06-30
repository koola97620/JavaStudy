package Chapter02;

/**
 * @author choijaeyong on 30/06/2019.
 * @project objects
 * @description
 */
public class Reservation {

  private Customer customer;
  private Screening screening;
  private Money fee;
  private int audienceCount;

  public Reservation(Customer customer, Screening screening, Money fee, int audienceCount) {
    this.customer = customer;
    this.screening = screening;
    this.fee = fee;
    this.audienceCount = audienceCount;
  }




}

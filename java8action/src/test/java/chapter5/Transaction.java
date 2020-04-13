package chapter5;

/**
 * @author choijaeyong on 2020/04/13.
 * @project java8action
 * @description
 */
public class Transaction {

  private final Trader trader;
  private final int year;
  private final int value;

  public Transaction(Trader trader, int year, int value) {
    this.trader = trader;
    this.year = year;
    this.value = value;
  }

  public Trader getTrader() {
    return trader;
  }

  public int getYear() {
    return year;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "Transaction{" +
        "trader=" + trader +
        ", year=" + year +
        ", value=" + value +
        '}';
  }
}

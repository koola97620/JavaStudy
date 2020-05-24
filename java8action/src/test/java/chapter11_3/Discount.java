package chapter11_3;

/**
 * @author choijaeyong on 2020/05/24.
 * @project java8action
 * @description
 */
public class Discount {
  public enum Code {
    NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

    private final int percentage;

    Code(int percentage) {
      this.percentage = percentage;
    }
  }

}

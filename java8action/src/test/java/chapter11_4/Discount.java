package chapter11_4;

import static com.sun.tools.javac.util.Constants.format;

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

  public static String applyDiscount(Quote quote) {
    return quote.getShopName() + " price is " + Discount.apply(quote.getPrice(), quote.getDiscountCode());
  }

  private static String apply(double price, Code discountCode) {
    delay();
    return format(price * (100 - discountCode.percentage) / 100);
  }

  public static void delay() {
    try {
      Thread.sleep(1000L);
    }catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

}

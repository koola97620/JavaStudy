package chapter11;

import java.util.Random;

/**
 * @author choijaeyong on 2020/05/19.
 * @project java8action
 * @description
 */
public class ShopImpl implements Shop {

  @Override
  public double getPrice(String product) {
    return calculatePrice(product);
  }

  private double calculatePrice(String product) {
    delay();
    Random random = new Random();
    return random.nextDouble() * product.charAt(0) + product.charAt(1);
  }


  public static void delay() {
    try {
      Thread.sleep(1000L);
    }catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}

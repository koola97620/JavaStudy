package chapter11;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author choijaeyong on 2020/05/19.
 * @project java8action
 * @description
 */
public class ShopImpl implements Shop {

  private String product;

  public ShopImpl(String product) {

    this.product = product;
  }

  @Override
  public double getPrice(String product) {
    return calculatePrice(product);
  }

  public Future<Double> getPriceAsync(String product) {
    // 11.2.1
//    CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//    new Thread( () -> {
//      double price = calculatePrice(product);
//      futurePrice.complete(price);
//    }).start();
//    return futurePrice;

    // 11.2.2
    CompletableFuture<Double> futurePrice = new CompletableFuture<>();
    new Thread( () -> {
      try {
        double price = calculatePrice(product);
        futurePrice.complete(price);
      } catch (Exception ex) {
        futurePrice.completeExceptionally(ex);
      }
    }).start();
    return futurePrice;
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

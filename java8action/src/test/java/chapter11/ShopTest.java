package chapter11;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/05/19.
 * @project java8action
 * @description
 */
public class ShopTest {

  @Test
  public void test() {
    Shop shop = new ShopImpl("BestShop");
    long start = System.nanoTime();

    Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
    long invocationTime = ((System.nanoTime() - start) / 1_000_000);
    System.out.println("Invocation returned after " + invocationTime + " msecs");

    doSomething();
    try {
      double price = futurePrice.get();
      System.out.printf("price is %.2f%n" , price);

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
    System.out.println("price returned after " + retrievalTime + " msecs");

  }

  private void doSomething() {

  }

  @Test
  public void non_block() {
    List<ShopImpl> shops = Arrays.asList(new ShopImpl("BestPrice"),
        new ShopImpl("LetsSaveBig"),
        new ShopImpl("MyFavoriteShop"),
        new ShopImpl("BuyItAll"));


  }



}

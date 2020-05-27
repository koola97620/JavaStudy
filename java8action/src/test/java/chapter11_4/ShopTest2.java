package chapter11_4;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/05/26.
 * @project java8action
 * @description
 */
class ShopTest2 {

  private List<Shop> shops;
  private final Executor executor =
      Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
          Thread t = new Thread(r);
          t.setDaemon(true);
          return t;
        }
      });

  @BeforeEach
  void setUp() {
    shops = Arrays.asList(new Shop("BestPrice"),
        new Shop("LetsSaveBig"),
        new Shop("MyFavoriteShop"),
        new Shop("BuyItAll"));
  }

  private static final Random random = new Random();
  public static void randomDelay() {
    int delay = 500 + random.nextInt(2000);
    try {
      Thread.sleep(delay);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }


  public Stream<CompletableFuture<String>> findPricesStream(String product) {
    return shops.stream()
        .map(shop -> CompletableFuture.supplyAsync( () -> shop.getPrice(product), executor))
        .map(future -> future.thenApply(Quote::parse))
        .map(future -> future.thenCompose(quote ->
            CompletableFuture.supplyAsync(
                () -> Discount.applyDiscount(quote) , executor
            )));
  }

  public void endCompletableFuture() {
    CompletableFuture[] myPhones = findPricesStream("myPhone")
        .map(f -> f.thenAccept(System.out::println))
        .toArray(size -> new CompletableFuture[size]);
    CompletableFuture.allOf(myPhones).join();
  }

  public void result() {
    long start = System.nanoTime();
    CompletableFuture[] myPhones = findPricesStream("myPhone")
        .map(f -> f.thenAccept(s -> System.out
            .println(s + " (done in " + ((System.nanoTime() - start) / 10_000_000) + " msecs")))
        .toArray(size -> new CompletableFuture[size]);

    CompletableFuture.allOf(myPhones).join();

    System.out.println("All shops have now responded in " +
        ((System.nanoTime() - start) / 1_000_000) + " msecs");
  }


}
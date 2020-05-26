package chapter11_4;

import java.util.Arrays;
import java.util.List;
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
 * @author choijaeyong on 2020/05/20.
 * @project java8action
 * @description
 */
class ShopTest {

  private List<Shop> shops;

  @BeforeEach
  void setUp() {
    shops = Arrays.asList(new Shop("BestPrice"),
        new Shop("LetsSaveBig"),
        new Shop("MyFavoriteShop"),
        new Shop("BuyItAll"));
  }

  @Test
  public void test() {
    Product product = new Product("myPhone27S" , 10000);
    shops.get(0).addProduct(product);
    findPrices(product.getName());

  }


  // 11.4.2
  public List<String> findPrices(String product) {
    return shops.stream()
        .map(shop -> shop.getPrice(product))
        .map(price -> Quote.parse(price))
        .map(quote -> Discount.applyDiscount(quote))
        .collect(Collectors.toList());
  }

  // 11.4.3
  public List<String> findPrices2(String product) {
    List<CompletableFuture<String>> priceFutures = shops.stream()
        .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor))
        .map(future -> future.thenApply(Quote::parse))
        .map(future -> future.thenCompose(
            quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)))
        .collect(Collectors.toList());

    return priceFutures.stream()
        .map(CompletableFuture::join)
        .collect(Collectors.toList());
  }

  // 11.4.4
  public Future<Double> mergeCompletableFuture(Shop shop, String product) {
    // thenCombine
    return null;
  }

  public List<String> findPricesParallel(String product) {
    return shops.parallelStream()
        .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
        .collect(Collectors.toList());
  }

  public List<String> findPricesAsync(String product) {
    List<CompletableFuture<String>> priceFutures = shops.stream()
        .map(shop -> CompletableFuture.supplyAsync(
            () -> shop.getName() + " price is " + shop.getPrice(product)
        )).collect(Collectors.toList());

    return priceFutures.stream()
        .map(CompletableFuture::join)
        .collect(Collectors.toList());
  }

  private final Executor executor =
      Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
          Thread t = new Thread(r);
          t.setDaemon(true);
          return t;
        }
      });

}
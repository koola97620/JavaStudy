package chapter11_2;

import static org.junit.jupiter.api.Assertions.*;

import chapter11.ShopImpl;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
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

  public List<String> findPrices(String product) {
    return shops.stream()
        .map(shop -> String
            .format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
        .collect(Collectors.toList());
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

}
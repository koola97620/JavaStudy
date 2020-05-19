package chapter11_2;

import static org.junit.jupiter.api.Assertions.*;

import chapter11.ShopImpl;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/05/20.
 * @project java8action
 * @description
 */
class ShopTest {

  @Test
  public void test() {
    List<ShopImpl> shops = Arrays.asList(new ShopImpl("BestPrice"),
        new ShopImpl("LetsSaveBig"),
        new ShopImpl("MyFavoriteShop"),
        new ShopImpl("BuyItAll"));
  }

}
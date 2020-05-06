package chapter8.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/05/06.
 * @project java8action
 * @description
 */
public class ProductFactoryTest {

  @Test
  public void test() {
    Product loan = ProductFactory.createProduct("loan");
  }

  static Map<String, Supplier<Product>> map = new HashMap<>();
  static {
    map.put("loan" , Loan::new);
    map.put("stock" , Stock::new);
  }

  @Test
  public void test2() {
    Supplier<Product> loanSupplier = Loan::new;
    Product product = loanSupplier.get();


  }

  private static Product createProduct(String name) {
    Supplier<Product> productSupplier = map.get(name);
    if(productSupplier != null) {
      return productSupplier.get();
    }
    throw new IllegalArgumentException("No such product " + name);
  }

}

package chapter11_4;

import chapter11_4.Discount.Code;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author choijaeyong on 2020/05/25.
 * @project java8action
 * @description
 */
public class Shop {
  private String name;
  private List<Product> products = new ArrayList<>();
  private Random random = new Random();

  public Shop(String name) {
    this.name = name;
  }

  public String getPrice(String product) {
    double price = calculatePrice(product);
    Discount.Code code = Discount.Code.values()[random.nextInt(Code.values().length)];
    return String.format("%s:%.2f:%s" , name, price, code);
  }

  private double calculatePrice(String product) {
    delay();
    return random.nextDouble() * product.charAt(0) + product.charAt(1);
  }

  public static void delay() {
    try {
      Thread.sleep(1000L);
    }catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public void addProduct(Product product) {
    products.add(product);
  }
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}

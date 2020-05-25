package chapter11_4;

/**
 * @author choijaeyong on 2020/05/20.
 * @project java8action
 * @description
 */
public class Product {

  private final String name;
  private final int price;

  public Product(String name , int price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }
}

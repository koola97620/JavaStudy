package chapter11_2;

/**
 * @author choijaeyong on 2020/05/20.
 * @project java8action
 * @description
 */
public class Shop {

  private String name;
  private int price;

  public Shop(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}

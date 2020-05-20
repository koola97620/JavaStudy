package chapter11_2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author choijaeyong on 2020/05/20.
 * @project java8action
 * @description
 */
public class Shop {

  private String name;
  private List<Product> products = new ArrayList<>();


  public Shop(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getPrice(String productName) {
    int result = 0;
    for (Product product : products) {
      if (productName.equals(product.getName())) {
        result = product.getPrice();
      }
    }
    return result;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addProduct(Product product) {
    products.add(product);
  }



}

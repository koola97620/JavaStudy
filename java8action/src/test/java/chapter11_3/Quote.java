package chapter11_3;

import chapter11_3.Discount.Code;

/**
 * @author choijaeyong on 2020/05/25.
 * @project java8action
 * @description
 */
public class Quote {

  private final String shopName;
  private final double price;
  private final Discount.Code discountCode;

  public Quote(String shopName, double price, Discount.Code discountCode) {
    this.shopName = shopName;
    this.price = price;
    this.discountCode = discountCode;
  }

  public static Quote parse(String s) {
    String[] split = s.split(":");
    String shopName = split[0];
    double price = Double.parseDouble(split[1]);
    Code code = Code.valueOf(split[2]);
    return new Quote(shopName,price,code);
  }

  public String getShopName() {
    return shopName;
  }

  public double getPrice() {
    return price;
  }

  public Code getDiscountCode() {
    return discountCode;
  }
}

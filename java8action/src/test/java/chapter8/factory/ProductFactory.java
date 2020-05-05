package chapter8.factory;

/**(
 * @author choijaeyong on 2020/05/05.
 * @project java8action
 * @description
 */
public class ProductFactory {

  public static Product createProduct(String name) {
    switch (name) {
      case "loan":
        return new Loan();
      case "stock":
        return new Stock();
      case "bond":
        return new Bond();
      default:
        throw new RuntimeException("No such product " + name);
    }
  }

}

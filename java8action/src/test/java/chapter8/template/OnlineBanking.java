package chapter8.template;

import chapter8.Customer;
import chapter8.Database;
import java.util.function.Consumer;

/**
 * @author choijaeyong on 2020/05/03.
 * @project java8action
 * @description
 */
public abstract class OnlineBanking {
  public void processCustomer(int id, Consumer<Customer> makeCustomrHappy) {
    Customer c = Database.getCustomerWithId(id);
    makeCustomrHappy(c);
    makeCustomrHappy.accept(c);
  }

  protected abstract void makeCustomrHappy(Customer c);

}

package chapter8.template;

import chapter8.Customer;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/05/03.
 * @project java8action
 * @description
 */
public class OnlineBankingTest {
  @Test
  public void test() {
    new OnlineBankingLamda().processCustomer(1333, (Customer c) -> System.out.println());
  }

}

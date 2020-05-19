package chapter11;

import java.util.concurrent.Future;

/**
 * @author choijaeyong on 2020/05/18.
 * @project java8action
 * @description
 */
public interface Shop {
  double getPrice(String product);
  Future<Double> getPriceAsync(String product);

}

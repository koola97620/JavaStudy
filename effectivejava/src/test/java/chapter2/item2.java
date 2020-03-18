package chapter2;

import chapter2.MyPizza.Size;
import chapter2.Pizza.Topping;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/03/18.
 * @project effectivejava
 * @description
 */
public class item2 {

  @Test
  public void test() {
    MyPizza pizza = new MyPizza.Builder(Size.SMALL).addTopping(Topping.ONION).build();
  }

}

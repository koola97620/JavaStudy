package chapter4;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;

/**
 * @author choijaeyong on 2020/03/31.
 * @project java8action
 * @description
 */
public class Exam2 {

  @BeforeEach
  public void setUp() {
    List<Dish> menu = Arrays.asList(
      new Dish("pork", false, 800, Dish.Type.MEAT);

    );
  }

}

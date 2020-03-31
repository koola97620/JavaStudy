package chapter4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/03/30.
 * @project java8action
 * @description
 */
public class exam1 {

  @Test
  public void test() {
    List<Dish> menues = new ArrayList<>();
    menues.add(new Dish(100,"meat"));
    menues.add(new Dish(120,"chicken"));

    List<String> lowCaloricDishesName =
      menues.stream().filter( d -> d.getCalories() > 50)
        .sorted(Comparator.comparing(Dish::getCalories))
        .map(dish -> dish.getName())
        .collect(Collectors.toList());


  }

}

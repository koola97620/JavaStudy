package chapter5;

import chapter5.Dish.Type;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/03/31.
 * @project java8action
 * @description
 */
public class Exam {

  private List<Dish> menu;

  @BeforeEach
  public void setUp() {
    menu = Arrays.asList(
      new Dish("pork", false, 800, Type.MEAT),
      new Dish("beef", false, 700, Type.MEAT),
      new Dish("chicken", false, 400, Type.MEAT),
      new Dish("french", true, 530, Type.OTHER),
      new Dish("rice", true, 350, Type.OTHER),
      new Dish("season fruit", true, 120, Type.OTHER),
      new Dish("pizza", true, 550, Type.OTHER),
      new Dish("prawns", false, 300, Type.FISH),
      new Dish("salmon", false, 450, Type.FISH)
    );
  }

  @Test
  public void test() {
    List<Dish> dishes = menu.stream().filter(d -> d.getCalories() > 300)
        .limit(3)
        .collect(Collectors.toList());

    List<Dish> meats = menu.stream()
        .filter(d -> d.getType() == Type.MEAT)
        .limit(2)
        .collect(Collectors.toList());



  }

}

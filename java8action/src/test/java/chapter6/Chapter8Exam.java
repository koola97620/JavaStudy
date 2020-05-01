package chapter6;

import chapter6.Dish.Type;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/05/01.
 * @project java8action
 * @description
 */
public class Chapter8Exam {
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
    menu
        .stream()
        .collect(Collectors.groupingBy(
            dish -> {
              if (dish.getCalories() <= 400) return CaloricLevel.DIET;
              else if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
              else return CaloricLevel.FAT;
            }

    ));

    menu.stream().collect(Collectors.groupingBy(Dish::getType ,
        Collectors.collectingAndThen(
            Collectors.maxBy(Comparator.comparing(Dish::getCalories)), Optional::get
        )));

    menu.stream().map(Dish::getCalories).reduce(0 , (c1,c2) -> c1+c2);
    menu.stream().mapToInt(Dish::getCalories).sum();
  }

}

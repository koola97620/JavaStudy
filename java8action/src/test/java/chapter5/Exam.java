package chapter5;

import chapter5.Dish.Type;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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

    List<String> words = Arrays.asList("java","in","action");
    List<Integer> wordLengths = words.stream()
        .map(w -> w.length())
        .collect(Collectors.toList());

    List<Integer> collect = menu.stream().map(Dish::getName).map(String::length)
        .collect(Collectors.toList());

    List<String[]> collect1 = words.stream()
        .map(word -> word.split(""))
        .distinct()
        .collect(Collectors.toList());

    String[] arrayOfWords = {"goodbye" , "world"};
    Stream<String> streamOfWords = Arrays.stream(arrayOfWords);

    List<String> collect2 = words.stream()
        .map(word -> word.split(""))
        .flatMap(strs -> Arrays.stream(strs))
        .distinct()
        .collect(Collectors.toList());

    List<Integer> nums = Arrays.asList(1,2,3,4,5);
    List<Integer> collect3 = nums.stream()
        .map(n -> n * n)
        .collect(Collectors.toList());

    List<Integer> nums1 = Arrays.asList(1,2,3);
    List<Integer> nums2 = Arrays.asList(3,4);
    List<int[]> collect4 = nums1.stream()
        .flatMap(i -> nums.stream().map(j -> new int[]{i, j}))
        .collect(Collectors.toList());

    if (menu.stream().anyMatch(Dish::isVegetarian)) {
      System.out.println("the menu is vegetarian friendly");
    }

    boolean isHealthy = menu.stream().allMatch(d -> d.getCalories() < 100);
    boolean isHealthy2 = menu.stream().noneMatch(d -> d.getCalories() > 100);



  }

}

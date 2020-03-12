package chapter2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/03/12.
 * @project java8InAction
 * @description
 */
public class Exam1Test {

  @Test
  public void filterTest1() {
    List<Apple> inventory = Arrays.asList(
        new Apple("red") ,
        new Apple("green") ,
        new Apple("yellow"));
    filterGreenApples(inventory);

  }

  public List<Apple> filterGreenApples(List<Apple> inventory) {
    List<Apple> result = new ArrayList<Apple>();
    for (Apple apple : inventory) {
      if ("green".equals(apple.getColor())) {
        result.add(apple);
      }
    }
    return result;
  }

}

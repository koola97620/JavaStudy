package chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/03/16.
 * @project java8action
 * @description
 */
public class Exam2Test {

  private List<Apple> apples;

  @BeforeEach
  public void setUp() {
    apples = Arrays.asList(
        new Apple("red"),
        new Apple("green"),
        new Apple("yellow"));
  }

  @Test
  public void exam() {
    List<Apple> apples = filterApples(this.apples, new AppleGreenColorPredicate());
    System.out.println(apples.size());

    List<Apple> appleList = filterApples(apples, new ApplePredicate() {
      public boolean test(Apple apple) {
        return "red".equals(apple.getColor());
      }
    });

    List<Apple> lamdaApples = filterApples(apples, (Apple apple) -> "green".equals(apple.getColor()) );

  }

  private List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
    List<Apple> result = new ArrayList<Apple>();
    for (Apple apple : inventory) {
      if(p.test(apple)) {
        result.add(apple);
      }
    }
    return result;

  }

}

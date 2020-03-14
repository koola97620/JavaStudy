package chapter2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * @author choijaeyong on 2020/03/12.
 * @project java8InAction
 * @description
 */
public class Exam1Test {

  private List<Apple> inventory;

  @BeforeEach
  public void setUp() {
    inventory = Arrays.asList(
        new Apple("red") ,
        new Apple("green") ,
        new Apple("yellow"));
  }

  @Test
  public void filterTest1() {
    filterGreenApples(inventory);

  }

  @Test
  public void filterTest2() {
    List<Apple> greenApples = filterApplesByColor(inventory, "green");
    List<Apple> redApples = filterApplesByColor(inventory, "red");


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

  public List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
    List<Apple> result = new ArrayList<Apple>();
    for (Apple apple : inventory) {
      if (apple.getColor().equals(color)) {
        result.add(apple);
      }
    }
    return result;
  }

}

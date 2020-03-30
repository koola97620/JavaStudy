package chapter4;

import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/03/30.
 * @project java8action
 * @description
 */
public class Dish {
  private int calories;
  private String name;

  public Dish(int calories, String name) {
    this.calories = calories;
    this.name = name;
  }

  public int getCalories() {
    return calories;
  }

  public void setCalories(int calories) {
    this.calories = calories;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

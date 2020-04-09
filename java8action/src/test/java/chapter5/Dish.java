package chapter5;

/**
 * @author choijaeyong on 2020/03/30.
 * @project java8action
 * @description
 */
public class Dish {
  private String name;
  private boolean vegetarian;
  private int calories;
  private Type type;

  public Dish(String name, boolean vegetarian, int calories, Type type) {
    this.name = name;
    this.vegetarian = vegetarian;
    this.calories = calories;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public boolean isVegetarian() {
    return vegetarian;
  }

  public int getCalories() {
    return calories;
  }

  public Type getType() {
    return type;
  }

  @Override
  public String toString() {
    return "Dish{" +
        "name='" + name + '\'' +
        ", vegetarian=" + vegetarian +
        ", calories=" + calories +
        ", type=" + type +
        '}';
  }

  public enum Type {
    MEAT, FISH, OTHER
  }
}

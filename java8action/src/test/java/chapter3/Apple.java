package chapter3;

/**
 * @author choijaeyong on 2020/03/12.
 * @project java8InAction
 * @description
 */
public class Apple {

  private String color;
  private Integer weight;
  private String country;

  public Apple(String color) {
    this.color = color;
  }

  public Apple(Integer i) {

  }

  public String getColor() {
    return color;
  }

  public Integer getWeight() {
    return weight;
  }

  public String getCountry() {
    return country;
  }
}

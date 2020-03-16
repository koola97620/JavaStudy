package chapter2;

/**
 * @author choijaeyong on 2020/03/16.
 * @project java8action
 * @description
 */
public class AppleGreenColorPredicate implements ApplePredicate{

  public boolean test(Apple apple) {
    return "green".equals(apple.getColor());
  }
}

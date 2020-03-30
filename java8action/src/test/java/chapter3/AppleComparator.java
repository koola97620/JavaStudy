package chapter3;

import java.util.Comparator;

/**
 * @author choijaeyong on 2020/03/30.
 * @project java8action
 * @description
 */
public class AppleComparator implements Comparator<Apple> {

  @Override
  public int compare(Apple a1, Apple a2) {
    return a1.getWeight().compareTo(a2.getWeight());
  }
}

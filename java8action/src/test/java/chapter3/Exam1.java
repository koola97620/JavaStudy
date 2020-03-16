package chapter3;

import java.util.Comparator;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/03/16.
 * @project java8action
 * @description
 */
public class Exam1 {

  @Test
  public void test() {
    Comparator<Apple> comparator = new Comparator<Apple>() {
      @Override
      public int compare(Apple o1, Apple o2) {
        return o1.getWeight().compareTo(o2.getWeight());
      }
    };

    Comparator<Apple> appleComparator =
        Comparator.comparing(Apple::getWeight);


  }

}

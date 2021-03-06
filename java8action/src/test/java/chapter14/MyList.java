package chapter14;

import java.util.function.Predicate;

/**
 * @author choijaeyong on 2020/05/31.
 * @project java8action
 * @description
 */
public interface MyList<T> {
  T head();

  MyList<T> tail();

  default boolean isEmpty() {
    return true;
  }

  MyList<T> filter(Predicate<T> p);

}

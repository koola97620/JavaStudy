package chapter14;

import java.util.function.Predicate;

/**
 * @author choijaeyong on 2020/05/31.
 * @project java8action
 * @description
 */
public class Empty<T> implements MyList<T> {

  @Override
  public T head() {
    throw new UnsupportedOperationException();
  }

  @Override
  public MyList<T> tail() {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public MyList<T> filter(Predicate<T> p) {
    throw new UnsupportedOperationException();
  }
}

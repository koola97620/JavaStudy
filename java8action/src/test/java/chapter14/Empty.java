package chapter14;

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
}

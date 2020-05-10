package chapter9;

/**
 * @author choijaeyong on 2020/05/10.
 * @project java8action
 * @description
 */
public interface Sized {
  int size();
  default boolean isEmpty() {
    return size() == 0;
  }

}

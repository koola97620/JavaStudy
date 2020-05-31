package chapter14;

/**
 * @author choijaeyong on 2020/05/31.
 * @project java8action
 * @description
 */
public class MyLinkedList<T> implements MyList<T> {

  private final T head;
  private final MyList<T> tail;

  public MyLinkedList(T head, MyList<T> tail) {

    this.head = head;
    this.tail = tail;
  }

  @Override
  public T head() {
    return head;
  }

  @Override
  public MyList<T> tail() {
    return tail;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }
}

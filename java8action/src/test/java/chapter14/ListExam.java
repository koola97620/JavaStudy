package chapter14;

import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/05/31.
 * @project java8action
 * @description
 */
public class ListExam {

  @Test
  public void test() {
    MyList<Integer> l = new MyLinkedList<>(5,new MyLinkedList<>(10,new Empty<>()));
  }

}

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

  public static LazyList<Integer> from(int n) {
    return new LazyList<Integer>(n, ()->from(n+1));
  }

  @Test
  public void test2() {
    LazyList<Integer> numbers = from(2);
    int two = numbers.head();
    int three = numbers.tail().head();
    int four = numbers.tail().tail().head();

    System.out.println(two + "  " + three + "  " +  four);
  }

  public static MyList<Integer> primes(MyList<Integer> numbers) {
    return new LazyList<>(
        numbers.head() ,
        () -> primes(
            numbers.tail().filter(n -> n % numbers.head() != 0)
        )
    );
  }

  @Test
  public void test3() {
    LazyList<Integer> numbers = from(2);
    int two = primes(numbers).head();
    int three = primes(numbers).tail().head();
    int five = primes(numbers).tail().tail().head();

    System.out.println(two + "  " + three + "  " +  five);

  }

}

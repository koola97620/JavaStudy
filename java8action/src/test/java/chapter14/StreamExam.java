package chapter14;

import java.util.stream.Stream;

/**
 * @author choijaeyong on 2020/05/31.
 * @project java8action
 * @description
 */
public class StreamExam {
  public static Stream<Integer> primes(int n) {
    return Stream.iterate(2, i -> i+1)
        .filter(MyMathUtils::isPrime)
        .limit(n);
  }



}

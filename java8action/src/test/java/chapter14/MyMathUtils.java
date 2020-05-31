package chapter14;

import java.util.stream.IntStream;

/**
 * @author choijaeyong on 2020/05/31.
 * @project java8action
 * @description
 */
public class MyMathUtils {
  public static boolean isPrime(int candidate) {
    int candidateRoot = (int)Math.sqrt((double)candidate);
    return IntStream.rangeClosed(2, candidateRoot)
        .noneMatch(i -> candidate % i ==0);
  }

}

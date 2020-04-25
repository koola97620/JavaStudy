package chapter7;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/04/25.
 * @project java8action
 * @description
 */
public class Exam1 {

  @Test
  public void page228() {

  }

  private static long sequentialSum(long n) {
    return Stream.iterate(1L , i -> i + 1)
        .limit(n)
        .reduce(0L, Long::sum);
  }

  private static long parallelSum(long n) {
    return Stream.iterate(0L , i -> i+1)
        .limit(n)
        .parallel()
        .reduce(0L, Long::sum);
  }

}

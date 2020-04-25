package chapter7;

import java.util.function.Function;
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

  public long measureSumPerf(Function<Long,Long> adder, long n) {
    long fastest = Long.MAX_VALUE;
    for (int i=0; i < 10 ; i++) {
      long start = System.nanoTime();
      long sum = adder.apply(n);
      long duration = (System.nanoTime() - start) /1_000_000;
      System.out.println("result : " + sum);
      if (duration < fastest) fastest = duration;
    }
    return fastest;
  }

}

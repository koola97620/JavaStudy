package chapter7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/04/26.
 * @project java8action
 * @description
 */
public class FormJoinExam {

  @Test
  public void page241() {
    long n =12;

  }

  private static long forkJoinSum(long n) {
    long[] numbers = LongStream.rangeClosed(1, n).toArray();
    ForkJoinTask<Long> forkJoinSumCalculator = new ForkJoinSumCalculator(numbers);
    return new ForkJoinPool().invoke(forkJoinSumCalculator);
  }

}

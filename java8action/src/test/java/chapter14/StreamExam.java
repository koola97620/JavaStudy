package chapter14;

import java.util.stream.IntStream;
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

  static IntStream numbers() {
    return IntStream.iterate(2, n-> n+1);
  }

  static int head(IntStream numbers) {
    return numbers.findFirst().getAsInt();
  }

  static IntStream tail(IntStream numbers) {
    return numbers.skip(1);
  }

  static IntStream primes(IntStream numbers) {
    int head = head(numbers);
    return IntStream.concat(
        IntStream.of(head) , primes(tail(numbers).filter(n -> n % head != 0))
    );

  }

}

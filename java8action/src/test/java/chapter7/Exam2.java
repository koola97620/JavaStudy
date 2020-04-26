package chapter7;

import java.util.LinkedList;
import java.util.stream.LongStream;

/**
 * @author choijaeyong on 2020/04/26.
 * @project java8action
 * @description
 */
public class Exam2 {

  public static long sideEffectSum(long n) {
    Accumulator accumulator = new Accumulator();
    LongStream.rangeClosed(1,n).forEach(accumulator::add);
    LinkedList linkedList = new LinkedList();
    linkedList.add(1);
    return accumulator.total;
  }

}

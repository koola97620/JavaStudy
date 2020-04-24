package chapter6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @author choijaeyong on 2020/04/19.
 * @project java8action
 * @description
 */
public class ToListCollector<T> implements Collector<T, List<T> , List<T>> {

  public Supplier<List<T>> supplier() {
    return () -> new ArrayList<T>();
  }

  public BiConsumer<List<T>, T> accumulator() {
    return (list, item) -> list.add(item);
  }

  public Function<List<T> , List<T>> finisher() {
    return Function.identity();
  }

  public BinaryOperator<List<T>> combiner() {
    return (list1, list2) -> {
      list1.addAll(list2);
      return list1;
    };
  }

  @Override
  public Set<Characteristics> characteristics() {
    return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT));
  }
}
package chapter3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

/**
 * @author choijaeyong on 2020/03/30.
 * @project java8action
 * @description
 */
public class AppleSortExam {

  @Test
  public void exam() {
    List<Apple> apples = new ArrayList<>();
    apples.add(new Apple("green"));

    apples.sort(new AppleComparator());

    apples.sort(new Comparator<Apple>() {
      @Override
      public int compare(Apple o1, Apple o2) {
        return o1.getWeight().compareTo(o2.getWeight());
      }
    });

    apples.sort( (a1,a2) -> a1.getWeight().compareTo(a2.getWeight()));
    apples.sort(Comparator.comparing(Apple::getWeight));

    Comparator<Apple> comparing = Comparator
        .comparing( (Apple a) -> a.getWeight()  );

    Comparator<Apple> c = Comparator.comparing(Apple::getWeight);

    apples.sort(Comparator.comparing(Apple::getWeight).reversed());

    apples.sort(Comparator.comparing(Apple::getWeight)
        .reversed()
        .thenComparing(Apple::getCountry));

    Predicate<Apple> p = (Apple a) -> a.getColor().equals("green");

    Predicate<Apple> p2 = p.negate();
    Predicate<Apple> p3 = p.and( apple -> apple.getWeight() > 150);

    Function<Integer, Integer> f = x -> x + 1;
    Function<Integer, Integer> g = x -> x * 2;
    Function<Integer, Integer> h = f.andThen(g);

    int result = h.apply(2);
    assertThat(6).isEqualTo(result);

    Function<Integer, Integer> k = f.compose(g);







  }

}

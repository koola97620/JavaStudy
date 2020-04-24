package chapter6;

import chapter6.Dish.Type;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/03/31.
 * @project java8action
 * @description
 */
public class Exam {

  private List<Dish> menu;

  @BeforeEach
  public void setUp() {
    menu = Arrays.asList(
      new Dish("pork", false, 800, Type.MEAT),
      new Dish("beef", false, 700, Type.MEAT),
      new Dish("chicken", false, 400, Type.MEAT),
      new Dish("french", true, 530, Type.OTHER),
      new Dish("rice", true, 350, Type.OTHER),
      new Dish("season fruit", true, 120, Type.OTHER),
      new Dish("pizza", true, 550, Type.OTHER),
      new Dish("prawns", false, 300, Type.FISH),
      new Dish("salmon", false, 450, Type.FISH)
    );
  }


  @Test
  public void page189() {
    menu.stream().collect(Collectors.counting());

    Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
    Optional<Dish> collect = menu.stream().collect(Collectors.maxBy(dishComparator));

    menu.stream().collect(Collectors.summingInt(d -> d.getCalories()));
    menu.stream().collect(Collectors.summingInt(Dish::getCalories));

    IntSummaryStatistics collect1 = menu.stream()
        .collect(Collectors.summarizingInt(Dish::getCalories));


    menu.stream().map(Dish::getName).collect(Collectors.joining());
    menu.stream().map(Dish::getName).collect(Collectors.joining(","));

    menu.stream().collect(Collectors.reducing(0, d -> d.getCalories() , (i,j) -> i+j));

    menu.stream().collect(Collectors.reducing( (d1,d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));

    menu.stream().collect(Collectors.reducing(0,Dish::getCalories,Integer::sum));
  }

  @Test
  public void grouping() {
    menu.stream().collect(Collectors.groupingBy(d -> d.getType()));

    menu.stream().collect(
        Collectors.groupingBy(dish -> {
          if (dish.getCalories() <= 400) {
            return CaloricLevel.DIET;
          } else if (dish.getCalories() <= 700) {
            return CaloricLevel.NORMAL;
          } else  {
            return CaloricLevel.FAT;
          }
        })
    );

    menu.stream().collect(
        Collectors.groupingBy(Dish::getType ,
            Collectors.groupingBy( dish -> {
              if (dish.getCalories() <= 400) {
                return CaloricLevel.DIET;
              } else if (dish.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
              } else  {
                return CaloricLevel.FAT;
              }
            }

            ))
    );

    Map<Type, Long> collect = menu.stream()
        .collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));

    Map<Type, Optional<Dish>> collect1 = menu.stream().collect(Collectors
        .groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparing(Dish::getCalories))));

    Map<Type, Dish> collect2 = menu.stream().collect(
        Collectors.groupingBy(Dish::getType,
            Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.comparingInt(d -> d.getCalories() )), Optional::get
            ))
    );

    menu.stream().collect(Collectors.groupingBy(Dish::getType ,
        Collectors.summingInt(Dish::getCalories)));

    Map<Type, Set<CaloricLevel>> collect3 = menu.stream().collect(
        Collectors.groupingBy(Dish::getType,
            Collectors.mapping(dish -> {
              if (dish.getCalories() <= 400) {
                return CaloricLevel.DIET;
              } else if (dish.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
              } else {
                return CaloricLevel.FAT;
              }
            }, Collectors.toSet()))
    );

    Map<Type, HashSet<CaloricLevel>> collect4 = menu.stream().collect(
        Collectors.groupingBy(Dish::getType,
            Collectors.mapping(dish -> {
              if (dish.getCalories() <= 400) {
                return CaloricLevel.DIET;
              } else if (dish.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
              } else {
                return CaloricLevel.FAT;
              }
            }, Collectors.toCollection(HashSet::new)))
    );

    // page 205 분할
    Map<Boolean, List<Dish>> collect5 = menu.stream()
        .collect(Collectors.partitioningBy(Dish::isVegetarian));
    List<Dish> dishes = collect5.get(true);

    List<Dish> collect6 = menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());

    menu.stream().collect(
        Collectors.partitioningBy(Dish::isVegetarian, Collectors.groupingBy(Dish::getType))
    );

    Map<Boolean, Dish> collect7 = menu.stream().collect(
        Collectors.partitioningBy(Dish::isVegetarian,
            Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get
            ))
    );


  }

  private boolean isPrime(int candidate) {
    int candidateRoot = (int) Math.sqrt( (double) candidate);
    return IntStream.rangeClosed(2,candidateRoot)
        .noneMatch(i -> candidate % i == 0);

//    return IntStream.range(2,candidate)
//        .noneMatch(i -> candidate % i == 0);
  }

  public Map<Boolean, List<Integer>> partitionPrimes(int n) {
    return IntStream.rangeClosed(2,n).boxed()
        .collect(Collectors.partitioningBy(candidate -> isPrime(candidate)));
  }

  public Map<Boolean, List<Integer>> partitionPrimesWithCollector(int n ) {
    return IntStream.rangeClosed(2,n).boxed()
        .collect(new PrimeNumbersCollector());
  }

}

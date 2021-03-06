package chapter5;

import chapter5.Dish.Type;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
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
  public void test() {
    List<Dish> dishes = menu.stream().filter(d -> d.getCalories() > 300)
        .limit(3)
        .collect(Collectors.toList());

    List<Dish> meats = menu.stream()
        .filter(d -> d.getType() == Type.MEAT)
        .limit(2)
        .collect(Collectors.toList());

    List<String> words = Arrays.asList("java","in","action");
    List<Integer> wordLengths = words.stream()
        .map(w -> w.length())
        .collect(Collectors.toList());

    List<Integer> collect = menu.stream().map(Dish::getName).map(String::length)
        .collect(Collectors.toList());

    List<String[]> collect1 = words.stream()
        .map(word -> word.split(""))
        .distinct()
        .collect(Collectors.toList());

    String[] arrayOfWords = {"goodbye" , "world"};
    Stream<String> streamOfWords = Arrays.stream(arrayOfWords);

    List<String> collect2 = words.stream()
        .map(word -> word.split(""))
        .flatMap(strs -> Arrays.stream(strs))
        .distinct()
        .collect(Collectors.toList());

    List<Integer> nums = Arrays.asList(1,2,3,4,5);
    List<Integer> collect3 = nums.stream()
        .map(n -> n * n)
        .collect(Collectors.toList());

    List<Integer> nums1 = Arrays.asList(1,2,3);
    List<Integer> nums2 = Arrays.asList(3,4);
    List<int[]> collect4 = nums1.stream()
        .flatMap(i -> nums.stream().map(j -> new int[]{i, j}))
        .collect(Collectors.toList());

    if (menu.stream().anyMatch(Dish::isVegetarian)) {
      System.out.println("the menu is vegetarian friendly");
    }

    boolean isHealthy = menu.stream().allMatch(d -> d.getCalories() < 100);
    boolean isHealthy2 = menu.stream().noneMatch(d -> d.getCalories() > 100);

    menu.stream()
        .filter(Dish::isVegetarian)
        .findAny()
        .ifPresent(d -> System.out.println(d.getName()));

    List<Integer> someNums = Arrays.asList(1,2,3,4,5);
    Optional<Integer> firstSquareDivisibleByThree =
        someNums.stream()
        .map(x -> x * x)
        .filter(x -> x % 3 == 0)
        .findFirst();

    someNums.stream().reduce(0, Integer::sum);

    Optional<Integer> max = nums.stream().reduce(Integer::max);
  }

  @Test
  public void page171() {
    menu.stream()
        .map(Dish::getCalories)
        .reduce(0,Integer::sum);

    menu.stream()
        .mapToInt(d -> d.getCalories())
        .sum();

    IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
    Stream<Integer> boxed = intStream.boxed();

    OptionalInt max = menu.stream()
        .mapToInt(d -> d.getCalories())
        .max();
    int i = max.orElse(1);

  }

  @Test
  public void page175() {

//    IntStream.rangeClosed(1,100).boxed()
//        .flatMap(a ->
//            IntStream.rangeClosed(a,100)
//                .filter(b -> Math.sqrt(a*a + b*b) % 1 ==0)
//                .mapToObj(b -> new int[]{a, b (int) Math.sqrt(a*a + b*b) } )
//
//            );


    Stream<String> stream = Stream.of("Java8 ", "Lamdas " , "In ", "Action");
    stream.map(String::toUpperCase).forEach(System.out::println);
  }

  @Test
  public void page179() throws Exception {
    long uniqueWords = 0;
    try (Stream<String> lines =
        Files.lines(Paths.get("data.txt") , Charset.defaultCharset() )) {
      uniqueWords = lines.flatMap( line -> Arrays.stream(line.split(" ")))
          .distinct()
          .count();
    } catch (IOException e) {

    }

    Stream.iterate(0, n -> n+2)
        .limit(10)
        .forEach(System.out::println);

    Stream.iterate(new int[]{0,1} , t -> new int[]{t[1] , t[0] + t[1]})
        .limit(20)
        .map(t -> t[0])
        .forEach(System.out::println);

  }

}

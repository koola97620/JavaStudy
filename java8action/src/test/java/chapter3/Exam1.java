package chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/03/16.
 * @project java8action
 * @description
 */
public class Exam1 {

  @Test
  public void 메서드_레퍼런스() {
    List<String> str = Arrays.asList("a","b","c","d");
    str.sort( (String s1, String s2) -> s1.compareToIgnoreCase(s2));
    str.sort(String::compareToIgnoreCase);

    Function<Integer, Apple> c2 = Apple::new;
    Apple a2 = c2.apply(111);

    List<Integer> weights = Arrays.asList(7,3,4,10);
    List<Apple> apples = map(weights, Apple::new);

    Map<String, String> map = new HashMap<>();
    map.merge("key","value", (v1,v2) -> v1+v2  );
  }

  public static List<Apple> map(List<Integer> list, Function<Integer,Apple> f) {
    List<Apple> result = new ArrayList<>();
    for(Integer e : list) {
      result.add(f.apply(e));
    }
    return result;
  }

  @Test
  public void 형식_추론() {
    List<Apple> apples = new ArrayList<>();
    apples.add(new Apple("green"));
    List<Apple> collect = apples.stream().filter(apple -> "green".equals(apple.getColor()))
        .collect(Collectors.toList());

    int portNumber = 3456;
    Runnable runnable = () -> System.out.println(portNumber);
    // portNumber = 333; 사용불가. 람다에서 참고하는 지역변수는 final 로 선언되거나 실질적으로 final 처럼 되어야 한다


  }

  @Test
  public void 박싱_언박싱() {
    IntPredicate booleanIntFunction = (int i) -> i % 2 == 0;
    Predicate<Integer> integerFilter = (Integer integer) -> integer % 2 == 0;
    booleanIntFunction.test(1000);
    integerFilter.test(1000);

  }

  @Test
  public void test() {
    Comparator<Apple> comparator = new Comparator<Apple>() {
      @Override
      public int compare(Apple o1, Apple o2) {
        return o1.getWeight().compareTo(o2.getWeight());
      }
    };
    Comparator<Apple> byWeight = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

    Filter<Apple> appleFilter = (Apple a) -> a.getWeight() > 100;

    Runnable r1 = () -> System.out.println("hello world");
    Runnable r2 = new Runnable() {
      @Override
      public void run() {
        System.out.println("hello world 2");
      }
    };

    process(r1);
    process(r2);



    Comparator<Apple> appleComparator =
        Comparator.comparing(Apple::getWeight);

  }

  public void process(Runnable r) {
    r.run();
  }

  public void exam2() throws IOException{
    //String s = processFile( (BufferedReader br) -> br.readLine() + br.readLine() );
    String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine() );
    String oneLine = processFile((BufferedReader br) -> br.readLine());


  }

  public String processFile() throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
      return br.readLine();
    }
  }

  public String processFile(BufferedReaderProcessor p) throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
      return p.process(br);
    }
  }

}


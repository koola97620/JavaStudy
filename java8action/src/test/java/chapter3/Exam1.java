package chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/03/16.
 * @project java8action
 * @description
 */
public class Exam1 {

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


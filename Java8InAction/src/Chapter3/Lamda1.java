package Chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author choijaeyong on 03/02/2019.
 * @project java8InAction
 * @description
 */


@FunctionalInterface
interface BufferedReaderProcessor {
  String process(BufferedReader b) throws IOException;
}


public class Lamda1 {

  public static void main(String[] args) throws IOException {
  //    Comparator<Apple> byWeight = (Apple a1,Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

    String oneLine = processFile((BufferedReader br) -> br.readLine());
    BufferedReaderProcessor b = (BufferedReader br) -> br.readLine();



    List<String> str = Arrays.asList("a","b","A","B");
    str.sort((s1,s2) -> s1.compareToIgnoreCase(s2));
    str.sort(String::compareToIgnoreCase);




  }

  public static String processFile(BufferedReaderProcessor p) throws IOException {
    try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
      return p.process(br);
    }
  }

}

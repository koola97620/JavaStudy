package chapter7;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/04/28.
 * @project java8action
 * @description
 */
public class SpliteratorExam {

  @Test
  public void page249() {
    String SENTENCE = " Nel mezzo del cammin di nostra vita "
        + "mi ritrovai in una selva socura"
        + "ch la dritta via era smarrita ";

    Stream<Character> characterStream = IntStream.range(0, SENTENCE.length())
        .mapToObj(SENTENCE::charAt);

    System.out.println("Found " + countWords(characterStream) + " words");

    characterStream = IntStream.range(0, SENTENCE.length())
        .mapToObj(SENTENCE::charAt);
    System.out.println("Found " + countWords(characterStream.parallel()) + " words");

  }

  private int countWords(Stream<Character> stream) {
    WordCounter reduce = stream
        .reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
    return reduce.getCounter();
  }

}

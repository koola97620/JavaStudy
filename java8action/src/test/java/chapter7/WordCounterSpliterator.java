package chapter7;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author choijaeyong on 2020/04/30.
 * @project java8action
 * @description
 */
public class WordCounterSpliterator implements Spliterator<Character> {
  private String string;
  private int currentChar = 0;

  public WordCounterSpliterator(String string) {
    this.string = string;
  }

  @Override
  public boolean tryAdvance(Consumer<? super Character> action) {
    action.accept(string.charAt(currentChar++));
    return currentChar < string.length();
  }

  @Override
  public Spliterator<Character> trySplit() {
    int currentSize = string.length() - currentChar;
    if (currentSize < 10) {
      return null;
    }
    for (int splitPos = currentSize / 2 + currentChar ; splitPos < string.length() ; splitPos++) {
      if (Character.isWhitespace(string.charAt(splitPos))) {
        Spliterator<Character> spliterator =
            new WordCounterSpliterator(string.substring(currentChar , splitPos));
        currentChar = splitPos;
        return spliterator;
      }
    }
    return null;
  }

  @Override
  public long estimateSize() {
    return string.length() - currentChar;
  }

  @Override
  public int characteristics() {
    return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
  }
}

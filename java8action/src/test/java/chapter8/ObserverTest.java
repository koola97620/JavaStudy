package chapter8;

import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/05/03.
 * @project java8action
 * @description
 */
public class ObserverTest {
  @Test
  public void test() {
    Feed feed = new Feed();
    feed.registerObserver(new NYTimes());
    feed.registerObserver(new Guardian());
    feed.registerObserver(new Lemonde());
    feed.notifyObservers("The queen said her favorite book is Java 8 in action");

    feed.registerObserver( (String tweet) -> {
      if (tweet != null) {
        System.out.println("tweet lamda");
      }
    });
  }

}

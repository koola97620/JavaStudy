package chapter8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author choijaeyong on 2020/05/03.
 * @project java8action
 * @description
 */
public class Feed implements Subject {
  private final List<Observer> observers = new ArrayList<>();

  @Override
  public void registerObserver(Observer o) {
    this.observers.add(o);
  }

  @Override
  public void notifyObservers(String tweet) {
    observers.forEach( (Observer o) -> o.notify(tweet));
  }
}

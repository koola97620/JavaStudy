package chapter8.observer;

/**
 * @author choijaeyong on 2020/05/03.
 * @project java8action
 * @description
 */
public interface Subject {
  void registerObserver(Observer o);
  void notifyObservers(String tweet);

}

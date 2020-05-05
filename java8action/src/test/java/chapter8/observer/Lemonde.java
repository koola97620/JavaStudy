package chapter8.observer;

/**
 * @author choijaeyong on 2020/05/03.
 * @project java8action
 * @description
 */
public class Lemonde implements Observer {

  @Override
  public void notify(String tweet) {
    if (tweet != null && tweet.contains("money")) {
      System.out.println("Today cheese, wine and news! " + tweet);
    }
  }
}

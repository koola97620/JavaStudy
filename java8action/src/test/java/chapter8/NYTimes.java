package chapter8;

/**
 * @author choijaeyong on 2020/05/03.
 * @project java8action
 * @description
 */
public class NYTimes implements Observer {

  @Override
  public void notify(String tweet) {
    if (tweet != null && tweet.contains("money")) {
      System.out.println("Breaking news in NY! " + tweet);
    }
  }
}

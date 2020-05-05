package chapter8.observer;

/**
 * @author choijaeyong on 2020/05/03.
 * @project java8action
 * @description
 */
public class Guardian implements Observer {

  @Override
  public void notify(String tweet) {
    if (tweet != null && tweet.contains("queen")) {
      System.out.println("Yet another news in London...  " + tweet);
    }
  }
}

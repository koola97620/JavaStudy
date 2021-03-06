package chapter8.strategy;

/**
 * @author choijaeyong on 2020/05/01.
 * @project java8action
 * @description
 */
public class IsAllLowerCase implements ValidationStrategy {

  @Override
  public boolean execute(String s) {
    return s.matches("[a-z]+");
  }
}

package chapter8;

/**
 * @author choijaeyong on 2020/05/01.
 * @project java8action
 * @description
 */
public class IsNumeric implements ValidationStrategy {

  @Override
  public boolean execute(String s) {
    return s.matches("\\d+");
  }
}

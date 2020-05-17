package chapter10;

import java.util.Optional;

/**
 * @author choijaeyong on 2020/05/17.
 * @project java8action
 * @description
 */
public class OptionUtility {

  public static Optional<Integer> stringToInt(String s) {
    try {
      return Optional.of(Integer.parseInt(s));
    } catch (NumberFormatException e) {
      return Optional.empty();
    }
  }

}

package chapter10;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.Properties;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/05/17.
 * @project java8action
 * @description
 */
public class Exam3 {
  @Test
  public void test() {
    Properties properties = new Properties();
    properties.setProperty("a", "5");
    properties.setProperty("b", "true");
    properties.setProperty("c", "-3");

    assertThat(5).isEqualTo(readDuration(properties , "a"));
    assertThat(0).isEqualTo(readDuration(properties , "b"));
    assertThat(0).isEqualTo(readDuration(properties , "c"));
    assertThat(0).isEqualTo(readDuration(properties , "d"));

  }

  private int readDuration(Properties props , String name) {

//    Optional.ofNullable(props.getProperty(name))
//        .flatMap( s -> OptionUtility.stringToInt(s))
//        .filter( i -> i > 0)
//        .orElse(0);

    String value = props.getProperty(name);
    if (value != null) {
      try {
        int i = Integer.parseInt(value);
        if (i > 0) {
          return i;
        }
      } catch (NumberFormatException e) {

      }
    }

    return 0;
  }

}

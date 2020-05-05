package chapter8.strategy;

import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/05/02.
 * @project java8action
 * @description
 */
public class ValidatorClientTest {

  @Test
  public void test() {
    Validator validator = new Validator(new IsNumeric());
    boolean b1 = validator.validate("aaaa");

    Validator validator2 = new Validator(new IsAllLowerCase());
    boolean b2 = validator2.validate("bbbb");
  }

  @Test
  public void use_lamda() {
    Validator validator = new Validator((String s) -> s.matches("[a-z]+"));
    boolean b1 = validator.validate("aaaa");

    Validator validator2 = new Validator((String s) -> s.matches("\\d+"));
    boolean b2 = validator2.validate("bbbb");
  }

}

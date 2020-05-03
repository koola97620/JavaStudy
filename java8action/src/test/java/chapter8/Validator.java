package chapter8;

/**
 * @author choijaeyong on 2020/05/02.
 * @project java8action
 * @description
 */
public class Validator {

  private ValidationStrategy validationStrategy;

  public Validator(ValidationStrategy validationStrategy) {
    this.validationStrategy = validationStrategy;
  }

  public boolean validate(String s) {
    return validationStrategy.execute(s);
  }

}

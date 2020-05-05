package chapter8.strategy;

import chapter8.strategy.ValidationStrategy;

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

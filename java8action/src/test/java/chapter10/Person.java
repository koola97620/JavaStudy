package chapter10;

import java.util.Optional;

/**
 * @author choijaeyong on 2020/05/13.
 * @project java8action
 * @description
 */
public class Person {
//  private Car car;
//  public Car getCar() {return car;}

  private Optional<Car> car;

  public Optional<Car> getCar() {
    return car;
  }

  private int age;
  public int getAge() {
    return age;
  }
}

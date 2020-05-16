package chapter10;

import java.util.Optional;

/**
 * @author choijaeyong on 2020/05/13.
 * @project java8action
 * @description
 */
public class Car {
//  private Insurance insurance;
//  public Insurance getInsurance() {
//    return insurance;
//  }

  private Optional<Insurance> insurance;

  public Optional<Insurance> getInsurance() {
    return insurance;
  }
}

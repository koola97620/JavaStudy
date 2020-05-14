package chapter10;

import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/05/14.
 * @project java8action
 * @description
 */
public class Exam {

  @Test
  public void test() {

  }

  private String getCarInsuraceName(Person person) {
    if (person != null) {
      Car car = person.getCar();
      if (car != null) {
        Insurance insurance = car.getInsurance();
        if (insurance != null) {
          return insurance.getName();
        }
      }
    }
    return "Unknown";
  }

}

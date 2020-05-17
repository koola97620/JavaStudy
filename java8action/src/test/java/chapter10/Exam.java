package chapter10;

import java.util.Optional;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/05/14.
 * @project java8action
 * @description
 */
public class Exam {

  @Test
  public void test() {
    Person person = new Person();
    Optional<Car> car = person.getCar();

    Optional<Insurance> insurance = car.get().getInsurance();

    String name = null;
    if (insurance.isPresent()) {
      name = insurance.get().getName();
    }

    Insurance insurance2 = car.get().getInsurance().get();
    Optional<Insurance> optInsurance = Optional.ofNullable(insurance2);
    Optional<String> s = optInsurance.map(Insurance::getName);
  }

  @Test
  public void test2() {
    Person person = new Person();
    Optional<Person> optPerson = Optional.of(person);
    Optional<String> s = optPerson.map(Person::getCar)
        .map(c -> c.get().getInsurance())
        .map(i -> i.get().getName());
  }

  @Test
  public void test3() {

  }

//  private String getCarInsuraceName(Person person) {
//    if (person != null) {
//      Car car = person.getCar();
//      if (car != null) {
//        Insurance insurance = car.getInsurance();
//        if (insurance != null) {
//          return insurance.getName();
//        }
//      }
//    }
//    return "Unknown";
//  }
//
//  public String getCarInsuranceName(Person person) {
//    if (person == null) {
//      return "Unknown";
//    }
//
//    Car car = person.getCar();
//    if (car == null) {
//      return "Unknown";
//    }
//    Insurance insurance = car.getInsurance();
//    if (insurance == null) {
//      return "Unknown";
//    }
//    return insurance.getName();
//  }

}

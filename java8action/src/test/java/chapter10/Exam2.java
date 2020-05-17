package chapter10;

import java.util.Optional;
import javax.swing.text.html.Option;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/05/17.
 * @project java8action
 * @description
 */
public class Exam2 {
  @Test
  public void test() {
    Person person = new Person();
    Optional<Car> car = person.getCar();
    Optional<Insurance> optionalInsurance = car.get().getInsurance();
    optionalInsurance
        .filter(i -> "CambridgeInsurance".equals(i.getName()))
        .ifPresent(x -> System.out.println(x));
  }

  private Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {

    return person.flatMap( p -> p.getCar().map( c -> findCheapestInsurance(p,c))   );

//    if (person.isPresent() && car.isPresent()) {
//      return Optional.of(findCheapestInsurance(person.get() , car.get()));
//    } else {
//      return Optional.empty();
//    }
  }

  private Insurance findCheapestInsurance(Person person, Car car) {
    return null;
  }

  private String getCarInsuranceName(Optional<Person> person , int minAge) {
    return person.filter( p -> p.getAge() >= minAge )
        .flatMap(Person::getCar)
        .flatMap(Car::getInsurance)
        .map( i -> i.getName())
        .orElse("Unknown");
  }

}

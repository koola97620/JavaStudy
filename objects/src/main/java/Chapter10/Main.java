package Chapter10;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author choijaeyong on 15/08/2019.
 * @project objects
 * @description
 */
public class Main {
  public static void main(String[] args) {
    Phone phone = new Phone(Money.wons(5l) , Duration.ofSeconds(10));
    phone.call(new Call(LocalDateTime.of(2018,1,1,12,10,0) ,
        LocalDateTime.of(2018,1,1,12,11,0)));
    phone.call(new Call(LocalDateTime.of(2018,1,2,12,10,0) ,
        LocalDateTime.of(2018,1,2,12,11,0)));

    Money result = phone.calculateFee();

    System.out.println(result.getMoney().intValue());

  }

}

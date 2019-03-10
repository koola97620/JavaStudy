package Chapter5;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author choijaeyong on 10/02/2019.
 * @project java8InAction
 * @description
 */
public class Stream1 {

  public static void main(String[] args) {

    List<Dish> lists = Dish.menu.stream()
        .filter(d -> d.getName().length() > 5)
        .skip(2)
        .limit(5)
        .collect(Collectors.toList());

    System.out.println(lists);


  }

}

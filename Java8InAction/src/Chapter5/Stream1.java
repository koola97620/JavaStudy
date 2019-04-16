package Chapter5;

import java.util.Arrays;
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

    //System.out.println(lists);

//    List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
//    numbers.stream()
//        .filter(i->i%2==0)
//        .distinct()
//        .forEach(System.out::println);

    List<String> dishName = Dish.menu.stream()
        .map(Dish::getName)
        .collect(Collectors.toList());

    System.out.println(dishName);

    List<Integer> dishNameLength = Dish.menu.stream()
        .map(Dish::getName)
        .map(String::length)
        .collect(Collectors.toList());
    System.out.println(dishNameLength);



  }

}

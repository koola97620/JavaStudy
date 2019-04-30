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

    List<Dish> vegitarianMenu = Dish.menu.stream()
        .filter( (Dish d) -> (!d.isVegetarian()) )
        .collect(Collectors.toList());
    List<Dish> vegitarianMenu2 = Dish.menu.stream()
        .filter(Dish::isVegetarian)
        .collect(Collectors.toList());


    /*
    Returns a fixed-size list backed by the specified array.
    (Changes to the returned list "write through" to the array.)
    This method acts as bridge between array-based and collection-based APIs,
    in combination with Collection.toArray(). The returned list is serializable and
    implements RandomAccess.
     */
    List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
    //numbers.add(5); UnsupportedOperationException 발생.
    System.out.println(numbers);







  }

}

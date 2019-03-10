package Chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author choijaeyong on 05/02/2019.
 * @project java8InAction
 * @description
 */
public class Stream {

  public static void main(String[] args) {

    List<Dish2> menu = new ArrayList<>();

    // 누적자로 요소 필터링
    List<Dish2> lowCaloricDishes = new ArrayList<>();
    for(Dish2 d : menu) {
      if(d.getCalories() < 400) {
        lowCaloricDishes.add(d);
      }
    }
    // 익명 클래스로 요리 정렬
    Collections.sort(lowCaloricDishes, new Comparator<Dish2>() {
      @Override
      public int compare(Dish2 o1, Dish2 o2) {
        return o1.getCalories().compareTo(o2.getCalories());
      }
    });
    Function<Dish2,Integer> func = (Dish2 d) -> (d.getCalories());
    Collections.sort(lowCaloricDishes,Comparator.comparing(func));
    //Collections.sort(lowCaloricDish2es,Comparator.comparing(Dish2::getCalories));

    Comparator<Dish2> comp = Comparator.comparing(Dish2::getCalories);
    lowCaloricDishes.sort(comp);




    // stream
    List<String> lowCaloriesDishesName =
        menu.stream()
          .filter( (Dish2 d) -> d.getCalories() <= 400)  // 400칼로리 이하의 요리 선택
          .sorted(Comparator.comparing(Dish2::getCalories)) // 칼로리로 요리 정렬
          .map(Dish2::getName) // 요리명 추출
          .collect(Collectors.toList()); // 모든 요리명을 리스트에 저장.

    // parallelStream
    List<String> lowCaloriesDishName2 =
        menu.parallelStream()
          .filter( d -> d.getCalories() <= 400)
          .sorted(new Comparator<Dish2>() {
            @Override
            public int compare(Dish2 o1, Dish2 o2) {
              return o1.getCalories().compareTo(o2.getCalories());
            }
          })
          .map( d -> d.getName())
          .collect(Collectors.toList());


    

  }

}


class Dish2 {
  private int calories;
  private String name;

  public Integer getCalories() {
    return calories;
  }

  public String getName() {
    return name;
  }
}
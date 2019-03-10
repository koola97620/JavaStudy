package Chapter4;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author choijaeyong on 05/02/2019.
 * @project java8InAction
 * @description
 */
public class Exam1 {
  public static void main(String[] args) {

    List<String> threeHighCaloricDishNames =
        Dish.menu.stream() // 메뉴에서 스트림을 얻는다.
          .filter(d -> d.getCalories() > 300) // 고칼로리 요리를 필터링한다.
          .map(Dish::getName) // 요리명을 추출
          .limit(3) // 3개만 선택
          .collect(Collectors.toList()); // 결과를 다른 리스트로 저장.

    System.out.println(threeHighCaloricDishNames); // pork, beef, chicken
    System.out.println(Dish.menu);

    List<String> names = Dish.menu.stream()
        .filter(d -> {
          System.out.println("filtering : " + d.getName());
          return d.getCalories() > 300;
        })
        .map( d -> {
          System.out.println("mapping : " + d.getName());
          return d.getName();
        })
        .limit(3)
        .collect(Collectors.toList());

    System.out.println(names);




  }

}

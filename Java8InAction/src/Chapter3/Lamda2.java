package Chapter3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author choijaeyong on 04/02/2019.
 * @project java8InAction
 * @description
 */
public class Lamda2 {

  public static void main(String[] args) {

    //List<Apple> inventory = new ArrayList<>();
    List<Apple> inventory = Arrays
        .asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));

    // 익명 클래스 사용
    // compareTo 는 Comparable 을 구현하고 있는 Integer 의 메소드.
    inventory.sort(new Comparator<Apple>() {
      public int compare(Apple o1, Apple o2) {
        return o1.getWeight().compareTo(o2.getWeight());
      }
    });

    // 람다 사용
    inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));

    // 자바 컴파일러는 람다 표현식이 사용된 컨텍스트를 활용해서 람다의 파라미터 형식을 추론할 수 있다.
    inventory.sort((a1,a2) -> a1.getWeight().compareTo(a2.getWeight()));

    // Comparator는 Comparable 키를 추출해서 Comparator 객체로 만드는 Function 함수를 인수로 받는
    // 정적 메서드 comparing 을 포함한다.
    Comparator<Apple> c = Comparator.comparing((Apple a) -> a.getWeight());
    Comparator<Apple> c2 = Comparator.comparing((a) -> a.getWeight());

    // 메서드 레퍼런스 사용.
    Comparator<Apple> c3 = Comparator.comparing(Apple::getWeight);
    inventory.sort(Comparator.comparing(Apple::getWeight));

    // 함수형 인터페이스 사용
    Function<Apple,Integer> func = (Apple a) -> a.getWeight();
    inventory.sort(Comparator.comparing(func));

    // 내림차순 정렬
    inventory.sort(Comparator.comparing(Apple::getWeight).reversed());

    // 내림차순 정렬 + 색 별로 정렬
    inventory.sort(Comparator.comparing(Apple::getWeight)
      .thenComparing((Apple a) -> a.getColor()));


    // 색이 red 인지 아닌지 판별.
    Predicate<Apple> redApple = new PredicateRed();

    // 기존 프레디케이트 객체 redApple 의 결과를 반전시킨 결과를 만든다.
    Predicate<Apple> notRedApple = redApple.negate();

    Predicate<Apple> heavyApple = ((Apple a) -> a.getWeight() > 150);

    // 두 프레디케이트를 연결하기.
    Predicate<Apple> redAndHeavy = redApple.and(heavyApple);





    // C는 정적 메서드 f를 포함하는 클래스.
    // 메서드 레퍼런스를 사용. f(x) = x + 10 인 직선.
    // 좌표평면 상에서 3~7 사이의 넓이를 구하는 메소드다. (적분)
    // 메소드를 파라미터로?
    C.integrate(C::f,3,7);




  }


}

class Apple{
  private Integer weight;
  private String color;


  public Apple(Integer weight, String color) {
    this.weight = weight;
    this.color = color;
  }

  public Integer getWeight() {
    return weight;
  }

  public String getColor() {
    return color;
  }

}

class PredicateRed implements Predicate<Apple> {

  @Override
  public boolean test(Apple apple) {
    return "red".equals(apple.getColor());
  }
}

class C {
  public static double f(double x) {
    return x + 10;
  }

  // DoubleFunction<Double> 도 가능.
  public static double integrate( Function<Double,Double> f ,double a, double b) {
    return (f.apply(a) + f.apply(b)) * (b-a) / 2.0;
  }
}
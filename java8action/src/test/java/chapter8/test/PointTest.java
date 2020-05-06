package chapter8.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/05/06.
 * @project java8action
 * @description
 */
public class PointTest {

  @Test
  public void test() {
    Point p1 = new Point(5, 5);
    Point p2 = p1.moveRightBy(10);

    assertThat(p2.getX()).isEqualTo(15);
    assertThat(p2.getY()).isEqualTo(5);
  }

  @Test
  public void test2() {
    Point p1 = new Point(10,15);
    Point p2 = new Point(10, 20);
    int result = Point.compareByXAndThenY.compare(p1, p2);
    assertThat(result).isEqualTo(-1);
  }

}

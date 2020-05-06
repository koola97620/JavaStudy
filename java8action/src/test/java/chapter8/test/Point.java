package chapter8.test;

/**
 * @author choijaeyong on 2020/05/06.
 * @project java8action
 * @description
 */
public class Point {

  private final int x;
  private final int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public Point moveRightBy(int x) {
    return new Point(this.x + x , this.y);
  }
}

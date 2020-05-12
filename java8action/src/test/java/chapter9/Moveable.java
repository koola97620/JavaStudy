package chapter9;

/**
 * @author choijaeyong on 2020/05/12.
 * @project java8action
 * @description
 */
public interface Moveable {
  int getX();
  int getY();
  void setX(int x);
  void setY(int y);

  default void moveHorizontally(int distance) {
    setX(getX() + distance);
  }

  default void moveVertically(int distance) {
    setY(getY() + distance);
  }

}

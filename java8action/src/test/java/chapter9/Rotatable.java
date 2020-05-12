package chapter9;

/**
 * @author choijaeyong on 2020/05/12.
 * @project java8action
 * @description
 */
public interface Rotatable {
  void setRotationAngle(int angleInDegrees);
  int getRotationAngle();
  default void rotateBy(int angleInDegrees) {
    setRotationAngle((getRotationAngle() +angleInDegrees ) % 360);
  }

}

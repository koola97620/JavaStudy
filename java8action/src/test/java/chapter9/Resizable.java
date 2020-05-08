package chapter9;

/**
 * @author choijaeyong on 2020/05/08.
 * @project java8action
 * @description
 */
public interface Resizable extends Drawable {
  int getWidth();
  int getHeight();
  void setWidth();
  void setHeight();
  void setAbsoluteSize(int width, int height);
}

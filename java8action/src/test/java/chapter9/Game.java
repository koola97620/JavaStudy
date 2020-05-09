package chapter9;

import java.util.Arrays;
import java.util.List;

/**
 * @author choijaeyong on 2020/05/11.
 * @project java8action
 * @description
 */
public class Game {
  public static void main(String[] args) {
    List<Resizable> resizableShapes = Arrays.asList(new Square(), new Rectangle(), new Ellipse());
    Utils.paint(resizableShapes);
  }

}

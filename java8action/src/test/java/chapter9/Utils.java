package chapter9;

import java.util.List;

/**
 * @author choijaeyong on 2020/05/11.
 * @project java8action
 * @description
 */
public class Utils {
  public static void paint(List<Resizable>l) {
    l.forEach(r -> {
      r.setAbsoluteSize(42,42);
      r.draw();
    });
  }

}

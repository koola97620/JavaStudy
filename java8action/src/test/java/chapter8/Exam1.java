package chapter8;

import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/05/01.
 * @project java8action
 * @description
 */
public class Exam1 {

  public static void doSomething(Runnable r) {
    r.run();
  }

  public static void doSomething(Task a) {
    a.execute();
  }

  @Test
  public void test() {
    doSomething(new Task() {
      @Override
      public void execute() {
        System.out.println("Danger danger!!");
      }
    });

    // 모호한 표현
    //doSomething( () -> System.out.println("danger"));
    doSomething( (Task)() -> System.out.println("danger"));

  }

}

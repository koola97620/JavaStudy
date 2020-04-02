package chapter2.item20;

/**
 * @author choijaeyong on 2020/04/03.
 * @project effectivejava
 * @description
 */
public class InterMain {
  public static void main(String[] args) {
    InterExam interExam = new InterExamImpl();
    System.out.println(interExam.add(100));
    System.out.println(interExam.minus(1000));
  }

}

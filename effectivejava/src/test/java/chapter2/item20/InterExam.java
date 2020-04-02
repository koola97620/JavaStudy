package chapter2.item20;

/**
 * @author choijaeyong on 2020/04/03.
 * @project effectivejava
 * @description
 */
public interface InterExam {
  public int value = 0;
//  private int values = 100;
//  default int aa = 10;

  public static int VAL = 10;
//  private static final int VV = 100;


  int add(int k);

  default int minus(int k) {
    return k-100;
  }

}

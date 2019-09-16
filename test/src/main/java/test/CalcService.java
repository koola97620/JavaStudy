package test;

/**
 * @author choijaeyong on 14/09/2019.
 * @project test
 * @description
 */
public class CalcService {
  private int mainInt;

  public CalcService(int a) {
    mainInt = a;
  }

  public void calculate(int a) {
    System.out.println("CalcService");
    int b = 20;
    try {
      int sum = mainInt + b;
      Calculator calculator = new Calculator(sum);
      int result = calculator.calculate();
    } catch (InvalidNumber e) {
      System.out.println("calculate invalid error : " + e);
    }

    System.out.println("calcService end");

  }
}

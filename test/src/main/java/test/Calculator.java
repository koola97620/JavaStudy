package test;

/**
 * @author choijaeyong on 14/09/2019.
 * @project test
 * @description
 */
public class Calculator {
  private int calcInt;
  public Calculator(int b) {
    calcInt = b;
  }

  public int calculate() {

    try {
      for (int i = 0 ; i < 50 ; i++) {
        if (calcInt != 100 || i == 10) {
//          throw new InvalidNumber();
//          throw new CalculateError();
          VerifyCalc verifyCalc = new VerifyCalc();
          verifyCalc.verify();
        }
      }
    } catch(CalculateError e) {
      System.out.println("calculate() error");
    }

    System.out.println("calculate() throw 후");


    return 999;
  }
}

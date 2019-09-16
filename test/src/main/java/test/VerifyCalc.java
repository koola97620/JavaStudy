package test;

/**
 * @author choijaeyong on 17/09/2019.
 * @project test
 * @description
 */
public class VerifyCalc {
  public void verify() {
    System.out.println("verifyerror");
    throw new CalculateError();
  }

}

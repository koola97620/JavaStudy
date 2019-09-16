package test;

/**
 * @author choijaeyong on 14/09/2019.
 * @project test
 * @description
 */
public class Main {

  public static void main(String[] args) {
    System.out.println("main");
    int a = 10;
    try {
      for(int i =0 ; i < 10 ; i++) {
        CalcService calcService = new CalcService(a);
        calcService.calculate(a);
      }
    } catch(CalculateError e) {
      System.out.println("calculate() error");
    } catch (Exception e) {
      System.out.println("main error : " + e);
    }

    System.out.println("main end");



  }

}

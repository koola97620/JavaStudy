package Chapter12;

/**
 * @author choijaeyong on 22/08/2019.
 * @project objects
 * @description
 */
public class Delegation1 {

  public void sendD1() {
    Delegation2 d2 = new Delegation2();
    d2.sendD2();
  }
}

package Chapter12;

/**
 * @author choijaeyong on 22/08/2019.
 * @project objects
 * @description
 */
public class Delegation2 {

  public void sendD2() {
    Delegation3 d3 = new Delegation3();
    System.out.println(this);
    d3.sendD3(this);
  }
}

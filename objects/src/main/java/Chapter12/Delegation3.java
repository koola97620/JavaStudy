package Chapter12;

/**
 * @author choijaeyong on 22/08/2019.
 * @project objects
 * @description
 */
public class Delegation3 {

  public void sendD3(Delegation2 delegation2) {
    Delegation4 d4 = new Delegation4();
    d4.print();
  }
}

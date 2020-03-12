/**
 * @author choijaeyong on 04/10/2019.
 * @project umlprac
 * @description
 */
public class ButtonDialerAdapter implements ButtonListener {

  private Dialer dialer;
  private int digit=100;

  public ButtonDialerAdapter(Dialer dialer) {
    this.dialer = dialer;
  }

  public void buttonPressed() {
    dialer.digit(digit);
  }

}

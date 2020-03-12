/**
 * @author choijaeyong on 04/10/2019.
 * @project umlprac
 * @description
 */
public class Main {
  public static void main(String[] args) {

    Dialer dialer = new Dialer(new Screen());
    Button button = new Button(new ButtonDialerAdapter(dialer));
    button.buttonListener.buttonPressed();

    dialer.screen.display();





  }

}

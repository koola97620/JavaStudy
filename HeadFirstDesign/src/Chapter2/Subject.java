package Chapter2;

/**
 * @author choijaeyong on 10/03/2019.
 * @project HeadFirstDesign
 * @description
 */
public interface Subject {
  void registerObserver(Observer o);
  void removeObserver(Observer o);
  void notifyObserver();
}

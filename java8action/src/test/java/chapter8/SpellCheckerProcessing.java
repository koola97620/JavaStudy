package chapter8;

/**
 * @author choijaeyong on 2020/05/04.
 * @project java8action
 * @description
 */
public class SpellCheckerProcessing extends ProcessingObject<String> {

  @Override
  protected String handleWork(String input) {
    return input.replaceAll("labda","lambda");
  }
}

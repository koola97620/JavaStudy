package chapter8;

import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/05/05.
 * @project java8action
 * @description
 */
public class ProcessingObjectTest {

  @Test
  public void test() {
    HeaderTextProcessing headerTextProcessing = new HeaderTextProcessing();
    SpellCheckerProcessing spellCheckerProcessing = new SpellCheckerProcessing();
    headerTextProcessing.setSuccessor(spellCheckerProcessing);

    String result = headerTextProcessing.handle("Aren't labdas really sexy?");
    System.out.println(result);

  }

}

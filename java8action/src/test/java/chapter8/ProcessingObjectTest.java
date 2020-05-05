package chapter8;

import java.util.function.Function;
import java.util.function.UnaryOperator;
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

    UnaryOperator<String> p1 = (String text) -> "From Raoul, Mario and Alan : " + text;
    UnaryOperator<String> p2 = (String text) -> text.replaceAll("labda" , "lambda");
    Function<String, String> pipeline = p1.andThen(p2);
    String result2 = pipeline.apply("Aren't labdas really sexy?");

  }

}

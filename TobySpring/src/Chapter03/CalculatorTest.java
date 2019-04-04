package Chapter03;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

/**
 * @author choijaeyong on 04/04/2019.
 * @project TobySpring
 * @description
 */
public class CalculatorTest {
  Calculator calculator;
  String numFilepath;

  @Before
  public void setUp() {
    this.calculator = new Calculator();
    this.numFilepath = getClass().getResource("numbers.txt").getPath();
  }

  @Test
  public void sumOfNumbers() throws IOException {
    assertThat(calculator.calcSum(this.numFilepath),is(10));
  }

  @Test
  public void multiplyOfNumbers() throws IOException {
    assertThat(calculator.calcMultiply(this.numFilepath), is(24));
  }

}
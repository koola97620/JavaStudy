package chapter14;

import java.util.function.DoubleUnaryOperator;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/05/31.
 * @project java8action
 * @description
 */
public class Exam {

  static double converter(double x, double f, double b) {
    return x * f + b;
  }

  static DoubleUnaryOperator curriedConverter(double f, double b) {
    return (double x) -> x * f + b;
  }

  @Test
  public void exam() {
    DoubleUnaryOperator converCtoF = curriedConverter(9.0 / 5, 32);
    DoubleUnaryOperator convertUSDtoGBP = curriedConverter(0.6, 0);
    DoubleUnaryOperator convertKmtoMi = curriedConverter(0.6214, 0);

    double gbp = convertUSDtoGBP.applyAsDouble(1000);


  }

}

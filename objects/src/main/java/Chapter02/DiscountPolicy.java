package Chapter02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author choijaeyong on 30/06/2019.
 * @project objects
 * @description
 */
public interface DiscountPolicy {
  Money calculateDiscountAmount(Screening screening);
}

package Chapter02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author choijaeyong on 30/06/2019.
 * @project objects
 * @description
 */
public abstract class DefaultDiscountPolicy implements DiscountPolicy{
  private List<DiscountCondition> conditions = new ArrayList<>();

  public DefaultDiscountPolicy(DiscountCondition ... discountConditions) {
    this.conditions = Arrays.asList(discountConditions);
  }

  @Override
  public Money calculateDiscountAmount(Screening screening) {
    for(DiscountCondition discountCondition : conditions) {
      if(discountCondition.isSatisfiedBy(screening)) {
        return getDiscountAmount(screening);
      }
    }
    return Money.ZERO;
  }

  protected abstract Money getDiscountAmount(Screening screening);
}

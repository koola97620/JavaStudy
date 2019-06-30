package Chapter02;

/**
 * @author choijaeyong on 30/06/2019.
 * @project objects
 * @description
 */
public interface DiscountCondition {

  boolean isSatisfiedBy(Screening screening);
}

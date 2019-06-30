package Chapter02;

/**
 * @author choijaeyong on 30/06/2019.
 * @project objects
 * @description
 */
public class SequenceCondition implements DiscountCondition {
  private int sequence;

  public SequenceCondition(int sequence) {
    this.sequence = sequence;
  }

  @Override
  public boolean isSatisfiedBy(Screening screening) {
    return screening.isSequence(sequence);
  }
}

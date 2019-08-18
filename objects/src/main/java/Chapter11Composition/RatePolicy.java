package Chapter11Composition;

/**
 * @author choijaeyong on 18/08/2019.
 * @project objects
 * @description
 */
public interface RatePolicy {
  Money calculateFee(Phone phone);
}

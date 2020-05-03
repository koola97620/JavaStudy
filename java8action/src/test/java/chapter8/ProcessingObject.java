package chapter8;

/**
 * @author choijaeyong on 2020/05/03.
 * @project java8action
 * @description
 */
public abstract class ProcessingObject<T> {

  protected ProcessingObject<T> successor;

  public void setSuccessor(ProcessingObject<T> successor) {
    this.successor = successor;
  }

  public T handle(T input) {
    T r = handleWork(input);
    if (successor != null) {
      return successor.handle(r);
    }
    return r;
  }

  abstract protected T handleWork(T input);

}

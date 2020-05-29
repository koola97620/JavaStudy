package chapter13;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/05/31.
 * @project java8action
 * @description
 */
public class Exam {

  private List<Transaction> transactions;

  @Test
  public void test() {
    Transaction mostExpensive = transactions.get(0);
    if (mostExpensive == null)
      throw new IllegalArgumentException("Empty list of transactions");

    for(Transaction t : transactions.subList(1, transactions.size())) {
      if (t.getValue() > mostExpensive.getValue() ) {
        mostExpensive = t;
      }
     }

    Optional<Transaction> max = transactions.stream()
        .max(Comparator.comparing(Transaction::getValue));

  }

}

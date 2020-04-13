package chapter5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/04/13.
 * @project java8action
 * @description
 */
public class TransactionTest {

  private List<Transaction> transactions;

  @BeforeEach
  public void setUp() {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Cambridge");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    transactions = Arrays.asList(
        new Transaction(brian, 2011, 300),
        new Transaction(raoul, 2012, 1000),
        new Transaction(raoul, 2011, 400),
        new Transaction(mario, 2012, 710),
        new Transaction(mario, 2012, 700),
        new Transaction(alan, 2012, 950)
    );
  }

  @Test
  public void test() {
    // 2011 년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정렬
    transactions.stream()
        .filter(t -> t.getYear() == 2011)
        .sorted(Comparator.comparing(Transaction::getValue))
        .collect(Collectors.toList());

    // 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
    transactions.stream()
        .map(t -> t.getTrader().getCity())
        .distinct()
        .collect(Collectors.toList());

    transactions.stream()
        .map(t -> t.getTrader().getCity())
        .collect(Collectors.toSet());


  }



}

package chapter13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;
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

  // 13.2.3
  @Test
  public void test2() {
    List<Integer> integers = Arrays.asList(1, 4, 9);
  }
  public static List<List<Integer>> subsets(List<Integer> list) {
    if (list.isEmpty()) {
      List<List<Integer>> ans = new ArrayList<>();
      ans.add(Collections.emptyList());
      return ans;
    }
    Integer first = list.get(0);
    List<Integer> rest = list.subList(1, list.size());

    List<List<Integer>> subans = subsets(rest);
    List<List<Integer>> subans2 = insertAll(first, subans);
    return concat(subans,subans2);


  }

  private static List<List<Integer>> concat(List<List<Integer>> a,
      List<List<Integer>> b) {
    List<List<Integer>> r = new ArrayList<>(a);
    r.addAll(b);
    return r;
  }

  private static List<List<Integer>> insertAll(Integer first, List<List<Integer>> lists) {

    List<List<Integer>> result = new ArrayList<>();
    for (List<Integer> list : lists) {
      List<Integer> copyList = new ArrayList<>();
      copyList.add(first);
      copyList.addAll(list);
      result.add(copyList);
    }
    return result;
  }

  // 13.3
  static long factorialStreams(long n) {
    return LongStream.rangeClosed(1,n)
        .reduce(1, (long a, long b) -> a*b);
  }

  // 13.3
  static long factorialTailRecursive(long n) {
    return factorialHelper(1,n);
  }

  private static long factorialHelper(long acc, long n) {
    return n == 1 ? acc : factorialHelper(acc * n , n-1);
  }

}

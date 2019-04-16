package codejam2019.Qualification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author choijaeyong on 06/04/2019.
 * @project codejam
 * @description
 */
public class Solution2 {
  public static void main(String[] args) {

    int[] primes = new int[26];

    List<Integer> list = primes(10000);
    System.out.println(list);
    System.out.println(43*71);

    int A = Character.getNumericValue('A');
    int Z = Character.getNumericValue('Z');

    System.out.println(A);
    System.out.println(Z);




    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

    // testcases
    for(int i=1 ; i <= t ; i++) {

      int mazeSize = in.nextInt();
      String lydiaPath = in.next();






    }




  }


  public static List<Integer> primes(int n) {
    List<Integer> list = new ArrayList<>();
    for(int i=3 ; i <= n ; i++) {

      boolean isPrime = true;

      for(int j=2 ; j*j <= i ; j++ ) {
        if(i % j == 0) {
          // 소수가 아니다.
          isPrime = false;
          break;
        }
      }

      if(isPrime) {
        list.add(i);
      }

    }

    return list;
  }



}

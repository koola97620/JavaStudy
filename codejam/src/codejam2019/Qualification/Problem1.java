package codejam2019.Qualification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author choijaeyong on 06/04/2019.
 * @project codejam
 * @description
 */
public class Problem1 {
  public static void main(String[] args) {

    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

    String number1String;
    String number2String;

    for (int i = 1; i <= t; i++) {
      int n = in.nextInt();

      // n = 4,940,4444

      // number1 + number2 = n  . number1,2 are not contain 4

      int left =0;
      int right = n;
      int mid=0;

      while(left <= right) {
        mid = (left + right)/2;
        number1String = String.valueOf(mid);
        number2String = String.valueOf(n-mid);

        if(number1String.contains("4") || number2String.contains("4")) {
          System.out.println("mid : "+mid + "    n-mid : " + (n-mid));
          //right = mid-1;
          left = mid+1;
          continue;
        } else {
          System.out.println("Case #" + i + ": " + number1String + " " + number2String);
          break;
        }
      }


//      for(int j=1; j < n ; j++) {
//        number1 = j;
//        number2 = n - j;
//
//        number1String = String.valueOf(number1);
//        number2String = String.valueOf(number2);
//
//        if(number1String.contains("4") || number2String.contains("4")) {
//          continue;
//        } else {
//          System.out.println("Case #" + i + ": " + number1 + " " + number2);
//          break;
//        }
//
//      }

    }
  }

}

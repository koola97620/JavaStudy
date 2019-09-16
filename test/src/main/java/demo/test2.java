package demo;

import java.util.Scanner;

/**
 * @author choijaeyong on 07/09/2019.
 * @project test
 * @description
 */
public class test2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();

    draw(a,b);
  }

  public static void draw(int x, int y) {
    for(int i =0 ; i < y ; i ++) {
      for (int j=0 ; j < x ; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

}

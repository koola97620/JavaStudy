package Exer_Choi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sumba {
    public static final int MAX = 1000000;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] c = new boolean[MAX];
        int[] d = new int[MAX];
        c[n] = true;
        d[n] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.remove();
            if (now-1 >= 0) {
                if (c[now-1] == false) {
                    q.add(now-1);
                    c[now-1] = true;
                    d[now-1] = d[now] + 1;
                }
            }
            if (now+1 < MAX) {
                if (c[now+1] == false) {
                    q.add(now+1);
                    c[now+1] = true;
                    d[now+1] = d[now] + 1;
                }
            }
            if (now*2 < MAX) {
                if (c[now*2] == false) {
                    q.add(now*2);
                    c[now*2] = true;
                    d[now*2] = d[now] + 1;
                }
            }
        }
        System.out.println(d[m]);
    }
}
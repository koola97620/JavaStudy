package Exer_Choi;
import java.util.*;
class Pair2 {
    int first, second;
    Pair2(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class test {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int n = a.length();
        int m = b.length();
        boolean[] erased = new boolean[n];
        if (m == 1) {
            for (int i=0; i<n; i++) {
                if (a.charAt(i) == b.charAt(0)) {
                    erased[i] = true;
                }
            }
        } else {
            Stack<Pair2> s = new Stack<Pair2>();
            for (int i=0; i<n; i++) {
                if (a.charAt(i) == b.charAt(0)) {
                    s.push(new Pair2(i, 0));
                } else {
                    if (!s.empty()) {
                        Pair2 p = s.peek();
                        if (a.charAt(i) == b.charAt(p.second+1)) {
                            s.push(new Pair2(i, p.second+1));
                            if (p.second+1 == m-1) {
                                for (int k=0; k<m; k++) {
                                    Pair2 top = s.pop();
                                    erased[top.first] = true;
                                }
                            }
                        } else {
                            while (!s.empty()) {
                                s.pop();
                            }
                        }
                    }
                }
            }
        }
        boolean printed = false;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            if (erased[i]) {
                continue;
            }
            sb.append(a.charAt(i));
            printed = true;
        }
        if (printed) {
            System.out.println(sb);
        } else {
            System.out.println("FRULA");
        }
    }
}
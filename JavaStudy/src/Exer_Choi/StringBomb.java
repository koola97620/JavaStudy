package Exer_Choi;

import java.util.Scanner;
import java.util.Stack;

class Pair {
	int first;
	int second;
	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}


public class StringBomb {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String bomb = sc.nextLine();
		
		int string_count = a.length();
		int bomb_count = bomb.length();
		
		boolean[] erased = new boolean[string_count];
		
		// 만약 폭탄문자가 1개면
		if(bomb_count == 1) {
			for(int i=0; i < string_count ; i++) {
				if(a.charAt(i) == bomb.charAt(0)) {
					erased[i] = true;
				}
			}
		} else {  // 폭탄문자가 여러글자이면!
			Stack<Pair> st = new Stack<Pair>();
			for(int i=0 ; i < string_count ; i++) {
				if(a.charAt(i) == bomb.charAt(0)) {
					st.push(new Pair(i,0));
				} else {
					if(!st.isEmpty()) {
						Pair p = st.peek();
						System.out.println("first : " + p.first + "  second : " + p.second);
						if(a.charAt(i) == bomb.charAt(p.second + 1)) {
							st.push(new Pair(i,p.second+1));
							if(p.second+1 == bomb_count -1) {
								for(int k=0 ; k < bomb_count ; k++) {
									Pair top = st.pop();
									erased[top.first] = true;
								}
							}
						} else {
							while(!st.isEmpty()) {
								st.pop();
							}
						}
					}
				}
			}
		}
		
		boolean printed = false;
		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i < string_count ; i++) {
			if(erased[i]) {
				continue;
			}
			sb.append(a.charAt(i));
			printed = true;
		}
		
		if(printed == true) {
			System.out.println(sb);
		}else {
			System.out.println("FAIL");
		}
		
		
		

	}

}

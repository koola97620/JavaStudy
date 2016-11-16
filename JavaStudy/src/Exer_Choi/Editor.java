package Exer_Choi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

// L : 커서를 왼쪽으로 한칸 옮김
// D : 커서를 오른쪽으로 한칸 옮김
// B : 커서 왼쪽에 있는 문자를 삭제함
// P $ : $라는 문자를 커서 오른쪽에 추가함. 커서는 $에 위치함.


public class Editor {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		Stack<Character> left = new Stack<Character>();
		Stack<Character> right = new Stack<Character>();
		for(int i=0 ; i < s.length() ; i++) {
			left.push(s.charAt(i));
		}
		
		// 최초 커서는 맨 오른쪽에 있다.
		int m = Integer.parseInt(br.readLine());
		while(m-- > 0) {
			String line[] = br.readLine().split(" ");
			char what = line[0].charAt(0);
			if(what == 'L' ) {
				if(!left.empty()) {
					right.push(left.pop());
				}
			}else if(what == 'D') {
				if(!right.empty()) {
					left.push(right.pop());
				}
			}else if(what == 'P') {
				char c = line[1].charAt(0);
				left.push(c);
			}else if(what == 'B') {
				if(!left.empty()) {
					left.pop();
				}
			}
		}
		
		while(!left.empty()) {
			right.push(left.pop());
		}
		StringBuilder sb = new StringBuilder();
		while(!right.empty()) {
			sb.append(right.pop());
		}
		System.out.println(sb);
		

	}

}

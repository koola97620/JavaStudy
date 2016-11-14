package Exer_Bracket;

import java.util.Stack;

//괄호의 깊이가 일치해야한다.

public class UseStackStrategy implements BracketInterface{
	public void BracVaild(String str) {
		Stack<Character> st = new Stack<Character>();
		char ch[] = str.toCharArray();
		
		for(int i=0 ; i < ch.length ; i++) {
			if(ch[i]=='(' || ch[i]=='{' || ch[i]=='[') {
				st.push(ch[i]);
			}else {
				if(ch[i]==')' && st.peek()=='(') {
					st.pop();
				}else if(ch[i] =='}' && st.peek()=='{') {
					st.pop();
				}else if(ch[i] ==']' && st.peek()=='[') {
					st.pop();
				}
			}
		}
		if(st.isEmpty()) {
			System.out.println("정상괄호");
		}else {
			System.out.println("비정상괄호");
		}
		
		
	}
}

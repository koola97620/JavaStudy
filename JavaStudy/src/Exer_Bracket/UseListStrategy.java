package Exer_Bracket;

import java.util.ArrayList;
import java.util.List;


// 깊이가 일치하지 않아도 된다.
public class UseListStrategy implements BracketInterface{
	
	
	public void BracVaild(String str) {	
		List<Character> li = new ArrayList<Character>();
		char ch[] = str.toCharArray();
		int cnt=0;
		
		for(int i=0 ; i < ch.length ; i++) {
			if(ch[i]=='(' || ch[i]=='{' || ch[i]=='[') {
				li.add(ch[i]); 
				cnt++;
			} else {
				if(ch[i]==')' && li.contains('(') && cnt >0) {
					cnt--;
				}else if(ch[i]=='}' && li.contains('{') && cnt >0) {
					cnt--;
				}else if(ch[i]==']' && li.contains('[') && cnt >0) {
					cnt--;
				}
			}
		}
		
		if(cnt == 0) {
			System.out.println("정상괄호");
		}else {
			System.out.println("비정상괄호");
		}
		
	}
}

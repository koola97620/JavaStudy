package Exer_NameJum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NameJum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String name1 = br.readLine();
		String name2 = br.readLine();

		StringBuilder sb = new StringBuilder();
		
		// 이름 순서 정렬하기.
		int i=0;
		if(name1.length() >= name2.length()) {
			for(i=0 ; i < name2.length() ; i++) {
				sb.append(name1.charAt(i));
				sb.append(name2.charAt(i));
			}
			
			for(int k=i ; k < name1.length() ; k++) {
				sb.append(name1.charAt(k));
			}
		}else {
			
			for(i=0 ; i < name1.length() ; i++) {
				sb.append(name2.charAt(i));
				sb.append(name1.charAt(i));
			}
			
			for(int k=i ; k < name2.length() ; k++) {
				sb.append(name2.charAt(k));
			}
			
		}
		System.out.println(sb);
		
		// 위에. 이름 정렬 끝!!!!!! 
		// 획수 구현은 어려우니. 예시로 입력해놓자.
		
		int lineNum[] = {2,5,7,4,5,6};
		int result[] = lineNumCount(lineNum);
		
		System.out.println(result[0] + "" + result[1]);
		
		
	
		
	}
	
	public static int[] lineNumCount(int[] lineNum) {
		int result[] = new int[lineNum.length-1];
		
		
		for(int i=0 ; i < lineNum.length -1 ; i++) {
			result[i] = (lineNum[i] + lineNum[i+1])%10;
		}
		
		if(result.length == 2) {
			return result;
		}
		
		
		return lineNumCount(result);
	}

}

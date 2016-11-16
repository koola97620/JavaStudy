package Exer_Choi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class JoseQueue {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		sb.append("<");
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=1 ; i <= n ; i++) {
			queue.offer(i);
		}
		
		System.out.println(queue);
		for(int i=0 ; i < n-1 ; i++) {
			for(int k=0 ; k < m-1 ; k++) {
				queue.offer(queue.poll());
			}
			sb.append(queue.poll() + " , ");
		}
		sb.append(queue.poll() + " >");  // 마지막에 poll하는 숫자가 마지막으로 남는 숫자.
		System.out.println(sb); 
		System.out.println(queue.isEmpty());
		

	}

}

package Exer_NameJum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class pre4 {	
	public static List<String> al = new ArrayList<String>();
	
	//배열과 인덱스를 이용한 Swap메소드 ( 자바에는 포인터가 없기 떄문!)
		public static void Swap(int[] array, int index1, int index2) { // index1 = i , index2 = depth 
			   int iTemp;
			   iTemp = array[index1];
			   array[index1] = array[index2];
			   array[index2] = iTemp;
			}
		
		//배열을 출력하는 함수
		public static void print(int[] arr, int k) {
			StringBuilder sbb = new StringBuilder();
			for (int i = 0; i < k; i++) {
				if(i == k - 1) { 
					 System.out.println(arr[i] + "   i " + i + "  k = " + k); //한 줄에서 마지막단계
					 sbb.append(arr[i]);
				}else {
					System.out.print(arr[i] + ",");
					sbb.append(arr[i]);
				}
			}
			al.add(sbb.toString());
			sbb = null;
		}
		
		public static void perm(int[] arr, int depth, int n, int k){
			/*
			 * arr: 계속해서 데이터를 들고다니며 교환되고 있는 배열
			 * depth: 현재 트리구조에서 어떤 깊이에서 교환작업을 하고 있는지에 관련
			 * n: 총 배열 안에 들어있는 숫자(고정값)
			 * k: 몇 개를 뽑아내서 순열을 만들것인지(고정값)
			 */
			
			if(depth == k){ //한 번 depth가 k로 도달하면 사이클이 돌았음
				print(arr, k);
				return;
			}
			
			for(int i = depth; i < n; i++){
				Swap(arr, i, depth);
				perm(arr, depth + 1, n, k);
				Swap(arr, i, depth);
			}
		}
	
	
	
	
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String nums[] = input.split(" ");
		
		//int[] arr = {1,2,3};
		int[] array = new int[nums.length];
		
		for(int i=0 ; i < nums.length ; i++) {
			array[i] = Integer.parseInt(nums[i]);
		}
		
		
		perm(array,0,array.length,array.length);
		
		List<Integer> result = new ArrayList<Integer>();
		
		for(String k : al) {
			System.out.print(k + " ");
		}
		
		
		for(String k : al) {
			result.add(Integer.parseInt(k));
		}
		
		int max=0;
		int min=result.get(0); //두 자리만 입력 가능하다. 조건에. 
		
		for(int i=0 ; i < result.size() ; i++) {
			if(result.get(i) > max) {
				max = result.get(i);
			}
			
			if(result.get(i) < min) {
				min = result.get(i);
			}
		}
		
		System.out.println("\n" + "Max : " + max + "  Min : " + min + " Sum : " + (max+min));
		
		
		
		
		
		
		
		
			
	}
	
	

}

package Exer_NameJum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Johab {
	static List<String> al = new ArrayList<String>();
	
	public static void swap(int arr[] , int index1 , int index2) {
		int temp;
		temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	public static void print(int arr[], int k) {
		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i < k ; i++) {
			if(i == k-1) {
				System.out.println(arr[i]);
				sb.append(arr[i]);
			}else {
				System.out.print(arr[i] + ", ");
				sb.append(arr[i]);
			}
			
		}
		al.add(sb.toString());
		sb=null;
		
	}
	
	public static void perm(int arr[], int depth, int n, int k) {
		if(depth == k) {
			print(arr,k);
			return;
		}
		for(int i=depth ; i < n ; i++) {
			swap(arr,i,depth); 
			perm(arr,depth+1 , n ,k);
			swap(arr,depth,i); // 원래 숫자로 되돌려놓기.
		}
		
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String nums[] = input.split(" ");
		
		int array[] = new int[nums.length];
		
		for(int i=0 ; i < nums.length ; i++) {
			array[i] = Integer.parseInt(nums[i].trim());
		}
		
		perm(array, 0 , array.length , array.length);
		
		System.out.println(al);
		int result[] = new int[al.size()];
		for(int i=0; i < al.size() ; i++) {
			result[i] = Integer.parseInt(al.get(i));
		}
		
		int max=0;
		int min=result[0];
		for(int i=0 ; i < result.length ; i++) {
			if(result[i] > max) {
				max = result[i];
			}
			
			if(result[i] < min) {
				min = result[i];
			}
		}
		
		System.out.println("Max : " + max + " Min : " + min + " Sum : " + (max+min) );
		
		
	}

}

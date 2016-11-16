package interview_algo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Fibonacci {
	public static List<Integer> fibona(int n) {
		if(n < 0) 
			throw new IllegalArgumentException("n must not be less than zero");
		
		if(n==0)
			return new ArrayList<>();
		
		if(n==1)
			return Arrays.asList(0);
		
		final List<Integer> seq = new ArrayList<Integer>();
		seq.add(0);
		n=n-1;
		seq.add(1);
		n=n-1;
		
		while(n>0) {
			int a = seq.get(seq.size()-1);
			int b = seq.get(seq.size()-2);
			seq.add(a+b);
			n=n-1;
		}
		
		return seq;
	}
	
	// 굉장히 비효율적이다.
	// 같은 연산을 수없이 반복한다.
	public static int fiboN(int n) {
		if(n<0) {
			throw new IllegalArgumentException("n must not be less than zero");
		}
		if(n==1) return 1;
		if(n==0) return 0;
		
		return (fiboN(n-1) + fiboN(n-2));
	}
	
	// 아래는 fiboN 을 개선한 코드이다.
	
	private static Map<Integer, Integer> fibCache = new HashMap<>();
	public static int cacheFiboN(int n) {
		if(n<0)
			throw new IllegalArgumentException("n error");
		
		fibCache.put(0, 0);
		fibCache.put(1, 1);
		
		return recursiveCache(n);
	}
	private static int recursiveCache(int n) {
		if(fibCache.containsKey(n)) {
			return fibCache.get(n);
		}
		int value = recursiveCache(n-1) + recursiveCache(n-2);
		fibCache.put(n, value);
		
		return value;
	}
	
	public static BigInteger fiboBigInteger(int n) {
		BigInteger[] d= new BigInteger[Math.max(n+1, 2)];
		d[0] =BigInteger.ZERO;
		d[1] = BigInteger.ONE;
		for(int i=2 ; i <= n ; i++) { //어차피 n+1개 만들어서. <= 로 해도된다.
			d[i] = d[i-1].add(d[i-2]);
		}
		
		return d[n];
		
	}
	

	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(fibona(20));
		long end = System.nanoTime();
		System.out.println("실행시간 : " + (end-start));
		
		start = System.nanoTime();
		System.out.println(fiboN(20));
		end = System.nanoTime();
		System.out.println("실행시간 : " + (end-start));
		
		
		start = System.nanoTime();
		System.out.println(cacheFiboN(20));
		end = System.nanoTime();
		System.out.println("실행시간 : " + (end-start));
		
		// BigInteger 개오래 걸리는데?????????
		
		start = System.nanoTime();
		System.out.println(fiboBigInteger(20));
		end = System.nanoTime();
		System.out.println("실행시간 : " + (end-start));
		
		
		PriorityQueue qq = new PriorityQueue();
		qq.offer(3);
		qq.offer(7);
		qq.offer(2);
		qq.offer(10);
		System.out.println(qq);
		System.out.println(qq.peek());
		System.out.println(qq.remove());
		System.out.println(qq.peek());
		
	}

}

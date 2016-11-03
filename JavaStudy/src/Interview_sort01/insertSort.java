package Interview_sort01;

import java.util.LinkedList;
import java.util.List;

public class insertSort {

	public static void main(String[] args) {
		List<Integer> test = new LinkedList<Integer>();
		test.add(3);
		test.add(8);
		test.add(2);
		test.add(9);
		test.add(1);
		test.add(6);
		test.add(4);
		test.add(15);
		
		LinkedList<Integer> dd = new LinkedList<Integer>();
		
		System.out.print(insertsort(test));
		
//		originList: for(Integer num : test) {
//			System.out.println(num);
//		}

	}
	
	public static List<Integer> insertsort(final List<Integer> numbers) {
		final List<Integer> sortedList = new LinkedList<>();
		
		originalList: for(Integer number : numbers) {
			for(int i=0; i < sortedList.size() ; i++) {
				if(number < sortedList.get(i)) {
					sortedList.add(i,number);
					continue originalList;
				}
			}
			sortedList.add(sortedList.size(),number);
		}
		return sortedList;
	}

}

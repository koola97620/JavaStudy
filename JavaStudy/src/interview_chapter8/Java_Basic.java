package interview_chapter8;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Java_Basic {

	public static void main(String[] args) {
		final int[] myArray = new int[]{0,1,2,3,4,5};
		int[] arrayRef = myArray;
		arrayRef[5] = 99;
		
		Integer i1 = new Integer(0);
		int i2 = 0;
		int i3 = Integer.valueOf(0);
		
		System.out.println();
		
		
		
	}
	
	@Test
	public void finalReference() {
		final int i = 42;
		
		final List<String> list = new ArrayList<String>(20);
		assertEquals(0, list.size());
		
		list.add("adding a new value into my list");
		assertEquals(1, list.size());
		
		list.clear();
		assertEquals(0, list.size());
	}
	
	@Test
	public void arrayReferences() {
		final int[] myArray = new int[]{0,1,2,3,4,5};
		int[] arrayRef = myArray;
		arrayRef[5] = 99;
		
		assertFalse(myArray[5] == 5);
	}

}

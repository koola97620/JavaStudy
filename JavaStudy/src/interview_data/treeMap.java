package interview_data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class treeMap {
	
	@Test
	public void treeMapTraversal() {
		final Map<Integer,String> counts = new TreeMap<>();
		counts.put(4, "four");
		counts.put(1, "one");
		counts.put(3, "three");
		counts.put(2, "two");
		
		final Iterator<Integer> keys = counts.keySet().iterator();
		assertEquals(Integer.valueOf(1), keys.next());
		assertEquals(Integer.valueOf(2), keys.next());
		assertEquals(Integer.valueOf(3), keys.next());
		assertEquals(Integer.valueOf(4), keys.next());
		assertFalse(keys.hasNext());
	}

	public static void main(String[] args) {
		treeMap tr = new treeMap();
		tr.treeMapTraversal();

	}

}

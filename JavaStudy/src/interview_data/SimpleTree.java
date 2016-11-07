package interview_data;

public class SimpleTree <E extends Comparable>{
	private E value;
	private SimpleTree<E> left;
	private SimpleTree<E> right;
	
	public SimpleTree(E data, SimpleTree left, SimpleTree right) {
		value = data;
		this.left = left;
		this.right = right;
	}

	public E getValue() {
		return value;
	}



	public void setValue(E value) {
		this.value = value;
	}



	public SimpleTree<E> getLeft() {
		return left;
	}



	public void setLeft(SimpleTree<E> left) {
		this.left = left;
	}



	public SimpleTree<E> getRight() {
		return right;
	}



	public void setRight(SimpleTree<E> right) {
		this.right = right;
	}
	
	public boolean search(final E toFind) {
		if(toFind.equals(value)) {
			return true;
		}
		if(toFind.compareTo(value) < 0 && left != null) {
			return left.search(toFind);
		}
		return right != null && right.search(toFind);
	}
	
	
	public void insert(final E toInsert) {
		if(toInsert.compareTo(value) < 0 ) {
			if(left == null) {
				left = new SimpleTree<>(toInsert,null,null);
			} else {
				left.insert(toInsert);
			}
		} else {
			if(right == null) {
				right = new SimpleTree<>(toInsert,null,null);
			} else {
				right.insert(toInsert);
			}
		}
	}
	
	public void createTree() {
		final SimpleTree<Integer> root = new SimpleTree<>(7,null,null);
		root.insert(3);
		root.insert(9);
		root.insert(10);
		
	}



	public static void main(String[] args) {
		SimpleTree test = new SimpleTree(null,null,null);
		test.createTree();
		System.out.println(test.search(10));

	}

}

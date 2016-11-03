package chapter2;

class ArrayStack {
	public int top;
	public int[] itemArray;
	public int stackSize;
	
	public ArrayStack(int stackSize) {
		itemArray = new int[stackSize];
		top = -1;
		this.stackSize = stackSize;
	}
	public boolean isEmpty() {
		return (top==-1);
	}
	
	public boolean isFull() {
		return (top == this.stackSize -1 );
	}
	
	public void push(int item) {
		if(isFull()) {
			System.out.println("Full !!");
		} else {
			itemArray[++top] = item;
			System.out.println("Inserted item : " + item);
		}
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Empty");
			return -1;
		} else {
			return itemArray[top--];
		}
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("empty");
			return -1;
		} else {
			return itemArray[top];
		}
	}
	
}

public class StackClient {

	public static void main(String[] args) {
		ArrayStack as = new ArrayStack(10);
		System.out.println(as.isEmpty());
		System.out.println(as.isFull());
	}

}

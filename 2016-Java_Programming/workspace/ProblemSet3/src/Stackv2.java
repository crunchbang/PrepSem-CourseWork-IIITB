/*
 * Set 3 - Q1 Inheritance 
 */
public class Stackv2 extends DLList {
	
	private int top = -1;
	
	boolean isEmpty() {
		return (size() == 0);
	}

	Object pop() {
		if (isEmpty())
			return null;
		Object item = get(top);
		remove(top);
		top--;
		return item;
	}

	void push(Object obj) {
		append(obj);
		top++;
		
	}
	
	public String toString() {
		return super.toString();
		
	}
}

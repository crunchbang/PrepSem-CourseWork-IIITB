/*
 * Set 3 - Q2
 */
public class GenericStack<T> extends DLList {
	
	private int top = -1;
	
	boolean isEmpty() {
		return (size() == 0);
	}

	T pop() {
		if (isEmpty())
			return null;
		T item = (T) get(top);
		remove(top);
		top--;
		return item;
	}

	void push(T obj) {
		append(obj);
		top++;
		
	}
	
	public String toString() {
		return super.toString();
		
	}
}

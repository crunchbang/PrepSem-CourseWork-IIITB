/*
 * Set 3 - Q1 Composition
 */
class Stackv1 {
	private DLList ll;
	private int top = -1;
	
	public Stackv1() {
		ll = new DLList();
	}

	boolean isEmpty() {
		return (ll.size() == 0);
	}

	Object pop() {
		if (isEmpty())
			return null;
		Object item = ll.get(top);
		ll.remove(top);
		top--;
		return item;
	}
	
	Object peep() {
		if (isEmpty())
			return null;
		return ll.get(top);
		
	}

	void push(Object obj) {
		ll.append(obj);
		top++;
		
	}
	
	public String toString() {
		return ll.toString();
		
	}
	

}

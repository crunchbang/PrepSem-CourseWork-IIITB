
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

	void push(Object obj) {
		ll.append(obj);
		top++;
		
	}
	
	public String toString() {
		return ll.toString();
		
	}
	
	
	public static void main(String[] args) {
		Stackv1 stack = new Stackv1();
		
		System.out.println(stack.isEmpty());
		stack.push(45);
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.push(5);
		System.out.println(stack);
		stack.push(52);
		System.out.println(stack);
		stack.push(15);
		System.out.println(stack);
		stack.push(19);
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.push(95);
		System.out.println(stack);
		stack.push(85);
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		
	}

}

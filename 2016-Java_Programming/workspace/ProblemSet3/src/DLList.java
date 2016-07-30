/*
 * Set 3 - Q1
 */
public class DLList {
	// pos specifies the location in the list where the operation
	// needs to be performed
	private int len = 0; 
	private Node headNode;
	private Node tailNode;
	private int loc;
	public void insert(int pos, Object obj) {
		if (len == 0) {
			headNode = new Node(obj);
			tailNode = headNode;
			headNode.setPrev(null);
			headNode.setNext(null);
		} else {
			Node p = headNode;
			Node n = new Node(obj);
			n.setNext(null);
			n.setPrev(null);

			if (pos == 0) {
				n.setNext(headNode);
				headNode.setPrev(n);
				headNode = n;
			} else {
				for (loc = 0; loc < len; ++loc) {
					if (pos == loc+1) {
						n.setNext(p.getNext());
						if (p.getNext() != null)
							p.getNext().setPrev(n);
						p.setNext(n);
						n.setPrev(p);
					} else {
						p = p.getNext();
					}
				}
			}
			if (pos == len)
				tailNode = n;
		}
		len++;
	}

	public void remove(int pos) {
		Node n;
		Node p;
		if (pos == 0) {
			headNode =  headNode.getNext();
			if (headNode != null)
				headNode.prev = null;
		} else {
			p = (Node) get(pos-1);
			n = p.getNext();
			p.setNext(n.getNext());
			if (n.getNext() != null)
				n.getNext().setPrev(p);
			n.setNext(null);
			n.setPrev(null);
			if (pos == len-1)
				tailNode = p;
		}
		len--;
	}

	public Object get(int pos) {
		Node p = headNode;
		for (loc = 0; loc < pos; ++loc) {
			p =  p.getNext();
		}
		return p;
	}

	public int find(Object obj) { // return the position of obj
		Node p = headNode;
		int targetPos = -1;
		for (int i = 0; i < len; ++i) {
			if (p.getData().equals(obj)) {
				targetPos = i;
				break;
			}
			else 
				p = p.getNext();
		}
		return targetPos;
	}

	public int size() {
		return len;
	}

	public void clear() {
		headNode = null;
		tailNode = null;
		len = 0;
	}

	public void append(Object obj) { // add to the end
		Node n = new Node(obj);
		n.setPrev(null);
		n.setNext(null);
		if (len == 0) {
			tailNode = headNode = n;
		}
		else {
			tailNode.setNext(n);
			n.setPrev(tailNode);
			n.setNext(null);
			tailNode = n;
		}
		len++;
	}

	public String toString() {
		StringBuilder repr = new StringBuilder("");
		Node p = headNode;
		if (p == null) 
			repr.append("Empty List");
		else {
			for (loc = 0; loc < len; ++loc) {
				repr.append(p.getData() + "<->");
				p = p.getNext();
			}
		}

		return repr+" ";
	}

	public static void main(String[] args){
		DLList bookList = new DLList();
		System.out.println(bookList);
		bookList.append("Harry Potter I");
		System.out.println(bookList);
		bookList.insert(0, "Hamlet");
		System.out.println(bookList);
		bookList.insert(0, "Cosmos");
		System.out.println(bookList);
		bookList.insert(1, "Java");
		System.out.println(bookList);
		bookList.remove(1);
		System.out.println(bookList);
		bookList.insert(1, "C++");
		bookList.insert(2, "LISP");
		bookList.insert(2, "Calvin & Hobbes");
		System.out.println(bookList);
		int pos = bookList.find("LISP");
		bookList.remove(pos);
		System.out.println(bookList);
		// autoboxing and unboxing
		bookList.clear();
		bookList.append(1);
		bookList.append(1);
		bookList.append(2);
		bookList.append(3);
		System.out.println(bookList);
		pos = bookList.find(2);
		bookList.remove(pos);
		System.out.println(bookList);
	}


	class Node {

		Object data;
		Node prev;
		Node next;

		public Node(Object obj) {
			data = obj;
			next = prev = null;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getNext() {
			return next;
		}

		public void setData(Object obj) {
			data = obj;
		}

		public Object getData() {
			return data;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}

		public Node getPrev() {
			return prev;
		}
		
		public String toString() {
			return data.toString();
		}
	}

}

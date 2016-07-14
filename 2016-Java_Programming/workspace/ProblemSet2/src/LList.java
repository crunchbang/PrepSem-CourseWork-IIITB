public class LList {
	// pos specifies the location in the list where the operation
	// needs to be performed
	int len = 0; 
	Node headNode;
	int loc;
	public void insert(int pos, Object obj) {
		if (len == 0) {
			headNode = new Node(obj);
		} else {
			Node p = headNode;
			Node n = new Node(obj);
			
			if (pos == 0) {
				n.link(headNode);
				headNode = n;
			} else {
				for (loc = 0; loc < len; ++loc) {
					if (pos == loc+1) {
						n.link(p.getNext());
						p.link(n);
					} else {
						p = (Node) p.getNext();
					}
				}
			}
		}

	}

	public void remove(int pos) {
		Node p = headNode;
		Node n;
		if (pos == 0) {
			headNode = (Node) headNode.getNext();
		} else {
			for (loc = 0; loc < len; ++loc) {
				if (pos == loc + 1) {
					n = (Node) p.getNext();
					p.link(n.getNext());
					n.link(null);
				} else {
					p = (Node) p.getNext();
				}
			}
		}
	}

	public Object get(int pos) {
		
	}
	public int find(Object obj) { // return the position of obj
	}
	public int size() {
	}
	public void clear() {
	}
	public void append(Object obj) { // add to the end
	}
	public String toString() {
	}

	public static void main(String[] args){
		LList bookList = new LList();
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
}

class Node {
	
	Object data;
	Object next;
	
	public Node(Object obj) {
		data = obj;
	}
	
	public void link(Object nxt) {
		next = nxt;
	}
	
	public void setData(Object obj) {
		data = obj;
	}
	
	public Object getNext() {
		return next;
	}



}
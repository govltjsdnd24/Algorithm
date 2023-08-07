package edu.ssafy.datastructure.stack;

public class MyPointerStack {
	
	class Node{
		Object data;
		Node prev;
		
		public Node(Object input) {
			this.data= input;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", prev=" + prev + "]";
		}
		
	}
	
	private Node top=null;
	private int size =0;
	
	public void push(Object data) {
		Node newNode = new Node(data);
		if(top==null) {
			top=newNode;
		} else {
			newNode.prev=top;
			top=newNode;
		}
		size++;
	}
	
	public Object pop() {
		if(top!=null) {
			Node tmp=top;
			Object data= tmp.data;
			top=tmp.prev;
			size--;
			return data;
		}
		throw new RuntimeException("stack is empty");
	}
	
	public Object peek() {
		if(top!= null)
			return top.data;
		throw new RuntimeException("stack is empty");
	}
	
	public int size() {
		return this.size;
	}

	public static void main(String[] args) {
		MyPointerStack s = new MyPointerStack();
		s.push("Ssafy");
		s.push(12);
		s.push(1.123f);
		
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.size());

	}

}

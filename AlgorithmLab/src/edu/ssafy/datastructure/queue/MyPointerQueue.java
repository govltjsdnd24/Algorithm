package edu.ssafy.datastructure.queue;

public class MyPointerQueue {
	
	class Node{
		Object data;
		Node next;
		public Node(Object data){
			this.data=data;
		}
	}
	private Node rear;
	private Node front;
	private int size;
	
	public boolean isEmpty() {
		return front==null;
	}
	
	public void enQueue(Object data) {
		Node tmp= new Node(data);
		if(isEmpty()) {
			front=tmp;
			rear=tmp;
		}
		else {
			rear.next=tmp;
			rear= tmp;
		}
		
	}
	
	public Object deQueue() {
		if(isEmpty()) throw new RuntimeException("queue가 비어있어요.");
		Node tmp= front;
		front = front.next;
		front = null;
		size--;
		return tmp.data;
	}
	
	public Object peek() {
		if(isEmpty()) throw new RuntimeException("queue가 비어있어요");
		return front.data;
	}


	public static void main(String[] args) {
		MyArrayQueue Q = new MyArrayQueue();
		Q.enQueue(1);
		Q.enQueue(3);
		Q.enQueue(5);

		System.out.println(Q.deQueue());
		System.out.println(Q.peek());
		System.out.println(Q.deQueue());
		System.out.println(Q.deQueue());

	}

}

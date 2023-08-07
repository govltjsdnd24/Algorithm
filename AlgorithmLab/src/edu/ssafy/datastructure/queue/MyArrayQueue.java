package edu.ssafy.datastructure.queue;

public class MyArrayQueue {
	
	private Object[] queue;
	private int front,rear;
	private int size=0;
	
	public MyArrayQueue() {
		this(10);
	};
	public MyArrayQueue(int size) {
		this.size=size;
		queue=new Object[size];
	}
	
	public boolean isEmpty() {
		if(rear==front)
			return true;
		else
			return false;
	}
	
	public boolean isFull() {
		if(rear==size) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void enQueue(Object data) {
		if(isFull())
			throw new RuntimeException("다 찼어요");
		queue[rear++]=data;
		size++;
	}
	
	public Object deQueue() {
		if(isEmpty())
			throw new RuntimeException("비었어요");
		Object item= queue[front];
		front++;
		size--;
		return item;
	}
	
	public Object peek() {
		return queue[front];
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

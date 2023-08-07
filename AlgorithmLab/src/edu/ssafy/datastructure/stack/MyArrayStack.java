package edu.ssafy.datastructure.stack;

class MyStackOverflowException extends RuntimeException{
	public MyStackOverflowException() {
		super("스택이 넘쳐 흘렀습니다.");
	}
}

class MyStackEmptyException extends RuntimeException{
	public MyStackEmptyException() {
		super("스택이 비었습니다.");
	}
}

public class MyArrayStack<T> {
	
	private T[] stack;
	private int top=0;
	private int size;
	
	public MyArrayStack() {
		this(10);
	}
	
	public MyArrayStack(int size) {
		this.size=size;
		stack= (T[]) new Object[size];
	}
	
	public void push(T data) {
		if(top>stack.length-1)
			throw new MyStackOverflowException();
		stack[++top]=data;
	}
	
	public T pop() {
		if(top<0) {
			throw new MyStackEmptyException();
		}
		return stack[top--];
	}
	
	public T peek() {
		return stack[top];
	}
	
	public int size() {
		return size();
	}
	
	public static void main (String[] args) {
		MyArrayStack<Integer> s = new MyArrayStack<Integer>();
		s.push(1);
		s.push(3);
		s.push(5);
		
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
	
}

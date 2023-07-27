package com.ssafy.h_exception.custom;

class ArrayFullException extends Exception{
	private String msg;
	public ArrayFullException(String msg) {
		super(msg);
		this.msg=msg;
	}
	
	@Override
	public String getMessage() {
		return "배열이 꽉차서 더 이상 추가X";
	}
}

class ArrayEmptyException extends RuntimeException{
	private String msg;
	public ArrayEmptyException(String msg) {
		super(msg);
		this.msg=msg;
	}
	
	@Override 
	public String getMessage() {
		return "배열이 비어서 더 이상 삭제X";
	}
}

class Person{
	String name;
	int age;
	public Person(String name, int age) {
		this.name=name;
		this.age=age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}

class NotFoundException extends RuntimeException{
	String msg;
	public NotFoundException(String msg) {
		super(msg);
		this.msg=msg;
	}
	public String getMessage()  {
		return "찾으시는 "+this.msg + "는 저장되어 있지 않아요";
	}
}

class ArrayManager{
	private Person [] arr;
	private int idx=0;
	private int MAX = 3;
	
	ArrayManager() {
		arr=new Person[3];
	}
	public void add(Person a) throws ArrayFullException{
		if(idx==MAX) throw new ArrayFullException("full");
		arr[idx]=a;
		idx++;
	}
	public void removeLast() throws ArrayEmptyException{
		if (idx==0) throw new ArrayEmptyException("empty");
		idx--;
		arr[idx]=null;
	}
	public void printArr() {
		for(int i=0;i<idx;i++) {
			System.out.println(arr[i]);
		}
	}
	
	public Person find(String name) {
		for(int i=0;i<idx;i++) {
			if(arr[i].name.contentEquals(name)) {
				return arr[i];
			}
		}
		//return null;
		throw new NotFoundException(name);
	}
}

public class UserException02 {
	
	public static void main(String[] args) {
		ArrayManager man = new ArrayManager();
		try {
			man.add(new Person("둘리", 3));
			man.add(new Person("도우너", 5));
			System.out.println(man.find("도우너"));
			System.out.println(man.find("고길동"));
			man.printArr();
			man.removeLast();
			man.printArr();
			man.removeLast();
			man.removeLast();
		} catch(ArrayFullException e) {
			System.out.println(e.getMessage());
		} catch(ArrayEmptyException e) {
			System.out.println(e.getMessage());
		} catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

}

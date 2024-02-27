package com.ssafy.c_abstraction.method;

public class ThisTest2 {
	
	String name;
	int age;
	
	ThisTest2(String name, int age){
		this.name=name;
		this.age=age;
	}

	public static void main(String[] args) {
		//this
		ThisTest2 a = new ThisTest2("둘리",21);
	}
	
//	class Inner{
//		//this
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				//this
//			}
//		});
//	}

}

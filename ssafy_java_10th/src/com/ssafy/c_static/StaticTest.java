package com.ssafy.c_static;
/*
 * static
 * 		위치: 변수, 메소드, 내부클래스, 블럭
 * 		클래스가 로딩될 때 메모리에 적재됨으로 객체를 생성하지 않고 사용 가능하다.
 * 		
 */

public class StaticTest {
	//변수
	//instance variable
	int i;
	
	static{
		System.out.println("static block");
	}
	
	//instance block
	{
		System.out.println("instance block");
	}
	
	StaticTest(){
		System.out.println("St const");
	}
	StaticTest(int a){
		System.out.println("St(int a) const");
	}
	//
	static int si;
	public static void main(String[] args) {
		StaticTest t=new StaticTest();
		t.i=10;
		t.si=100;
		StaticTest t1=new StaticTest(10);
		System.out.println(t1.i);
		System.out.println(t1.si);
		t.print();
		t.staticPrint();
		StaticTest.staticPrint();
	}
	void print() {
		i++;
		si++;
	}
	static void staticPrint() {
		si++;
		//static method 에서는 instance 변수는 호출불가능.
	}

}

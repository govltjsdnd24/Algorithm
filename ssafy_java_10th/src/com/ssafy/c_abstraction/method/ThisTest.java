package com.ssafy.c_abstraction.method;
/*
 * this 쓸 수 있는 위치:
 * 		method
 * this의 대상:
 * 		this가 사용된 method를 멤버로 가지고 있는 객체
 */
public class ThisTest {
	int i;
	
	ThisTest(){
		this(1);
	}
	ThisTest(int a){
		this.i=a;
	}
	
	void print3(ThisTest tt) {
		System.out.println("This Test");
	}
	void print2() {
		System.out.println(this.i);
	}
	
	void print() {
		//this.i=10;
		this.print2();
		this.print3(this);
	}
	
	public static void main(String[] args) {
		ThisTest tt=new ThisTest();
		tt.print();
	}

}

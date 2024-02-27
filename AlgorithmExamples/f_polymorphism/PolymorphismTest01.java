package com.ssafy.f_polymorphism;

class Father{
	int i=10;
	void print() {
		System.out.println("Father print i="+this.i);
	}
}
class Son extends Father{
	int i=20;
	int j;
	void print() {
		System.out.println("Son print i="+this.i);
	}
}

public class PolymorphismTest01 extends Object {
	public static void main(String[] args) {
		Father f= new Father();
		Son s = new Son();
		s.print();
		//ploy
		//upcasting
		Father f1=/*(Father)*/ new Son();
		//
		//Son s1= (Son)new Father();
		//Son s1= (Son)f1;
		
		//활용
		System.out.println(f1.i);
		f1.print();
		//toPrint(f);
		//toPrint(s);
		toPrint(f1);
	}
	
	static void toPrint(Father f) {
		f.print();
	}
//	static void toPrint(Son s) {
//		s.print();
//	}
	
}

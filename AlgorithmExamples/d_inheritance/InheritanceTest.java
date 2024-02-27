package com.ssafy.d_inheritance;

class Father extends Object{
	int money;
	Father(){}
	Father(int money){
		this.money=money;
	}
	void work(int time) {
		System.out.println("회사원");
		money+=time;
	}
	
	void print() {
		System.out.println("father print");
	}
//	Father(){};
}
class Son extends Father{
	String hobby;
	Son() {}
	Son(String hobby){
		//super();
		super.money=1;
		this.money=2;
		this.hobby=hobby;
	}
	//override (리턴 이름 같아햐 한다)
	void work(int time) {
		System.out.println("유튜브합니다");
		this.money*=time;
	}
	
//	public void toString() {
//		return String;
//	}
	
	void print() {
		System.out.println("son print");
	}
	
//	Son(){};
}

public class InheritanceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Son s= new Son("인터넷");
		
		System.out.println(s.money);
		s.hobby= "놀기";
		s.work(10);
		System.out.println(s.money);
		
		Father f= new Father();
		f.print();
		s.print();
		
		Father f1= new Son();
		f1.print();
	}

}

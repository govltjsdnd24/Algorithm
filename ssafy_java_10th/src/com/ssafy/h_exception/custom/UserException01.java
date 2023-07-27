package com.ssafy.h_exception.custom;

public class UserException01 {
	class Number2 extends Exception{
		public Number2(String msg) {
			super(msg);
		}
	}
	
	public void method() throws Number2{
		for(int i=0;i<5;i++) {
			System.out.println("before "+i);
			//custom exception
			if(i==2) throw new Number2("i가 2 입니다");
			System.out.println("after "+i);
		}
	}
	
	public static void main(String[] args) {
		UserException01 ex1=new UserException01();
		try {
			ex1.method();
		} catch (Number2 e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}

package com.ssafy.j_fileio.lambda;

@FunctionalInterface
interface Printer{
	void print(String msg);
}

@FunctionalInterface
interface Printer2{
	void print();
}
@FunctionalInterface
interface Printer3{
	int print();
}

public class Lambda01 {
	
	public static void main(String[] args) {
		Printer p;
		p= new Printer() {
			
			@Override
			public void print(String msg) {
				// TODO Auto-generated method stub
				System.out.println(msg);
			}
		};
		p.print("Legacy 1");
		
		//lambda 01
		p=(String msg)->{
			System.out.println(msg);
			System.out.println(msg);
			};
		p.print("Lambda 1");
		
		
		//lambda 02
		p=(String msg)->System.out.println(msg);
		p.print("lambda 2");
		
		//lambda 03
		p=(msg1)->System.out.println(msg1);
		p.print("lambda 3");
		
		//lambda 04
		p=msg1->System.out.println(msg1);
		p.print("lambda 4");
		
		
		//lambda 05 인자가 없다면
		Printer2 p2;
		p2=()-> System.out.println("lambda 05 인자없음");
		p2.print();
		
		
		//lambda 06 return이 있다면
		Printer3 p3;
		p3=()->{int a=10,b=20;return 10;};
		System.out.println(p3.print());
		
		//lambda 07 리턴이 있고 한줄이라면 중괄호를 생략할 수 있다.
		//만약 한줄이라도 중괄호가 있다면 return을 사용해야 리턴 가능
		p3=()->10+25;
		System.out.println(p3.print());
		
		
		
	}
}

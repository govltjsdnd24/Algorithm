package com.ssafy.j_fileio.lambda;

import java.util.Arrays;

interface MyInter{

	void print(String[] langs);
}

public class Lambda04 {
	private String[] langs= {"Java","C","Javascript","SQL"};
	private int memberval =10;

	public void userMyInter(MyInter m, String [] langs) {
		m.print(langs);
	}
	
	public void myMethod() {
		int localval=20;
		userMyInter(name->{
			System.out.println();
			System.out.println(this.memberval);
			System.out.println(localval);}
		,langs);
	}
	
	public static void main(String[] args) {
		Lambda04 l=new Lambda04();
		
		l.myMethod();
		
	}
}

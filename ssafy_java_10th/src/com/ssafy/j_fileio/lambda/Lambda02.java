package com.ssafy.j_fileio.lambda;

interface Calc{
	int cal(int a, int b);
}


public class Lambda02 {
	public static void print (Calc c,int a,int b) {
		System.out.println(c.cal(a, b));
	}
	public static void main(String[] args) {
		Calc c;
		c=(a,b)->a+b;
		System.out.println(c.cal(3,5));
		
		c= (a,b)->a-b;
		System.out.println(c.cal(5, 3));
		
		print((a,b)->a+b,3,5);
	}

}

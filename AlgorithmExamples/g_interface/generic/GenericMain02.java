package com.ssafy.g_interface.generic;

import java.util.List;
import java.util.ArrayList;

/*
 * Generic
 * 		정의: 클래스 제작 시에 타입을 결정하지 않고 사용시에 결정하는 기법
 */

class Grand{
	
}

class Mother extends Grand{
	
}

class Daughter extends Mother{
	
}


public class GenericMain02 {
	static void print(List<Mother> list) {
		
	}
	
	public static void main(String[] args) {
		Mother[] arr= new Mother[2];
		
		
		Mother m1 = new Mother();
		Daughter d= new Daughter();
		arr[0]= m1;
		arr[1] = d;
		Grand g= new Grand();
		
		List<Grand>list0= new ArrayList<Grand>();
		list0.add(g);
		list0.add(m1);
		list0.add(d);
		
		List<Mother> list1 = new ArrayList();
		list1.add(m1);
		list1.add(d);
		
		List<Daughter> list2= new ArrayList();
		list2.add(d);
		
		//list1=list2;
//		print(list2);
		
//		print0(list0);
//		print0(list1);
//		print0(list2);
		
//		print1(list1);
//		print1(list2);
//		print1(list0);
		
//		print2(list0);
//		print2(list1);
//		print2(list2);
		
		
		
	}
	static void print0(List<?> list) {
		System.out.println("grand");
	}
	static void print1(List<? extends Mother> list) {
		System.out.println("grand");
	}
	static void print2(List<? super Mother> list) {
		System.out.println("grand");
	}
}

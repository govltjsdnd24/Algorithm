package com.ssafy.g_interface.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Generic
 * 		정의: 클래스 제작 시에 타입을 결정하지 않고 사용시에 결정하는 기법
 */
class Father {
	
}

class Son extends Father{
	
}

class Generic <T,G>{
	private T[] i;
	private G j;
	public void setI(T... i) {
		this.i=i;		
	}
	public T[] getI() {
		return i;
	}
	public G getJ() {
		return j;
	}
}

//Generic의 상속
class SubGeneric extends Generic<Integer, String>{
	
	@Override
	public void setI(Integer... i) {
		// TODO Auto-generated method stub
		super.setI(i);
	}
	
	@Override
	public Integer[] getI() {
		// TODO Auto-generated method stub
		return super.getI();
	}
	@Override
	public String getJ() {
		// TODO Auto-generated method stub
		return super.getJ();
	}
}

public class GenericMain01 {
	public static void main(String[] args) {
//		Generic<Father> g=new Generic();
		Generic<Integer,Integer> g= new Generic<Integer, Integer>();
//		g.setI(new Integer[] {1,2,3});
		g.setI(1,2,3);
		Integer[] i= g.getI();
		System.out.println(Arrays.toString(i));
//		Father i=g.getI();
//		g.setI(123);
//		Integer i=g.getI();
		
		SubGeneric sg= new SubGeneric();
		sg.setI(i);
		String g2= sg.getJ();
		
		ArrayList<Integer> list = new ArrayList();
		Integer integer =list.get(0);


		for(Integer a: list) {
			
		}
		
		Map <Integer,String> map = new HashMap();
		map.put(1, "One");
		Object object = map.get(1);
	}
}

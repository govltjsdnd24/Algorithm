package com.ssafy.e_modifier.last;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="ssafy";
		String str2="ssafy";
		String str3=new String("ssafy");
		String str4=new String("ssafy");
		
		if(str1==str2) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		if(str3==str4) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		
//		String temp="ssafy";
//		System.out.println(temp);
//		temp+="!!";
//		System.out.println(temp);
		
	}

}

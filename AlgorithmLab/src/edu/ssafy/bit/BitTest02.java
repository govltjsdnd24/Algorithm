package edu.ssafy.bit;

import java.util.Arrays;

public class BitTest02 {

	public static void main(String[] args) {
		boolean[] arr= new boolean[7];
		
		arr[0]=true;
		arr[3]=true;
		
		
		System.out.println(Arrays.toString(arr));
		
		int a=3;
		//00000011
		//we can use integer as array of boolean

		int b=5; //00000101
				 //& 00000100 <=mask
	}

}

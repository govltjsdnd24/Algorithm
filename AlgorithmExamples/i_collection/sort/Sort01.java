package com.ssafy.i_collection.sort;

import java.util.Arrays;

public class Sort01 {

	public static void main(String[] args) {
		Integer[] arr= new Integer[]{2,1,4,3,5,7,6};
		Arrays.sort(arr);
		
		Arrays.sort(arr, new Comparator<Integer>() {
			
			@Override
			public int compare(Integer a, Integer b) {
				// TODO Auto-generated method stub
				// 양수 그대로,
				//0, 음수면 반대로
				return Integer.compare(a, b)*-1;
			}

		});
		System.out.println(Arrays.toString(arr));
		
		//객체생성방법
		//1
		Thread s =new Thread();
		//2 객체 생성하면서 override (재정의)
		Thread s1 = new Thread() {
			
		};
		//3 Interface를 객체생성하는 방법
		Comparator<Integer>com = new Comparator<Integer>() {
			
		}
	
		
	}

	static void sort(Integer[] arr,Comparator c) {
		for (int i = 0; i < arr.length; i++) {
			c.compare(arr[i], arr[i+1]);
		}
	}
}

interface Comparator<Integer>{
	public int compare(Integer a, Integer b);
}
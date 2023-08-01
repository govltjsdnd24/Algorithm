package edu.ssafy.recursive;

public class Recursive04 {
	static int[] arr= {1,3,5,7,9};
	public static void main(String[] args) {
		/*
		 * 재귀 함수의 리턴 값을 이용하여 배열 요소 값의 합을 구해보세요
		 */
		
		int sum= recursion(0);
		System.out.println(sum);
	}
	
	public static int recursion(int idx) {
		
		if(idx==arr.length) {	
			return 0;
		}
		
		return(recursion(idx+1)+arr[idx]);
	}
	
	

}

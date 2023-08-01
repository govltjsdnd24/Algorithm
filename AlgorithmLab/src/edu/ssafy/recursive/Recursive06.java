package edu.ssafy.recursive;

public class Recursive06 {
	static int[] arr= {1,3,5};
	public static void main(String[] args) {
		/*
		 * 재귀를 이용하여 합과 곱을 구하는데 함수의 인자를 2개만 사용하세요.
		 */
		
		recursion(0,1);
	}
	
	public static void recursion(int idx,int val) {
		//basis
		if(idx==arr.length) {	
			System.out.println(val);
			return ;
		}
		
		//inductive
		recursion(idx+1,val+arr[idx]);
		recursion(idx+1,val*arr[idx]);
	}
	
	

}

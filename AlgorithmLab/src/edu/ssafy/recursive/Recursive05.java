package edu.ssafy.recursive;

public class Recursive05 {
	static int[] arr= {1,3,5};
	public static void main(String[] args) {
		/*
		 * 재귀 함수를 이용해서 덧샘과 곱샘을 동시에 해보세요
		 */
		
		recursion(0,0,1);
	}
	
	public static void recursion(int idx,int sum, int product) {
		
		if(idx==arr.length) {	
			System.out.println("sum: "+sum+" product: "+ product);
			return ;
		}
		
		recursion(idx+1,sum+arr[idx],product*arr[idx]);
	}
	
	

}

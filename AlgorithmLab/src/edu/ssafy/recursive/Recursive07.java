package edu.ssafy.recursive;

public class Recursive07 {
	static int[] arr= {1,3,5};
	public static void main(String[] args) {
		recursive(0,1);
		System.out.println(Max);
	}
	static int Max=Integer.MIN_VALUE;
	private static void recursive(int idx,int val) {
		if(arr.length==idx) {
			Max=Math.max(Max, val);
			return;
		}
		
		recursive(idx+1, val+arr[idx]);
		recursive(idx+1,val*arr[idx]);
	}
}

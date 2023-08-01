package edu.ssafy.recursive;

public class Recursive08 {
	//return으로 구현
	static int[] arr= {1,3,5};
	
	public static void main(String[] args) {
		
		System.out.println(recursive(0,1));
	}
	
	private static int recursive(int idx,int val) {
		if(arr.length==idx) {
			return val;
		}
		return Math.max(recursive(idx+1, val+arr[idx]),recursive(idx+1,val*arr[idx]));
	}
}

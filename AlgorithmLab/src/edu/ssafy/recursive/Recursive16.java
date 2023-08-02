package edu.ssafy.recursive;

public class Recursive16 {
	//return으로 구현
	static int[] arr= {1,3,5};
	
	public static void main(String[] args) {
		int res = recursive(arr.length-1);
		System.out.println(res);
	}
	
	private static int recursive(int idx) {
		if(0>idx) {
			return 1;
		}
		return Math.max(recursive(idx-1)+arr[idx], recursive(idx-1)*arr[idx]);
	}
}

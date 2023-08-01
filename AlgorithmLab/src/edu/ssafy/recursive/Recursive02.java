package edu.ssafy.recursive;

public class Recursive02 {
	static int[] arr= {1,3,5,7,9};
	public static void main(String[] args) {
		recursion(0);
	}
	
	public static void recursion(int idx) {
		if(idx==arr.length)
			return;
		System.out.println(arr[idx]+" ");
		recursion(idx+1);
	}

}

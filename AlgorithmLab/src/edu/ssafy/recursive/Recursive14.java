package edu.ssafy.recursive;
import java.util.Arrays;

//부분집합 (조합의 묶음)
public class Recursive14 {

	public static void main(String[] args) {
		int []arr= new int[] {1,3,5};
		for (int i = 1; i <= arr.length; i++) {
			recursive(arr,new int[i],0,0);
		}
	}
	/*
	 *  arr: 원본배열
	 *  sel: 선택배열
	 *  idx: 원본배열인덱스
	 *  k: 선택배열인덱스
	 */
	private static void recursive(int [] arr, int [] sel, int idx, int k) {
		//basis part
		//선택배열이 다 차면 (선택이 끝나면)
		
		if(k==sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		//inductive part
		
		for (int i = idx; i < arr.length; i++) {
			sel[k]=arr[i];
			recursive(arr, sel, i+1, k+1);
		}
		

		
	}
}

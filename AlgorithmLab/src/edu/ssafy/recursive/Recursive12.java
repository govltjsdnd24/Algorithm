package edu.ssafy.recursive;
import java.util.Arrays;

//중복되지 않는 조합
public class Recursive12 {

	public static void main(String[] args) {
		
		recursive(new int[]{1,3,5},new int[2],0,0);
		System.out.println(cnt);
	}
	/*
	 *  arr: 원본배열
	 *  sel: 선택배열
	 *  idx: 원본배열인덱스
	 *  k: 선택배열인덱스
	 */
	
	static int cnt=0;
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

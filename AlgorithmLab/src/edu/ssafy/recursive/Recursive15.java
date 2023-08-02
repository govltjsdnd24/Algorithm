package edu.ssafy.recursive;
import java.util.Arrays;
/*
 * 부분 집합들의 집합
 * Power Set
 */
public class Recursive15 {
	static int[] arr= {1,3,5};
	static boolean [] sel=new boolean[arr.length]; //선택 배열
	
	public static void main(String[] args) {
		recursive(0);
	}

	private static void recursive(int idx) {
		//basis part
		if(idx==arr.length) {
			for (int i = 0; i < arr.length; i++) {
				if(sel[i]) {
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println();
			return;
		}
		
		//inductive part
		//선택한 경우
		sel[idx]=true;
		recursive(idx+1);
		//선택 안 한 경우
		sel[idx]=false;
		recursive(idx+1);
	}
}

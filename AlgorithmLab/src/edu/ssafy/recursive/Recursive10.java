package edu.ssafy.recursive;
import java.util.Arrays;
//중복을 허용하는 순열
public class Recursive10 {
	//원본배열
	static int[] arr= {1,3,5};
	//선택배열
	static int[] sel= new int[2];

	public static void main(String[] args) {
		
		recursive(0); //* What should we set as parameters
	}
	
	static int cnt=0;
	private static void recursive(int idx) {
		//basis part

		if(idx==sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		//inductive part

		for (int i = 0; i < arr.length; i++) {
			sel[idx]=arr[i];
			recursive(idx+1);
		}
		

		
	}
}

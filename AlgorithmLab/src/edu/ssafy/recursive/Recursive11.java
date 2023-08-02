package edu.ssafy.recursive;
import java.util.Arrays;

//중복되지 않는 순열
public class Recursive11 {
	//원본배열
	static int[] arr= {1,3,5};
	//선택배열
	static int[] sel= new int[2];
	//방문배열
	static boolean[] v=new boolean[arr.length];

	public static void main(String[] args) {
		
		recursive(0); //* What should we set as parameters
	}
	
	private static void recursive(int idx) {
		//basis part

		if(idx==sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		//inductive part
		
		for (int i = 0; i < arr.length; i++) {
			if(v[i]==false) {
				v[i]=true;
				sel[idx]=arr[i];
				recursive(idx+1);
				v[i]=false;
			}
		}
		
//		if(v[0]==false) {
//			v[0]=true;
//			sel[idx]=arr[0];
//			recursive(idx+1);
//			v[0]=false;
//		}
//		if(v[1]==false) {
//			v[1]=true;
//			sel[idx]=arr[1];
//			recursive(idx+1);
//			v[1]=false;
//		}
//		if(v[2]==false) {
//			v[2]=true;
//			sel[idx]=arr[2];
//			recursive(idx+1);
//			v[2]=false;
//		}
		
	}
}

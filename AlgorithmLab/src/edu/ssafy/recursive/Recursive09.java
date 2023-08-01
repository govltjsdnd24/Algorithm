package edu.ssafy.recursive;
import java.util.Arrays;

public class Recursive09 {
	//원본배열
	static int[] arr= {1,3,5};
//	{1},{3},{5},{1,3}...
	public static void main(String[] args) {
		int idx= 0; //원본배열 인덱스
		int []sel=new int[2]; //담을 배열 인덱스
		int k=0; //담을 배열 인덱스
		recursive(idx,sel,k); //* What should we set as parameters
	}
	
	private static void recursive(int idx,int [] sel,int k) {
		//basis part
		//k 값이 다 찬 경우 선택배열의 값을 출력한다.
		if(k==sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		//고를 값들을 모두 본 경우 더 이상 진행 되면 idx가 arr.length를 넘어가게 된다.
		if(idx==arr.length)
			return;
		
		//inductive part
		//선택하는 경우
		sel[k]=arr[idx];
		recursive(idx+1,sel,k+1);
		
		//선택하지 않는 경우
		recursive(idx+1,sel,k);
	}
}

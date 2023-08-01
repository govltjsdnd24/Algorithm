package edu.ssafy.recursive;

public class Recursive03 {
	static int[] arr= {1,3,5,7,9};
	public static void main(String[] args) {
		//재귀 함수를 이용하여 배열에 있는 요소값들의 합을 구하세요
		
		recursion(0,0);
	}
	
	public static void recursion(int idx,int sum) {
		if(idx==arr.length) {
			System.out.println(sum);
			return;
		}
		recursion(idx+1,sum+arr[idx]);
	}
	
	

}

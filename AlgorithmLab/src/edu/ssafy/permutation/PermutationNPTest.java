package edu.ssafy.permutation;

import java.util.*;

public class PermutationNPTest {

	public static void main(String[] args) {
		Scanner scan= new Scanner (System.in);
		int N= scan.nextInt();
		int[] input= new int[N];
		
		for (int i=0;i<N;i++) {
			input[i]=scan.nextInt();
		}
		Arrays.parallelSort(input); //오름차순의 형태로 정렬 (순열 1개가 만들어짐)
		long start= System.nanoTime();
		do {
			//순열을 이용한 처리
//			System.out.println(Arrays.toString(input));
		}
		while (np(input));
		long end= System.nanoTime();
		System.out.println((end-start)/1_000_000_000.0);
	}
	
	private static boolean np(int[]p) {// p: 다음 순열을 원하는 기존 순열의 배열
		//1. 맨 뒤쪽부터 탐색하며 꼭대기 찾기
		int N= p.length;
		int i= N-1;
		while(i>0 && p[i-1]>=p[i]) --i;
			if(i==0) return false; // 다음 순열은 없음 (가장 큰 순열의 형태)
			//2. 꼭대기 직전 (i-1) 위치에 교환할 한 단계 큰 수 뒤쪽부터 찾기
			int j=N-1;
			while(p[i-1]>=p[j]) --j;
			
			//3. 꼭대기 직전 (i-1)위치의 수와 한 단계 큰 수를 교환하기
			swap(p,i-1,j);
			
			//4. 꼭대기 자리부터 맨 뒤까지의 수를 오름차 순의 형태로 바꿈
			int k=N-1;
			while(i<k) {
				swap(p,i++,k--);
			}
			return true;
	}
	
	private static void swap(int []p, int a,int b) {
		int temp=p[a];
		p[a]=p[b];
		p[b]=temp;
	}
	
	

}

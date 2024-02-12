package a_january_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BAEKJOON_1026_보물 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		
		Integer[] B = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st2.nextToken());
		}
	
		Arrays.sort(A);
		Arrays.sort(B, Collections.reverseOrder());
		
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			sum += (A[i] * B[i]);
		}
		System.out.println(sum);
	}

}

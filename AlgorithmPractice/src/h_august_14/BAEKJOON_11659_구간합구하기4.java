package h_august_14;

import java.io.*;
import java.util.*;

public class BAEKJOON_11659_구간합구하기4 {
	static int N,M;
	static int[]numbers;
	static int[]collectives;
	static StringBuilder output=new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		numbers=new int[N];
		collectives= new int[N];
		st=new StringTokenizer(br.readLine());
		int i;
		for ( i = 0; i < N; i++) {
			numbers[i]=Integer.parseInt(st.nextToken());
			if(i==0)
				collectives[i]=numbers[i];
			else
				collectives[i]=collectives[i-1]+numbers[i];
		}
		
		for(i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			calculateRange(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1);
			if(i!=M-1)
				output.append("\n");
		}
		
		System.out.print(output);
		
	}
	
	public static void calculateRange(int start,int end) {
		long stockpile;
		if(start==0)
			stockpile=collectives[end]-collectives[start];
		else 
			stockpile=collectives[end]-collectives[start-1];
		
//		for(int i=start-1;i<=end-1;i++) {
//			stockpile+=numbers[i];
//		}
		output.append(stockpile);
	}

}

package i_september_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_14888_연산자 {
	
	static int[]numbers;
	static int[]operators=new int[4];
	static char[] symbols= {'+','-','x','%'};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());

		int N=Integer.parseInt(st.nextToken());
		numbers=new int[N];
		
		st= new StringTokenizer(br.readLine());
		int i;
		for (i = 0; i < N; i++)
			numbers[i]=Integer.parseInt(st.nextToken());
		
		st= new StringTokenizer(br.readLine());
		for (i = 0; i < 4; i++) 
			operators[i]=Integer.parseInt(st.nextToken());
		
		
		
	}

}

package h_august_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_2579_계단오르기 {
	
	static int[]memo;
	static int[]stairs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		stairs=new int[N];
		
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			stairs[i]=Integer.parseInt(st.nextToken());
		}
		
		memo=new int[N];
		memoization();
		
		
	}

	
	public static void memoization() {
		memo[0]=stairs[0];
		memo[1]=stairs[0]+stairs[1];
	}
}

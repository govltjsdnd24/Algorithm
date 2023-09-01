package h_august_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEKJOON_14501_퇴사 {
	
	static int[] memo;
	static int[] works;
	static int[] price;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		memo= new int[N+1];
		works=new int[N+1];
		price=new int[N+1];
		
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			works[i]=Integer.parseInt(st.nextToken());
			price[i]=Integer.parseInt(st.nextToken());
		}
		
		System.out.println(memoization(N));
		//System.out.println(Arrays.toString(memo));
	}
	
	static int memoization(int n) {
		if(n==1)
			return price[0];
		
		
		int max=-1;
		
		for (int i = 0; i <= n; i++) {
			max=Math.max(max, memo[i]);

			if(i+works[i]<=n) {
	
				memo[i+works[i]]=Math.max(price[i]+max, memo[i+works[i]]);

			}
				
		}
		max=memo[n];
		
		return max;
	}

}

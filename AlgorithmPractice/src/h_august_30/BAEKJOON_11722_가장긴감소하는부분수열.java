package h_august_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class numbers{
	
}

public class BAEKJOON_11722_가장긴감소하는부분수열 {
	
	static int[] array;
	static int[] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		array=new int[N];
		memo=new int[N];
		
		st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i]=Integer.parseInt(st.nextToken());
		}
		
		System.out.println(memoization(N));
		System.out.println(Arrays.toString(memo));
	}
	
	static int memoization(int n) {
		int max=1;
		Arrays.fill(memo,1);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if(array[j]>array[i]) {
					memo[i]=Math.max(memo[i], memo[j]+1);
					max=Math.max(memo[i], max);
				}
			}
		}
		return max;
	}
	

}

package h_august_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_11726_2n타일링 {
	
	static int[] memo=new int[1001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		memoization();
		int n=Integer.parseInt(st.nextToken());
		
		System.out.println(memo[n]);
	}
	
	public static void memoization() {
		memo[1]=1;
		memo[2]=2;
		
		for (int i = 3; i < memo.length; i++) {
			memo[i]=(memo[i-1]+memo[i-2])%10007;
		}
	}

}

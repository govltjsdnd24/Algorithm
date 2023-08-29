package h_august_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_9095_123더하기 {
	
	static int[] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		
		memo=new int[11];
		formCombinations();
		
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			
			System.out.println(memo[Integer.parseInt(st.nextToken())]);
		}
		
		
	}
	
	
	static void formCombinations(){
		memo[1]=1;
		memo[2]=2;
		memo[3]=4;
		memo[4]=7;
		
		for (int i = 5; i < 11; i++) {
			memo[i]=memo[i-1]+memo[i-2]+memo[i-3];
		}
		
	}

}

package h_august_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Workshop_막대기 {
	
	static long memo[]=new long[11];

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st= new StringTokenizer(br.readLine());
//		
//		int N=Integer.parseInt(st.nextToken());
		formCombinations();
		System.out.println(memo[6]);
		
	}
	
	static void formCombinations() {
		memo[0]=0;
		memo[1]=2;
		memo[2]=5;
		memo[3]=12;
		for (int i = 4; i <=10; i++) {
			memo[i]=memo[i-1]*2+memo[i-2];
		}
	}

}

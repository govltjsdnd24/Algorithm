package h_august_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_1463_1로만들기 {
	
	static int[] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		memo=new int[N+1];
		System.out.println(turnOneDP(N));
	}
	
	public static int turnOneDP(int value) {
		if(value==1)
			return 0;
		if(value<=3)
			return 1;
		
		memo[1]=1;
		memo[2]=1;
		memo[3]=1;
		
		for (int i = 4; i<=value; i++) {
			if(i%3==0) 
				memo[i]=memo[i/3]+memo[3];
			else if(i%2==0) {
				if(memo[i/2]<memo[i-1])
					memo[i]=memo[i/2]+memo[2];
				else
					memo[i]=memo[i-1]+1;
			}
			else
				memo[i]=memo[i-1]+1;
		}
		return memo[value];
	}

}

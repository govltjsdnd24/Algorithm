package h_august_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5601_쥬스나누기 {

	static int N;
	static StringBuilder output;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int T= Integer.parseInt(st.nextToken());
		
		for (int testcase = 1; testcase <= T; testcase++) {
			st= new StringTokenizer(br.readLine());
			N= Integer.parseInt(st.nextToken());
			output=new StringBuilder();
			
			for (int i = 1; i <=N; i++) {
				output.append(1+"/"+N);
				if(i!=N)
					output.append(" ");
			}
			
			System.out.println("#"+testcase+ " "+output.toString());
		}

	}

}

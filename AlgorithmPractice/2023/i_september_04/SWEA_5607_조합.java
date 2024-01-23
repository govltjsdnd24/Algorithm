package i_september_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5607_조합 {
	static int N,R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int T= Integer.parseInt(st.nextToken());
		
		for(int testcase=1; testcase<=T;testcase++) {
			st= new StringTokenizer(br.readLine());
			N= Integer.parseInt(st.nextToken());
			R= Integer.parseInt(st.nextToken());
			
			if(R==0) {
				System.out.println("#"+testcase+" "+0);
				continue;
			}
			if(R==1) {
				System.out.println("#"+testcase+" "+N);
				continue;
			}
			
			long combinations=0;
			long n=1;
			for (int i = 1; i <=N; i++) {
				n*=i;
			}
			long m=1;
			for (int i = 1; i <=N-R; i++) {
				m*=i;
			}
			long l=1;
			for (int i = 1; i <=R; i++) {
				l*=i;
				
			}
			
			combinations=(n/(m*l))%1234567891;
			
			System.out.println("#"+testcase+" "+combinations);
		}
	}

}

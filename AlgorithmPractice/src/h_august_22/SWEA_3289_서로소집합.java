package h_august_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3289_서로소집합 {
	
	static int N,M;
	static int parents[];

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		
		int T=Integer.parseInt(st.nextToken());
		
		for(int testcase=1;testcase<=T;testcase++) {
			StringBuilder sb= new StringBuilder();
			
			st= new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			
			make();
			
			for (int i = 0; i < M; i++) {
				st= new StringTokenizer(br.readLine());
				int operation=Integer.parseInt(st.nextToken());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				
				if(operation==0) {
					union(a,b,1);
				}
				else {
					sb.append(union(a,b,0));
				}
				
			}
			System.out.println("#"+ testcase+ " "+ sb.toString());
		}

	}
	
	private static int find(int a) {
		if(parents[a]==a)
			return a;
		return parents[a]=find(parents[a]);
	}
	
	private static void make() {
		parents=new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i]=i;
		}
	}
	
	private static int union(int a,int b,int check) {
		if(a==b)
			return 1;
		
		int aRoot=find(a);
		int bRoot=find(b);
		
		if(aRoot==bRoot)
			return 1;
		
		if(check==1)
			parents[bRoot]=aRoot;
		return 0;
	}

}

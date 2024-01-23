package g_july_31;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_2805 {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int []dr= {1,-1,0,0};
	static int []dc= {0,0,1,-1};
	static int[][] farm;
	static int sum;
	static Set<String> =  HashSet<String>();

	public static void main(String[] args) throws IOException {

		int test_case,t;
		int N;
		int i,j;
		
		
		String input=br.readLine();
		StringTokenizer stk=new StringTokenizer(input);
		t=Integer.parseInt(stk.nextToken());
		
		for(test_case=1;test_case<=t;test_case++) {
		
			input=br.readLine();
			stk=new StringTokenizer(input);
			N=Integer.parseInt(stk.nextToken());
			
			farm= new int[N][N];
			
			
			for(i=0;i<N;i++) {
				input=br.readLine();
				for(j=0;j<N;j++) {
					farm[i][j]=(int)input.charAt(j)-'0';
					System.out.println(farm[i][j]);
				}
			}
			
			sum=0;			
			recursion(0,N/2,N/2);
//			for(i=0;i<N;i++) {
//				if(i<=N/2) {
//					for(j=N/2-i;j<=N/2+i;j++) {
//						sum+=farm[i][j];
//					}
//				}
//				else {
//					
//				}
//			}
		}

		

	}
	
	
	public static void recursion(int idx,int sr,int sc) {
		if(h==farm.length)
			return;
		
		sum+=farm[start][h];
		if(h<=N/2)
			recursion
		
	}

}

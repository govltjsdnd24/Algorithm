package i_september_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1535_안녕 {
	static int N;
	static int[] L;
	static int[] J;
	static int W=100;
	static int joy=0;
	static int[][] K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());

		N=Integer.parseInt(st.nextToken());
		L=new int[N+1];
		J=new int[N+1];

		st= new StringTokenizer(br.readLine());
		for (int j = 1; j <= N; j++) {
			L[j]=Integer.parseInt(st.nextToken());
		}
		st= new StringTokenizer(br.readLine());
		for (int j = 1; j <= N; j++) {
			J[j]=Integer.parseInt(st.nextToken());
		}
		
		K=new int[N+1][W+1];
		
		for (int i = 0; i <= N; i++) {
			K[i][0]=0;
		}
		for (int i = 0; i <= W; i++) {
			K[0][i]=0;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int w = 1; w <= W; w++) {
				if(L[i]>w)
					K[i][w]=K[i-1][w];
				else 
					K[i][w]=Math.max(J[i]+K[i-1][w-L[i]], K[i-1][w]);
			}
		}
		
		for(int i=0;i<K.length;i++) {
			for(int j=0;j<W;j++) {
				System.out.print(K[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println(K[N][W-1]);
	}

}

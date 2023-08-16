package h_august_16;

import java.io.*;
import java.util.StringTokenizer;

public class BAEKJOON_11660_구간합구하기5 {
	
	static int N,M;
	static int[][]numbers;
	static int[][]collectives;
	static StringBuilder output=new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());

		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		numbers=new int[N][N];
		collectives=new int[N][N];
		int i,j;
		for (i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			for (j = 0; j < N; j++) {
				numbers[i][j]=Integer.parseInt(st.nextToken());
				
				collectives[i][j]=numbers[i][j];
				if(!(i==0 && j==0)) {
					if(j!=0)
						collectives[i][j]+=collectives[i][j-1];
					if(i!=0)
						collectives[i][j]+=collectives[i-1][j];
					
					if(i!=0 && j!=0)
						collectives[i][j]-=collectives[i-1][j-1];
				}
			}
		}
		
		for(i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			output.append(calculateRange(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1));
			if(i!=M-1)
				output.append("\n");
		}
			
		
		System.out.print(output);
	}
	
	private static long calculateRange(int y1,int x1,int y2,int x2) {
		long stockpile=collectives[y2][x2];
		if(y1==y2 &&x1==x2)
			return numbers[y2][x2];
		
		if(!(y1==0 && x1==0)) {
			if(x1!=0)
				stockpile-=collectives[y2][x1-1];
			if(y1!=0)
				stockpile-=collectives[y1-1][x2];
			
			if(x1!=0 && y1!=0)
				stockpile+=collectives[y1-1][x1-1];
		}
		return stockpile;
	}

}

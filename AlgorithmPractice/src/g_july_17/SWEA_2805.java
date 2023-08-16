package g_july_17;

import java.util.Scanner;

public class SWEA_2805 {
	static int []dr= {1,-1,0,0};
	static int []dc= {0,0,1,-1};
	static int [][]lNumbers;
	static boolean[][] visited;
	static int N;
	static int sum=0;
	
	public static void main(String[] args) {
		int test_case,t;
		int i,j;
		String input_line;
		int sr;
		int cLimit;
		
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		
		for(test_case=1;test_case<=t;test_case++) {
			N=sc.nextInt();
			lNumbers= new int[N][N];
			visited=new boolean[N][N];
			sr=N/2+1;
			
			//input numbers
			for(i=0;i<N;i++) {
				input_line=sc.next();
				for(j=0;j<N;j++) {
					lNumbers[i][j]=(int)input_line.charAt(j);
				}
			}
			
			if(N==1) {
				System.out.println("#"+test_case+" "+lNumbers[0][0]);
				continue;
			}
			
			cLimit=0;
			for(i=1;i<N-1;i++) {
				if(i<=N/2+1)
					cLimit=i*2-1;
				else
					cLimit=i/2+1;
				dfs(sr,i,cLimit);
			}			
		}
	}
	
	public static void dfs(int r,int c,int cLimit) {
		if(visited[r][c]==true) return;
		if( c<-cLimit || c>=cLimit)
		if(r<0 || r>=N) return;
		
		visited[r][c]=true;
		
        for(int i = 0; i < dr.length; ++i){
            int nr = r + dr[i];
            int nc = c + dc[i];
            dfs(nr, nc,cLimit);
        }
	}
}



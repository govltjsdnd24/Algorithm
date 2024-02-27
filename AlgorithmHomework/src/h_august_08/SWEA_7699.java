package h_august_08;

import java.util.*;

public class SWEA_7699 {
	static int []dr= {1,-1,0,0};
	static int []dc= {0,0,1,-1};
	static char[][] tSites;
	static Set<Character> visited;
	static int R,C;
	static int maxStep;

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int test_case,t;
		int i,j;
		
		t=scan.nextInt();
		for (test_case = 1; test_case <= t; test_case++) {
			R=scan.nextInt()+1;
			C=scan.nextInt()+1;
			maxStep=Integer.MIN_VALUE;
			
			String line=new String();
			tSites=new char[R][C];
			visited=new HashSet<Character>();
			
			for (i = 1; i < R; i++) {
				line=scan.next();
				for (j = 1; j < C; j++)
					tSites[i][j]=line.charAt(j-1);
			}
			
			visited.add(tSites[1][1]);
			dfs(1,1,1);
			
			System.out.println("#"+test_case+" "+maxStep);
		}
		scan.close();

	}
	
	public static void dfs(int r,int c, int step) {
		//basis part
		
		
		//inductive part
		for (int i = 0; i < 4; i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			
			if(nr>=1 && nr<R && nc>=1 && nc<C && !visited.contains(tSites[nr][nc])) {
				visited.add(tSites[nr][nc]);
				dfs(nr,nc,step+1);
				visited.remove(tSites[nr][nc]);
			}
		}
		maxStep=Math.max(maxStep, step);
		
	}

}

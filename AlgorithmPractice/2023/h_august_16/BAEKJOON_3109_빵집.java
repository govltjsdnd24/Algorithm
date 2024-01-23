package h_august_16;

import java.io.*;
import java.util.StringTokenizer;

public class BAEKJOON_3109_빵집 {
	
	static char[][] map;
	static boolean[] visited;
	static int pathCount=0;
	static int R,C;
	
	static int dr[]= {-1,0,1};
	static int sr=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		map=new char[R][C];
		
		String line;
		for(int i=0;i<R;i++) {
			line=br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j]=line.charAt(j);
			}
		}
		
		for(int r=0;r<R;r++) {
			visited=new boolean[R];
			findPaths(r,0,r);
		}
		System.out.println(pathCount);
	}
	
	public static void findPaths(int r, int c,int sr) {
		
		if(r>=R || r<0 || c>=C || map[r][c]=='x' || visited[sr])
			return;
		
		if(c==C-1) {
			pathCount++;
			visited[sr]=true;
			
			return;
		}
		map[r][c]='x';
		for(int i=0;i<3;i++) {
			findPaths(r+dr[i],c+1,sr);
		}
	}
}

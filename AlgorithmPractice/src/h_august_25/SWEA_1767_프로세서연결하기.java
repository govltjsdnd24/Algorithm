package h_august_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Processor{
	int r,c,dir;
	Processor(int r, int c){
		this.r=r; this.c=c; this.dir=0;
	}
	@Override
	public String toString() {
		return "Processor [r=" + r + ", c=" + c + "]";
	}
}

public class SWEA_1767_프로세서연결하기 {
	static int N;
	static int[][]grid;
	static boolean[][]visited;
	static ArrayList<Processor>processList;
	
	static int[] dr= {1,-1,0,0}; //down, up, right,left
	static int[] dc= {0,0,1,-1};
	
	static int output;
	static int maxConnected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int T=Integer.parseInt(st.nextToken());
		for (int testcase = 1; testcase <= T; testcase++) {
			st= new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			
			grid=new int [N][N];
			visited=new boolean[N][N];
			processList=new ArrayList<Processor>();
			output=Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				st= new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j]=Integer.parseInt(st.nextToken());
					if(grid[i][j]==1 && i>0 && j>0 && i<N-1 && j< N-1)
						processList.add(new Processor(i,j));
				}
			}
	
			maxConnected=0;
			dfs(0,0,0);
			System.out.println("#"+testcase+" "+output);
		}
	}
	
	static void dfs(int index,int count,int connected) {
		//basis
		if(index==processList.size()) {
	
			if(connected>maxConnected) {
				maxConnected=connected;
				output=count;
			}
			else if(connected==maxConnected)
				output=Math.min(count,output);
			
			return;
		}
		
		//inductive
		Processor current=processList.get(index);
		int r=current.r; int c= current.c;
		
		for (int i = 0; i < 4; i++) {
			int currCount=0;
			boolean isConnectable=true;
			
			int nr=r+dr[i];int nc=c+dc[i];
			while(nr>=0 && nr<N && nc>=0 && nc<N) {
				if(grid[nr][nc]==1 || visited[nr][nc]) {
					backtrack(r,c,nr,nc);
					isConnectable=false;
					currCount=0;
					break;
				}
				visited[nr][nc]=true;
				currCount++;
				nr+=dr[i];
				nc+=dc[i];
			}
			
			dfs(index+1,count+currCount,isConnectable?connected+1:connected);
			
			if(isConnectable) {
				backtrack(r,c,nr,nc);
			}
			
		}
	}
	
	static void backtrack(int r,int c,int nr,int nc) {
		int sr=Math.min(r,nr);
		int er=Math.max(r, nr);
		int sc=Math.min(c,nc);
		int ec=Math.max(c,nc);
		
		for (int i = sr; i <= er; i++) {
			for (int j = sc; j <= ec; j++) {
				if((i>=0 && i<N && j>=0 && j<N) && !(nr==i && nc==j))
					visited[i][j]=false;
			}
		}
	}
	
	static void print(int[][]grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(visited[i][j])
					System.out.print(2);
				else 
					System.out.print(grid[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

}

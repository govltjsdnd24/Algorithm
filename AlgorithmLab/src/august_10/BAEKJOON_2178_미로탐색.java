package august_10;

import java.io.*;
import java.util.*;

class Cell{
	private int r,c;
	Cell(int r,int c){
		this.r=r;
		this.c=c;
	}
	public int getR() {
		return r;
	}
	public int getC() {
		return c;
	}
}


public class BAEKJOON_2178_미로탐색 {
	static int[][] maze;
	static boolean[][] visited;
	static int N,M;
	
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		maze=new int[N][M];
		visited=new boolean[N][M];
		
		int i,j;
		for(i=0;i<N;i++) {
			String str=br.readLine();
			for(j=0;j<M;j++) {
				maze[i][j]=str.charAt(j)-'0';
			}
		}
		
		System.out.println(bfs());
		
	}
	
	static int bfs() {
		Queue<Cell> queue=new LinkedList<Cell>();
		queue.offer(new Cell(0,0));
	
		int r,c,i;
		int nr,nc;
		
		int breadth=1;
		while(!queue.isEmpty()) {
			int size=queue.size();
			while(--size>=0) {
				Cell cell= queue.poll();
				r=cell.getR();
				c=cell.getC();
				
				if(r==N-1 && c==M-1) {
					return breadth;
				}
				
				for(i=0;i<4;i++) {
					nr=r+dr[i];
					nc=c+dc[i];
					if(nr>=0 &&nr<N && nc>=0 && nc<M && maze[nr][nc]==1 && !visited[nr][nc]) {
						visited[nr][nc]=true;
						queue.offer(new Cell(nr,nc));
					}
				}
			}
			breadth++;
		}
		return breadth;
	}

}

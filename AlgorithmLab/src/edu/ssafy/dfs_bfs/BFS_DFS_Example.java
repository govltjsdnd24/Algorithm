package edu.ssafy.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_DFS_Example {
	static int [][] map;
	static int N=3;
	static int[] dr= {0,1,0,-1};
	static int[] dc= {1,0,-1,0};
	public static void main(String[] args) {
		map=new int [N][N];
		//print(map);
//		dfs(0,0,1,1);
//		print(map);
//		System.out.println(cnt);
//		System.out.println(minDistance);
		bfs();
		System.out.println();
	}
	
	static int cnt=1,minDistance=Integer.MAX_VALUE;
	private static void dfs(int r,int c, int current,int step) {
		//basis part
		if(r==N-1&&c==N-1) {
			map[r][c]=current;
			cnt++;
			minDistance= Math.min(minDistance, step);
			return;
		}
		//inductive part
		for (int i = 0; i < 4; i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			if(nr>=0&&nr<N&&nc>=0&&nc<N && map[nr][nc]==0) {
				map[r][c]=current;
				dfs(nr,nc,current+1,step+1);	
				map[r][c]=0;
			}
		}
		
	}
	
	static class Point{
		int r,c,cnt;
		Point(int r,int c,int cnt){
			this.r=r;
			this.c=c;
			this.cnt=cnt;
		}
	}
	
	public static void bfs() {
		//0,0 시작점
		// N-1,N-1 도착점
		Queue <Point>Q= new LinkedList();
		Q.add(new Point(0,0,0));
		map[0][0]=cnt++;
		
		while(!Q.isEmpty()) {
			int level=1;
			int size=Q.size();
			for (int step = 0; step <size; step++) {
				level++;
				Point p = Q.poll();
				//도착했을 때
				
				if(p.r==3&&p.c==3) {
					print(map);
					System.out.println("0,0 to 3,3 cnt:"+ cnt);
					return;
				}
				
				for (int i = 0; i < 4; i++) {
					int nr = p.r+dr[i];
					int nc = p.c+dc[i];
					if(nr>=0&&nr<N&&nc>=0&&nc<N && map[nr][nc]==0) {
						Q.add(new Point(nr,nc,p.cnt+1));
					}
				}
			}
		}
		
	}
	
	private static void print(int[][] map) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(map[r][c]+" ");
			}
			System.out.println();
		}
	}

}

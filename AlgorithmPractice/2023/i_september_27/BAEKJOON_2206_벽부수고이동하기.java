package i_september_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Tile{
	private int r, c,steps;
	private int broke;
	
	public Tile(int r, int c, int broke) {
		this.r = r;
		this.c = c;
		this.broke=broke;
	}

	public int getR() {
		return r;
	}
	public int getC() {
		return c;
	}
	public int getBroke() {
		return broke;
	}
	@Override
	public String toString() {
		return "Tile [r=" + r + ", c=" + c + ", steps=" + steps + "]";
	}
}

public class BAEKJOON_2206_벽부수고이동하기 {

	static int[][] map;
	static int N,M;
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];

		for (int i = 0; i < N; i++) {
			String str=br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}
		
		System.out.println(break_walls());
	}

	private static int break_walls() {
		Queue<Tile>queue=new ArrayDeque<Tile>();
		queue.add(new Tile(0,0,0));
		
		boolean[][][] isVisited=new boolean[N][M][2];
		isVisited[0][0][0]=true;
		
		Tile current;
		int breadth=0;
		while(!queue.isEmpty()) {
			int size=queue.size();
			while(--size>=0) {
				current=queue.poll();
				if(current.getR()==N-1 && current.getC()==M-1) {
					return breadth;
					//return(current.getSteps());
				}
				
				for (int i = 0; i < 4; i++) {
					int nr=current.getR()+dr[i];
					int nc=current.getC()+dc[i];
					
					if(nr<N && nr>=0 && nc<M && nc>=0) {
						if(!isVisited[nr][nc][0]) {
							if(map[nr][nc]==0) {
								queue.add(new Tile(nr,nc,current.getBroke()));
								isVisited[nr][nc][0]=true;
							}
						}
						if(!isVisited[nr][nc][1] && current.getBroke()==0) {
							if(map[nr][nc]==1) {
								queue.add(new Tile(nr,nc,1));
								isVisited[nr][nc][1]=true;
							}
						}
					}
				}
			}
			breadth++;
		}
		return -1;
		
	}

}

package c_march_10;

import java.io.*;
import java.util.*;

class Square{
	int x1,y1;
	int x2,y2;
	
	public Square(int x1,int y1,int x2,int y2) {
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
	}
}

class Tile{
	int x,y;
	
	public Tile(int x,int y) {
		this.x=x; this.y=y;
	}
}

public class BAEKJOON_2583_영역구하기 {

	static int[]dr= {1,0,-1,0};
	static int[]dc= {0,1,0,-1};
	
	static int M,N;
	static boolean[][] matrix;
	static boolean[][] visited;
	static int count;
	static List<Integer>counts;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		int i,j,k;
		Square[] squares=new Square[K];
		matrix=new boolean[M][N];
		visited=new boolean[M][N];
		count=1;
		counts=new ArrayList<Integer>();
		
		for(k=0;k<K;k++) {
			st=new StringTokenizer(br.readLine());
			squares[k]=new Square(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		
		//mark squares
		for(k=0;k<K;k++) {
			for(i=squares[k].y1;i<squares[k].y2;i++) {
				for(j=squares[k].x1;j<squares[k].x2;j++) {
					matrix[i][j]=true;
				}
			}
		}
		
		//bfs
		for(i=0;i<M;i++) {
			for(j=0;j<N;j++) {
				if(!matrix[i][j]&&!visited[i][j]) {
					bfs(i,j);
					counts.add(count);
					count=1;
				}
			}
		}
		
		Collections.sort(counts);
		
		System.out.println(counts.size());
		for(int n=0;n<counts.size();n++) {
			System.out.print(counts.get(n));
			System.out.print(n<counts.size()-1?" ":"");
		}
		

	}
	
	static void bfs(int r,int c) {
		Queue<Tile>queue=new ArrayDeque<Tile>();
		queue.add(new Tile(r,c));
		visited[r][c]=true;
		
		while(!queue.isEmpty()) {
			Tile tile=queue.poll();
			
			for(int n=0;n<4;n++) {
				int nr=tile.x+dr[n];
				int nc=tile.y+dc[n];
				if(nr>=0&&nc>=0&&nr<M&&nc<N&&!matrix[nr][nc]&&!visited[nr][nc]) {
					queue.add(new Tile(nr,nc));
					visited[nr][nc]=true;
					count++;
				}
			}
		}
		
	}

	static void print() {
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(matrix[i][j]?1:0);
			}
			System.out.println();
		}
	}
	
}

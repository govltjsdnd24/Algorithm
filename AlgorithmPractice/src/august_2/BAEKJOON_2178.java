package august_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEKJOON_2178 {

	static int[] dr= {1,0,-1,0};
	static int[] dc= {0,1,0,-1};
	
	static boolean[][] visited;
	static int[][]A;
	static int N,M;
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();
		M=scan.nextInt();
		A= new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String line=scan.next();
			for(int j=0;j<M;j++) {
				A[i][j]=line.charAt(j)-'0';
			}
		}
		
		BFS(0,0);
		System.out.println(A[N-1][M-1]);
	}
	
	public static void BFS(int i, int j) {
		Queue<int[]>queue= new LinkedList<>();
		queue.offer(new int[] {i,j});
		while(!queue.isEmpty()) {
			int now[] = queue.poll();
			visited[i][j]=true;
			for(int k=0;k<4;k++) { //상하좌우로 탐색
				int y= now[1] +dr[k];
				int x=now[0]+dc[k];
				if(x>= 0 &&y>=0 && x<N && y<M) { //배열을 넘어가면
					if(A[x][y]!=0&&!visited[x][y]) { //0이여서 갈 수 없거나
						//이제 갈 수 있는곳이다.
						visited[x][y]=true;
						A[x][y]= A[now[0]][now[1]]+1; //핵심
						queue.add(new int[] {x,y});
					}
				}
				
			}
		}
	}
	

}

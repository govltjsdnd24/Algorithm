package h_august_09;

import java.util.*;

class Tomato{
	private int n,m;
	public Tomato(int n,int m) {
		 this.n=n; this.m=m;
	}

	public int getN() {
		return n;
	}
	public int getM() {
		return m;
	}
}

public class BAEKJOON_7576_토마토 {
	static int M,N;
	static int[][] tomatoes;
	static boolean[][] visited;
	
	static int[] dm= {1,-1,0,0};
	static int[] dn= {0,0,1,-1};
	static Queue<Tomato> queue;
	
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		M=scan.nextInt();
		N=scan.nextInt();
		
		int i,j;
		tomatoes=new int[N][M];
		visited=new boolean[N][M];
		
		for (i = 0; i < N; i++) 
			for (j = 0; j < M; j++)
				tomatoes[i][j]=scan.nextInt();
		
		queue= new LinkedList<Tomato>();
		
		for (i = 0; i < N; i++) {
			for (j = 0; j < M; j++) {
				if(tomatoes[i][j]==1 && !visited[i][j])
					queue.offer(new Tomato(i,j));
			}
		}
		
		int counter=bfs();
		
		for(i=0;i<N;i++) 
			for(j=0;j<M;j++) 
				if (tomatoes[i][j]==0) {
					counter=-1;
					break;
				}
		
		System.out.println(counter);
		scan.close();
	}
	
	private static int bfs() {
		
		Tomato tomato;
		int n,m,i,nn,nm;
		int counter=0;
		while(!queue.isEmpty()) {
			int size=queue.size();
			
			while(--size>=0) {
				tomato=queue.poll();
				n=tomato.getN();
				m=tomato.getM();
				
				for(i=0;i<4;i++) {
					nn=n+dn[i];
					nm=m+dm[i];
					if(nm>=0 && nm<M && nn>=0 && nn<N && tomatoes[nn][nm]==0 && !visited[nn][nm]) {
						tomatoes[nn][nm]=1;
						queue.offer(new Tomato(nn,nm));
						visited[nn][nm]=true;
					}
				}
				
			}
			
			counter++;
			
		}
		return(counter-1);
	}

}

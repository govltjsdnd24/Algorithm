package h_august_09;

import java.util.*;

class HTomato extends Tomato{
	private int h,n,m;
	public HTomato(int h,int n,int m) {
		this.h=h; this.n=n; this.m=m;
	}
	public int getH() {
		return h;
	}
	public int getN() {
		return n;
	}
	public int getM() {
		return m;
	}
}

public class BAEKJOON_7569_토마토 {
	static int M,N,H;
	static int[][][] tomatoes;
	
	static int[] dm= {1,-1,0,0,0,0};
	static int[] dn= {0,0,1,-1,0,0};
	static int[] dh= {0,0,0,0,1,-1};
	
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		H=scan.nextInt();
		N=scan.nextInt();
		H=scan.nextInt();
		
		int i,j,k;
		tomatoes=new int[H][N][M];
		
		for (i = 0; i < H; i++) 
			for (j = 0; j < N; j++)
				for(k = 0 ; j < M; k++)
					tomatoes[i][j][k]=scan.nextInt();
		
		while(true) {
			for (i = 0; i < H; i++) 
				for (j = 0; j < N; j++)
					for(k = 0 ; j < M; k++)
						if(bfs(i,j,k)==false)
							break;
			
		}
	}
	
	private static boolean bfs(int height,int length,int width) {
		Queue<Tomato> queue= new LinkedList<Tomato>();
		queue.offer(new Tomato(height,length,width));
		
		Tomato tomato;
		int h,n,m;
		while(!queue.isEmpty()) {
			tomato=queue.poll();
			h=tomato.getH();
			n=tomato.getN();
			m=tomato.getM();
			
		}
	}

}

package h_august_08;

import java.util.*;

//class Cabbage{
//	private int x,y;
//	
//	public Cabbage(int x,int y) {
//		this.x=x;
//		this.y=y;
//	}
//
//	public int getX() {return x;}
//	public void setX(int x) {this.x = x;}
//	public int getY() {return y;}
//	public void setY(int y) {this.y = y;}
//}

public class BAEKJOON_1012 {
	
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	static int[][] field;

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int T,M,N,K;
		int i,j;
		int x,y;
		
		T=scan.nextInt();
		for(int test_case=1;test_case<=T;test_case++) {
			M=scan.nextInt();
			N=scan.nextInt();
			K=scan.nextInt();
			
			field=new int[N][M];
			//Arrays.fill(field, 0);
			
//			Cabbage[] cabbages=new Cabbage[K];
//			for (i = 0; i < K; i++) {
//				cabbages[i]=new Cabbage(scan.nextInt(),scan.nextInt());
//			}
			
			for (i = 0; i < K;i ++) {
				x=scan.nextInt();
				y=scan.nextInt();
				field[y][x]=1;
			}
			
			for(i=0;i<N;i++) {
				for(j=0;j<M;j++)
					System.out.print(field[i][j]);
				System.out.println();
			}	
			
			System.out.println();
		}
		
	}
	
	public void bfs(int x,int y,int counter) {
		Queue <>
	}

}

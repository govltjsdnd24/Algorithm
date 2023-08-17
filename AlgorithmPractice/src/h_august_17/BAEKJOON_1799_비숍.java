package h_august_17;

import java.util.Scanner;

class Block{
	private int r,c;
	Block(int r,int c){
		this.r=r; this.c=c;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	
}

public class BAEKJOON_1799_비숍 {

	static int [][] board;
	static int N;
	static boolean[][]placed;
	static int counter;
	
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		N=scan.nextInt();
		
		board=new int[N][N];
		int i,j;
		for(i=0;i<N;i++)
			for(j=0;j<N;j++) {
				board[i][j]=scan.nextInt();
			}
		
		for(i=0;i<N;i++)
			for(j=0;j<N;j++) {
				counter=0;
				placed=new boolean[N][N];
				bishopPlace(i,j);
			}

	}
	
	static void bishopPlace(int r,int c) {
		if(!isAvailable(r,c)) return;
		
		if(r==N-1 && c==N-1) {
			System.out.println(counter);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i>=0 && i<N && j>=0 && j<N && board[r][c]==1 && !placed[r][c]) {
					placed[i][j]=true;
					counter++;
					bishopPlace(i,j);
					placed[i][j]=false;
					counter--;
				}
			}
		}
	}
	
	static boolean isAvailable(int row,int column) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(Math.abs(row-column)==Math.abs(i-j))
					return false;
			}
		}
		return true;
	}

}

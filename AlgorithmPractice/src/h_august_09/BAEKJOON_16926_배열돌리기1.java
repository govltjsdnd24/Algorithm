package h_august_09;

import java.util.*;

public class BAEKJOON_16926_배열돌리기1 {

	static int N,M;
	static int[][]grid;
	static int[][]temp;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N=scan.nextInt();
		M=scan.nextInt();
		int R=scan.nextInt();
		grid=new int[N][M];
		temp=new int[N][M];
		
		int i,j;
		for(i=0;i<N;i++) 
			for(j=0;j<M;j++) 
				grid[i][j]=scan.nextInt();
			
		rotateCounterClockwise(R);
		
		for(i=0;i<temp.length;i++) {
			for(j=0;j<temp[0].length;j++) {
				System.out.print(temp[i][j]);
				if(j!=temp[0].length-1)
					System.out.print(" ");
			}
			System.out.println();
		}
		
	}
	
	
	public static void rotateCounterClockwise(int times) {	
		int i,j,k,l;
		
		for(i=0;i<times;i++) {
			//repeat for half time
			int xLimit=M; int yLimit=N;
			for(j=0;j<M/2;j++) {
				for(k=j+1;k<xLimit;k++) {
					temp[j][k-1]=grid[j][k];
				}
				for(k=j+1;k<yLimit;k++) {
					temp[k-1][xLimit-1]=grid[k][xLimit-1];
				}
				for(k=xLimit-1;k>j;k--) {
					temp[yLimit-1][k]=grid[yLimit-1][k-1];
				}
				for(k=yLimit-1;k>j;k--) {
					temp[k][j]=grid[k-1][j];
				}	
				xLimit--;yLimit--;
			}
			for(j=0;j<M;j++)
				for(k=0;k<N;k++)
					grid[k][j]=temp[k][j];
		}
		
	}
	

}

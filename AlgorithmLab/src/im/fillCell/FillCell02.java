package im.fillCell;

import java.util.Scanner;

public class FillCell02 {
	
	public static void main(String[] args) {
		int N;
		Scanner sc= new Scanner(System.in);
		N=sc.nextInt();
		
		int[][]grid= new int[N][N];
		int r=sc.nextInt();
		int c=sc.nextInt();
		grid[r][c]=1;
		
				
		int[]dr= {-1,1,0,0};
		int[]dc= {0,0,-1,1};
		
		//델타 방식
		for(int d=0;d<4;d++) {
			int nr=r+dr[d];
			int nc=c+dc[d];
			grid[r][c]=1;
			
		}
		
	}

}

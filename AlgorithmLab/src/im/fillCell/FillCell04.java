package im.fillCell;

import java.util.Scanner;

/*
 * 경계선 체크 가능?
 */

public class FillCell04 {

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
			//check boundary
			if(nr>=0&&nr<N&&nc>=0&&nc<N) {
				grid[nr][nc]=1;
			}
			grid[r][c]=1;
			
		}
		 for(int a=0;a<grid.length;a++) {
			 for(int b=0;b<grid[a].length;b++) {
				 System.out.print(grid[a][b]+ " ");
			 }
			 System.out.println();
		 }
		

	}

}

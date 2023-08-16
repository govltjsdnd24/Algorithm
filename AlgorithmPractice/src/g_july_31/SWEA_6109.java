package g_july_31;

import java.util.Scanner;

public class SWEA_6109 {
	
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int test_case,t;
		int N,StI;
		String S;
		int sr,sc,k;
		int i,j;
		int r,c;
		int prod;
		
		t=scan.nextInt();
		for(test_case=1;test_case<=t;test_case++) {
			N=scan.nextInt();
			S=scan.next();
			int grid[][]=new int[N][N];
			
			for(i=0;i<N;i++)
				for(j=0;j<N;j++)
					grid[i][j]=scan.nextInt();
			
			switch(S) {
			case("up"):
				StI=0; break;
			case("down"):
				StI=1; break;
			case("left"):
				StI=2; break;
			case("right"):
				StI=3; break;
			}
			
			for(sr=0;sr<N;sr++) {
				for(sc=0;sc<N;sc++) {
					prod=1;
					while(grid[sr][sc]!=0) {
						r=sr+dr[StI]*prod;
						c=sc+dc[StI]*prod;
						//check if cursor is out of bounds
						if(r<0 || r>=N || c<0 || c>=N )
							break;
						//if it's empty space
						else if(grid[r][c]==0) {
							prod++;
							continue;
						}
						
						if(grid[sr][sc]==grid[r][c]) {
							grid
						}
					}
				}
			}
			
			
			System.out.println("#"+test_case+" "+output);
		}

	}

}

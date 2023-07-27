package july_19;

import java.util.Scanner;

public class Solution {
	int []dr= {1,-1,0,0,1,1,-1,-1};
	int []dc= {0,0,1,-1,-1,1,-1,1};
	
	boolean check8Way(int i,int j,char[][]grid,int max) {
		int k;
		int r,c;
		boolean nearGreen=false;
		
		//if we can build on the selected tile
		if(grid[i][j]=='B') {
			for(k=0;k<8;k++) {
				r=i+dr[k];
				c=j+dc[k];
				if(r<max && r>=0 && c<max && c>=0)
					if(grid[r][c]=='G') {
						//System.out.println(r+":"+c);
						nearGreen=true;
						break;
					}
			}
		}
		if(nearGreen)
			System.out.println(i+" : "+j);
		return nearGreen;
	}
	
	int searchHV(int sr,int sc, char[][] grid, int max) {
		int sum=0;
		int k;
		
		//check horizontally and vertically for occurrences of 'B'
		for(k=0;k<max;k++) {
			if(grid[sr][k]=='B')
				sum++;
		}
		for(k=0;k<max;k++) {
			if(grid[k][sc]=='B')
				sum++;
		}
		
		//remove duplicate value
		return sum-1;
	}
	
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int t,test_case;
		int N;
		int i,j;
		int max;
		
		Solution sol=new Solution();
		
		t=sc.nextInt();
		for(test_case=1;test_case<=t;++test_case) {
			N=sc.nextInt();
			char [][]input=new char[N][N];
			
			//read in input grid (char 2d array)
			for(i=0;i<N;i++) {
				for(j=0;j<N;j++) {
					input[i][j]=sc.next().charAt(0);
				}
			}
			
			max=0;
			//traverse
			for(i=0;i<N;i++) {
				for(j=0;j<N;j++) {
					if(sol.check8Way(i,j,input,N))
						max=Math.max(max, 2);
					else 
						max=Math.max(sol.searchHV(i,j,input,N), max);
				}
			}
			
			
			System.out.println("#"+test_case+" "+max);
		}
		
	}

}

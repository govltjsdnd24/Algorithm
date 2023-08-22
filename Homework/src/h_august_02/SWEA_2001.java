package h_august_02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SWEA_2001 {

	static int[][]grid;
	static int N,M;
	
	static int[][] combination;
	static final int DEPTH=2;
	
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int test_case,t;
		int i,j;
		
		t=scan.nextInt();
		
		for (test_case = 1; test_case <= t; test_case++) {
			N=scan.nextInt();
			M=scan.nextInt();
			
			int travelLimit=N-M+1;
			grid=new int[N][N];
			combination=new int[travelLimit][travelLimit];
			for(i=0;i<N;i++)
				for(j=0;j<N;j++)
					grid[i][j]=scan.nextInt();
			
			System.out.println("#"+test_case+" "+flyRecursion(0,0,0,travelLimit));
		}
		
		
		
	}
	
	static int flyRecursion(int index, int x,int y,int limit) {
		//
		if(index==DEPTH) {
			return grid[x][y];
		}
		
		//
		
		ArrayList<Integer> sums=new ArrayList<Integer>();
		int sum=0;
		
		for(int i=y;i<limit+y;i++) {
			for (int j = x; j < limit+x; j++) {
				if(index==DEPTH-1)
					sum+=flyRecursion(index+1,j,i,M);
				else
					sums.add(flyRecursion(index+1,j,i,M));
			}
		}
		if(index==DEPTH-1)
			return sum;
		return Collections.max(sums);
		
	}

}

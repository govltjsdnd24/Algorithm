package august_9;

import java.util.*;

public class BAEKJOON_16935_배열돌리기3 {

	static int N,M;
	static int[][]grid;
	static int[][]temp;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N=scan.nextInt();
		M=scan.nextInt();
		int R=scan.nextInt();
		int operation=scan.nextInt();
		
		switch(operation) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			rotateCounterClockwise(R);
			break;
		}
		
		

	}
	
	public static void rotateCounterClockwise(int times) {
		Stack<Integer> stack= new Stack<Integer>();
		
		if(times%2==1)
			temp=new int[M][N];
		else
			temp=new int[M][N];
				
		for(int i=0;i<times;i++) {
			//push in integers
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					stack.push(grid[j][k]);
				}
				for(int k=0;k<M;k++) {
					temp[k][j]=stack.pop();
				}
			}
			
			
		}
		
	}

}

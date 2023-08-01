package august_1;

import java.util.Scanner;

public class SWEA_5215 {
	static int [][]calScore;
	static int [][]scores;
	static int N,L;
	static int [] sel;
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int test_case,t;
		int i,j;
		
		t=scan.nextInt();
		for(test_case=1;test_case<=t;test_case++) {
			N=scan.nextInt();
			L=scan.nextInt();
			
			calScore=new int [N][2];
			sel=new int[N];
			
			for(i=0;i<N;i++) 
				for(j=0;j<2;j++) 
					calScore[i][j]=scan.nextInt();
			
			recursion(0,0,0);
			
			
		}

	}
	
	public static int recursion(int index, int calorie,int score) {
		if(calScore[index][1]+calorie>L) {
			return score;
		}
		
		for(int i=0;i<N;i++) {
				score+=calScore[i][0];
				recursion(index+1,calScore[i][1]+calorie,score);
				Math.max
		}
		
		return score;
	}

}

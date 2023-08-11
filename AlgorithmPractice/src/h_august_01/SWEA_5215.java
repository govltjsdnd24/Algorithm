package h_august_01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_5215 {
	static int [][]calScore;
	static int [][]scores;
	static int N,L,Ans;
	static int [] sel;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("햄버거다이어트.txt"));
		Scanner scan=new Scanner(System.in);
		int test_case,t;
		int i,j;
		
		t=scan.nextInt();
		for(test_case=1;test_case<=t;test_case++) {
			N=scan.nextInt();
			L=scan.nextInt();
			Ans=Integer.MIN_VALUE;
			
			calScore=new int [N][2];
			sel=new int[N];
			
			for(i=0;i<N;i++) 
				for(j=0;j<2;j++) {
					calScore[i][j]=scan.nextInt();
				}
			
			
			recursion(0,0,0);
			System.out.println("#"+test_case+" "+Ans);
			
			
		}

	}
	
	public static void recursion(int index, int sSum,int cSum) {
		//basis part
		if(cSum>L) {
			return;
		}
		if(index==N) {
			Ans = Math.max(Ans, sSum);
			return;
		}
		
		//inductive part
		
		//재료 선택 하는 경우
		recursion(index+1,sSum+calScore[index][0],sSum+calScore[index][1]);
		//재료 선택 않는 경우
		recursion(index+1,sSum,cSum);
	}

}

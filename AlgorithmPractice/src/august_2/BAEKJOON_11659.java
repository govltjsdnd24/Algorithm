package august_2;

import java.util.Scanner;

public class BAEKJOON_11659 {
	
	static int[]numbers;
	static int[] sums;
	static int[] diffs;
	static int N;

	public static void main(String[] args) {
		Scanner scan= new Scanner (System.in);
		int M;
		int i,output;
		int [][] ItJ;
		
		N=scan.nextInt();
		M=scan.nextInt();
		
		numbers=new int[N];
		ItJ= new int[M][2];
		sums=new int[N];
		diffs=new int[N];
		
		for(i=0;i<N;i++) 
			numbers[i]=scan.nextInt();
		for(i=0;i<M;i++) {
			ItJ[i][0]=scan.nextInt();
			ItJ[i][1]=scan.nextInt();
		}
		
		recursion(0);
		
		for(i=0;i<M;i++) {
			if(ItJ[i][0]-1<0)
				
			output=numbers[ItJ[i][1]]-numbers[ItJ[i][0]];
			System.out.println(output);
		}
		
		

	}
	
	static public void recursion(int index) {
		if(index==N)
			return;
		if(index>0) {
			numbers[index]=numbers[index]+numbers[index-1];
		}
		recursion(index+1);
	}
	

}

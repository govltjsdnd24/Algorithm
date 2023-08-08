package august_08;

import java.util.Scanner;

public class SWEA_7733 {
	static int N;
	static int [][] cheese;
	static int chunks;
	
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int test_case,t;
		int i,j;
		
		t=scan.nextInt();
		for (test_case  = 1; test_case <= t; test_case++) {
			N=scan.nextInt();
			for (i = 0; i < N; i++) 
				for (j = 0; j < N; j++) 
					cheese[i][j]=scan.nextInt();
		
			chunks=0;
			
			
				
			
			System.out.println("#"+test_case+" "+chunks);
		}
		
	}
}

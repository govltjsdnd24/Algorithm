package august_2;

import java.util.Scanner;

public class SWEA_1210 {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int test_case,t;
		int i,j;
		int [][]ladder=new int[100][100];
		int endR,endC;
		
		
		t=scan.nextInt();
		
		for(test_case=1;test_case<=t;test_case++) {
			
			for(i=0;i<100;i++) 
				for(j=0;j<100;j++) {
					ladder[i][j]=scan.nextInt();
					endR=j;
					endC=i;
				}
			
			
			
			
			System.out.println("#"+test_case+" "+output);
		}

	}

}

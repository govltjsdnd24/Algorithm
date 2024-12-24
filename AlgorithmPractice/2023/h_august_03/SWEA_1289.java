package h_august_03;

import java.util.Scanner;

public class SWEA_1289 {
	static int[] bits;
	static int [] fBits;

	public static void main(String[] args) {
		int test_case,t;
		Scanner scan= new Scanner(System.in);
		int i,j;
		int output;
		String line;
		
		t=scan.nextInt();
		for(test_case=1;test_case<=t;test_case++) {
			line=scan.next();
			
			bits=new int[line.length()];
			fBits=new int[line.length()];
			
			for(i=0;i<line.length();i++) {
				fBits[i]=line.charAt(i);
			}
			
			//bitRecursion(0);
			
		//	System.out.println("#"+test_case+" "+output);
		}

	}
	
//	public static bitRecursion(int index) {
//
//	}

}

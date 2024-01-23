package h_august_03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BAEKJOON_2961 {

	static int N;
	static long []fSour;
	static long []fBitter;
	static boolean []sel;
	static ArrayList<Long> output=new ArrayList<Long>();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N=scan.nextInt();
		int i,j;
		
		fSour=new long [N];
		fBitter= new long [N];
		sel= new boolean[N];
		
		for (i = 0; i < N; i++) {
			fSour[i]=scan.nextLong();
			fBitter[i]=scan.nextLong();
		}
		
		fRecursion(0);
		
		System.out.println(Collections.min(output));
	}
	
	static void fRecursion(int index) {
		if(index==N) {
			long prod=1,sum=0;
			int cnt=0;
			for (int i = 0; i < N; i++) {
				if(sel[i]) {
					prod*=fSour[i];
					sum+=fBitter[i];
					cnt++;
				}
			}
			
			if(cnt>0) {
				output.add(Math.abs(prod-sum));
			}
			return;
		}
		
		sel[index]=true;
		fRecursion(index+1);
		sel[index]=false;
		fRecursion(index+1);
	}

}

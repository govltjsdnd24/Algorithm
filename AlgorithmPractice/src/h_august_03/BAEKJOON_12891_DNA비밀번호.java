package h_august_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BAEKJOON_12891_DNA비밀번호 {
	
	static char[] defDNA= {'A','C','G','T'};
	static int[] cntDNA= new int[4];
	static String str;
	static int S,P;

	public static void main(String[] args) throws IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		String line=br.readLine();
		StringTokenizer stk=new StringTokenizer(line);
		S=Integer.parseInt(stk.nextToken());
		P=Integer.parseInt(stk.nextToken());
		
		str=br.readLine();
		
		line=br.readLine();
		stk=new StringTokenizer(line);

		for(int i=0;i<4;i++) 
			cntDNA[i]=Integer.parseInt(stk.nextToken());
		
		System.out.println(Integer.toString(dnaSolve()));
	}
	
	static int dnaSolve() {
		//initial assignment
		int count=0;
		
		for (int i = 0; i < P; i++) {
			for (int j = 0; j < 4; j++) {
				if(str.charAt(i)==defDNA[j]) 
					cntDNA[j]--;
			}
		}
		count=usedChecker(count);
		
		//repetition
		char toOmit, toAppend;
		for (int i = P; i < S; i++) {
			toOmit=str.charAt(i-P);
			toAppend=str.charAt(i);
			
			switch(toOmit) {
			case 'A':
				cntDNA[0]++; 
				break;
			case 'C':
				cntDNA[1]++; 
				break;
			case 'G':
				cntDNA[2]++; 
				break;
			case 'T':
				cntDNA[3]++; 
				break;
			}
			
			switch(toAppend) {
			case 'A':
				cntDNA[0]--; 
				break;
			case 'C':
				cntDNA[1]--; 
				break;
			case 'G':
				cntDNA[2]--; 
				break;
			case 'T':
				cntDNA[3]--; 
				break;
			}
			
			count=usedChecker(count);
		}
		
		return count;
	}
	
	static int usedChecker(int count) {
		for (int i = 0; i < 4; i++) {
//			System.out.print(cntDNA[i]+" ");
			if(cntDNA[i]>0)
				return count;
		}
//		System.out.println();
		return count+1;
	}
}

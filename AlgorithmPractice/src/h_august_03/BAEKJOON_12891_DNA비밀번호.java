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
	static int[] cntDNACheck=new int[4];
	static String str;
	static String subStr;
	static int S,P;

	public static void main(String[] args) throws IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line=br.readLine();
		StringTokenizer stk=new StringTokenizer(line);
		S=Integer.parseInt(stk.nextToken());
		P=Integer.parseInt(stk.nextToken());
		
		str=br.readLine();
		
		line=br.readLine();
		stk=new StringTokenizer(line);
		

		for(int i=0;i<4;i++) {
			cntDNA[i]=Integer.parseInt(stk.nextToken());
		}
		
		bw.write(Integer.toString(dnaSolve()));
		bw.close();
	}
	
	static int dnaSolve() {
		//initial assignment
		int count=0;
		subStr=str.substring(0,P);
		
		int temp=0;
		for (int i = 0; i < subStr.length(); i++) {
			for (int j = 0; j < defDNA.length; j++) {
				if(subStr.charAt(i)==defDNA[j] && cntDNA[j]>0) 
					cntDNA[j]--;
			}
		}
		count=usedChecker(count);
		
		//repetition
		char toOmit, toAppend;
		for (int i = subStr.length(); i < str.length(); i++) {
			toOmit=str.charAt(i-(subStr.length()));
			toAppend=str.charAt(i);
//			System.out.println("omitting :"+toOmit);
//			System.out.println(toAppend);
			switch(toOmit) {
			case 'A':
				cntDNA[0]++; break;
			case 'C':
				cntDNA[1]++; break;
			case 'G':
				cntDNA[2]++; break;
			case 'T':
				cntDNA[3]++; break;
			}
			
			switch(toAppend) {
			case 'A':
				cntDNA[0]--; break;
			case 'C':
				cntDNA[1]--; break;
			case 'G':
				cntDNA[2]--; break;
			case 'T':
				cntDNA[3]--; break;
			}
			
			count=usedChecker(count);
		}
		
		return count;
	}
	
	static int usedChecker(int count) {
		int counter=0;
		for (int i = 0; i < cntDNA.length; i++) {
			if(cntDNA[i]==0)
				counter++;
		}
		if(counter==subStr.length())
			count++;
		return count;
	}
	
	
	
	

}

package august_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BAEKJOON_12891 {
	
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
		
		int temp=0;
		for(int i=0;i<4;i++) {
			cntDNA[i]=Integer.parseInt(stk.nextToken());
			temp+=cntDNA[i];
		}
		if(temp>P) {
			System.out.println(0);
			return;
		}
		
		bw.write(Integer.toString(dnaRecursion(0,0)));
		bw.close();
	}
	
	static int dnaRecursion(int index,int count) {
		if(index==S-P+1)
			return count;
		
		if(elligChecker(index))
			count++;
		
		return(dnaRecursion(index+1,count));
	}
	
	static boolean elligChecker(int index) {
		int temp;
		if(subStr==null) {
			for(int j=index;j<index+P;j++) {
				subStr=str.substring(index,index+P);
			}
			for(int i=0;i<4;i++) {
				temp=0;
				if(cntDNA[i]>P)
					return false;
				for(int j=index;j<index+P;j++) {
					if(str.charAt(j)==defDNA[i])
						temp++;
					if(cntDNA[i]<temp)
						return false;
				}
			}
			return true;
		}
		
		switch(subStr.charAt(index-1)) {
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
		
		switch(subStr.charAt(index+P-2)) {
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
		
		
		for(int i=0;i<4;i++) {
			if(cntDNA[i]!=cntDNACheck[i])
				return false;
		}
		return true;
	}

}

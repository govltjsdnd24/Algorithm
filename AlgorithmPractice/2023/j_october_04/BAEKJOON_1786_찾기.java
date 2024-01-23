package j_october_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class BAEKJOON_1786_찾기 {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] charArray=br.readLine().toCharArray();
		char[] pattern=br.readLine().toCharArray();

		int[] table=psTable(pattern);
		System.out.println(Arrays.toString(table));
		
		int[] answers=KMP(charArray,pattern,table);
		System.out.println(answers[0]);
		System.out.println(answers[1]);
	}

	private static int[] psTable(char[] pattern) {
		int[] table=new int[pattern.length];
		int idx=0;
		
		for (int i = 0; i < table.length; i++) {
			//2이하 문자열 처리
			if(i<=1) {
				table[i]=0;
				continue;
			}
			
			while(idx>0 && pattern[i]!=pattern[idx]) {
				idx = table[idx-1];
			}
			if(pattern[i] == pattern[idx]) {
				table[i] = ++idx;  
			}
			
		}
		return table;
	}

	private static int[] KMP(char[] charArray, char[] pattern,int[] table) {
		int matches=0;
		int fullMatches=0;
		
		Loop:
		for (int i = 0; i <= charArray.length-pattern.length; i++) {
			for (int j = 0; j <= pattern.length; j++) {
				if(charArray[i+j]!=pattern[j]) {
					i=i+table[j-1];
					continue Loop;
				}
				else 
					matches++;
			}
			fullMatches++;
		}
		return new int[]{fullMatches,matches};
	}

}

package b_february_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON_1316_그룹단어체커 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine());
		
		int total=0;
		for(int tc=1;tc<=t;tc++) {
			
			boolean[]alphabets=new boolean[26];
			String str=br.readLine();
			
			char prev=str.charAt(0);
			alphabets[prev-'a']=true;
			
			int i;
			for(i=1;i<str.length();i++) {
				if(prev!=str.charAt(i) && alphabets[str.charAt(i)-'a']==false) {
					alphabets[str.charAt(i)-'a']=true;
					prev=str.charAt(i);
				}
				else if(prev!=str.charAt(i) && alphabets[str.charAt(i)-'a']==true) {
					
					break;
				}
			}
			if(i==str.length())
				total++;
			
			
		}
		System.out.println(total);
	}

}

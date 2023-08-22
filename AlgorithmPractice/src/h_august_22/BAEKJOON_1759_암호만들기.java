package h_august_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BAEKJOON_1759_암호만들기 {

	static int L,C;
	static char[] arr;
	static char[] comb;
	static ArrayList<String> strs=new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int L=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		
		arr=new char[C];
		comb=new char[L];
		st= new StringTokenizer(br.readLine());
		
		for (int i = 0; i < C; i++) {
			arr[i]=st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		
		findCombination(0,0);
		Collections.sort(strs);
		for (int i = 0; i < strs.size(); i++) {
			System.out.println(strs.get(i));
		}
		
	}
	
	static void findCombination(int oInd,int cInd) {
		if(cInd==comb.length) {
			String temp="";
			int vCount=0;
			int cCount=0;
			for (int i = 0; i < comb.length; i++) {
				switch(comb[i]) {
				case 'a': case 'e': case 'i': case 'o': case 'u':
					vCount++;
					break;
				default:
					cCount++;
					break;
				}
				temp+=comb[i];
			}
			if(cCount>=2 && vCount>=1) {
				strs.add(temp);
			}
			return;
		}
		
		for (int i = oInd; i < arr.length; i++) {
			comb[cInd]=arr[i];
			findCombination(i+1,cInd+1);
		}
	}

}

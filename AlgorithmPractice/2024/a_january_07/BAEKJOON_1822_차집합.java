package a_january_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BAEKJOON_1822_차집합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int A=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());
		Map<Integer,Boolean> mapA=new HashMap<Integer, Boolean>();
		Map<Integer,Boolean> mapB=new HashMap<Integer, Boolean>();
		int[]arrA=new int[A];
		int[]arrB=new int[B];
		StringBuilder sb= new StringBuilder();
		
		st=new StringTokenizer(br.readLine());
		for(int tc=1;tc<=A;tc++) {
			int a=Integer.parseInt(st.nextToken());
			mapA.put(a, false);
			arrA[tc-1]=a;
		}
		st=new StringTokenizer(br.readLine());
		for(int tc=1;tc<=B;tc++) {
			int b=Integer.parseInt(st.nextToken());
			mapB.put(b, false);
			arrB[tc-1]=b;
		}

		int countB=0;
		for(int tc=1;tc<=A;tc++) {
			if(mapB.get(arrA[tc-1])==null) {
				countB++;
				sb.append(arrA[tc-1]+" ");
			}
		}
		
		System.out.println(countB);
		if(!sb.isEmpty())
		System.out.println(sb);
	}

}

package h_august_14;

import java.io.*;
import java.util.*;

public class BAEKJOON_20187_종이접기 {

	static int[]folds;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int k=Integer.parseInt(st.nextToken());
		int i;
		folds=new int[(int)Math.pow(k,2)];
		
		st= new StringTokenizer(br.readLine());
		for(i=0;i<(int)Math.pow(k, 2);i++) {
			folds[i]=Integer.parseInt(st.nextToken());
		}
		
		

	}

}

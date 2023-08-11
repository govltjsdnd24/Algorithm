package h_august_11;

import java.io.*;
import java.util.*;

public class BAEKJOON_16435_스네이크버드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int L=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		int i;
		int[]fruits=new int[N];
		for(i=0;i<N;i++) {
			fruits[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(fruits);
		for(i=0;i<fruits.length;i++) {
			if(fruits[i]<=L) {
				L++;
			}
			else
				break;
		}
		System.out.println(L);

	}

}

package a_january_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BAEKJOON_2075_N번째큰수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pQueue=new PriorityQueue<Integer>(
				new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						return Integer.compare(o1, o2) * -1;
					}
		});
		
		int i,j;
		StringTokenizer st;
		for(i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(j=0;j<N;j++) {
				pQueue.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for(i=0;i<N-1;i++) {
			pQueue.poll();
		}
		System.out.println(pQueue.poll());
	}
}

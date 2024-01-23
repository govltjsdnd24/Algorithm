package i_september_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEKJOON_1158_요세푸스문제 {
	
	static int N;
	static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		StringBuilder sb= new StringBuilder();
		sb.append("<");
		josephus(sb);
		sb.append(">");
		System.out.println(sb.toString());
	}

	private static void josephus(StringBuilder sb) {
		Queue<Integer>queue=new ArrayDeque<Integer>();
		//initial assignment
		for (int i = 1; i <=N; i++) {
			queue.add(i);
		}
		
		int temp;
		for (int i = 0; i < N; i++) {
			for(int j=0;j<K-1;j++) {
				temp=queue.poll();
				queue.add(temp);
			}
			sb.append(queue.poll());
			if(i!=N-1)
				sb.append(", ");
		}

		
	}

}

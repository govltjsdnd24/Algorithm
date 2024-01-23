package i_september_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEKJOON_2164_카드2 {
	
	static Queue<Integer> queue=new ArrayDeque<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		int remaining=shuffle(queue);
		System.out.println(remaining);
	}

	private static int shuffle(Queue<Integer> queue) {
		int temp;
		while(queue.size()>1) {
			//omit
			queue.poll();
			
			//mix
			temp=queue.poll();
			queue.add(temp);
		}
		
		return queue.poll();
	}

}

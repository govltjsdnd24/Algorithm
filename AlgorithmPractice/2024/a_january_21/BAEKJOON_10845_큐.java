package a_january_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEKJOON_10845_큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		ArrayDeque<Integer>queue=new ArrayDeque<Integer>();
		int N= Integer.parseInt(br.readLine());
		StringTokenizer st;
		String command;
		
		for(int tc=1;tc<=N;tc++) {
			st=new StringTokenizer(br.readLine());
			command=st.nextToken();
			switch(command) {
			case "push":
				queue.add(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				System.out.println(queue.isEmpty()?-1:queue.poll());
				break;
			case "size":
				System.out.println(queue.size());
				break;
			case "empty":
				System.out.println(queue.isEmpty()?1:0);
				break;
			case "front":
				System.out.println(queue.isEmpty()?-1:queue.peek());
				break;
			case "back":
				System.out.println(queue.isEmpty()?-1:queue.peekLast());
			}
		}
	}

}

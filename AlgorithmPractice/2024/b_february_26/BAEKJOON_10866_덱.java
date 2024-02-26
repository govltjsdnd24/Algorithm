package b_february_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BAEKJOON_10866_덱 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		int num;
		Deque<Integer> deque=new ArrayDeque<Integer>();
		int N=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=N;tc++) {
			str=br.readLine();
			st=new StringTokenizer(str);
			String command=st.nextToken();
			
			switch(command) {
			case "push_front":
				deque.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				deque.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				System.out.println(deque.isEmpty()?-1:deque.pollFirst());
				break;
			case "pop_back":
				System.out.println(deque.isEmpty()?-1:deque.pollLast());
				break;
			case "size":
				System.out.println(deque.size());
				break;
			case "empty":
				System.out.println(deque.isEmpty()?1:0);
				break;
			case "front":
				System.out.println(deque.isEmpty()?-1:deque.peekFirst());
				break;
			case "back":
				System.out.println(deque.isEmpty()?-1:deque.peekLast());
				break;
			}
		}

	}

}

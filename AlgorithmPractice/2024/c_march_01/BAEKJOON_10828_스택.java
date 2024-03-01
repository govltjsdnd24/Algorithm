package c_march_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BAEKJOON_10828_스택 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Stack<Integer>stack=new Stack<Integer>();
		
		for(int tc=1;tc<=N;tc++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			String command=st.nextToken();
			switch(command) {
			case "push":
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				System.out.println(stack.isEmpty()?-1:stack.pop());
				break;
			case "empty":
				System.out.println(stack.isEmpty()?1:0);
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "top":
				System.out.println(stack.isEmpty()?-1:stack.peek());
				break;
			}
		}
	}

}

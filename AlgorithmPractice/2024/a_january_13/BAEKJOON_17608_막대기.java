package a_january_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BAEKJOON_17608_막대기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Stack<Integer>stack=new Stack<Integer>();
		
		for (int tc=1;tc<=N;tc++) {
			stack.push(Integer.parseInt(br.readLine()));
		}
		
		int max=0;
		int count=0;
		for (int tc=1;tc<=N;tc++) {
			int current=stack.pop();
			if(current>max) {
				count++;
				max=current;
			}
		}
		
		System.out.println(count);
	}

}

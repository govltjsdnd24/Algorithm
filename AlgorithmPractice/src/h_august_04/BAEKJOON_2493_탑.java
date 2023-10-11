package h_august_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Tower{
	int order,height;

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Tower(int order, int height) {
		super();
		this.order = order;
		this.height = height;
	}
	
}

public class BAEKJOON_2493_탑 {
	static Stack<Tower>stack=new Stack<Tower>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		int N=Integer.parseInt(st.nextToken());
		
		int[] answers= new int[N];
		int o;
		
		st= new StringTokenizer(br.readLine());
		for(int t=1;t<=N;t++) {
			int current=Integer.parseInt(st.nextToken());
			o=0;
			while(!stack.isEmpty()) {
				if(stack.peek().getHeight()<current)
					stack.pop();
				else {
					o=stack.peek().getOrder();
					break;
				}
			}
			stack.push(new Tower(t,current));
			answers[t-1]=o;
		}
		
		
		for (int i = 0; i <=answers.length-1; i++) {
			sb.append(answers[i]);
			if(i!=answers.length-1)
				sb.append(" ");
		}
		
		System.out.println(sb.toString());
	}


}

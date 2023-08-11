package h_august_04;

import java.util.Scanner;
import java.util.Stack;

public class BAEKJOON_2493 {
	static int [] lTowers;
	static Stack<Integer>stack=new Stack<Integer>();

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		
		lTowers=new int[N];
		
		for(int t=1;t<=N;t++) {
			stack.push(scan.nextInt());
		}
		int start=stack.pop();
		for(int t=N-1;t>=0;t++) {
			hitChecker(t);
		}
		
		for (int i = 0; i < lTowers.length; i++) {
			System.out.print(lTowers[i]);
			if(i!=lTowers.length-1)
				System.out.print(" ");
		}

	}
	
	public static int hitChecker(int index) {
		if(stack)
	}

}

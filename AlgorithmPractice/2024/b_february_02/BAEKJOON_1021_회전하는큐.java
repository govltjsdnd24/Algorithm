package b_february_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEKJOON_1021_회전하는큐 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N= Integer.parseInt(st.nextToken());
		int M= Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		int[]pos=new int[M];
		ArrayDeque<Integer> right=new ArrayDeque<Integer>();
		ArrayDeque<Integer> left=new ArrayDeque<Integer>();
		
		int idx;
		for(idx=0;idx<M;idx++)
			pos[idx]=Integer.parseInt(st.nextToken())-1;
		
		//initialize deque
		for(idx=0;idx<N;idx++) {
			right.add(idx);
			left.add(idx);
		}
		
		int moves=0;
		for(idx=0;idx<M;idx++) {
			int Tmoves=0;
			while(right.peek()!=pos[idx] && left.peek()!=pos[idx]) {
				moveRight(right);
				moveLeft(left);
				System.out.println(right.toString());
				Tmoves++;
			}
			if(right.peek()==pos[idx]) 
				left=right.clone();
			else if(left.peek()==pos[idx])
				right=left.clone();
			
			moves+=Tmoves;
		}
		
		System.out.println(moves);
	}
	
	static void moveRight(Deque<Integer> right) {
		int temp=right.pollLast();
		right.addFirst(temp);
	}
	
	static void moveLeft(Deque<Integer> left) {
		int temp=left.pollFirst();
		left.addLast(temp);
	}

}

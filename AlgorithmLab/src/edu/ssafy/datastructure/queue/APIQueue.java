package edu.ssafy.datastructure.queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class APIQueue {

	public static void main(String[] args) {
//		Queue<Integer> Q= new LinkedList<Integer>();
		Queue<Integer> Q= new ArrayDeque<Integer>();
		Q.offer(1);
		Q.offer(2);
		Q.offer(3);
		
		System.out.println(Q.poll());
		System.out.println(Q.poll());
		System.out.println(Q.poll());

	}

}

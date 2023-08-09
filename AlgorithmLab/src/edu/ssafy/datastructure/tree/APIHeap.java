package edu.ssafy.datastructure.tree;

import java.util.*;

public class APIHeap {

	public static void main(String[] args) {
//		PriorityQueue<Integer> heap= new PriorityQueue<Integer>(new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o2-o1;
//			}
//		});
		PriorityQueue<Integer> heap= new PriorityQueue<Integer>((o1,o2)-> {return o2-o1;});
		
		heap.offer(3);
		heap.offer(6);
		heap.offer(7);
		
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
	}

}

package edu.ssafy.datastructure.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSearch {
	
	private int [] nodes; 
	private final int size;
	private int idx=0;

	public BinaryTreeSearch(int size) {
		this.size = size;
		nodes=new int[size];
	}
	
	public void add(int data) {
		if(idx==size)return;
		nodes[idx++]=data;
	}
	
	public void dfs(int current) {
		System.out.print(nodes[current-1]+" ");
		//left
		if(current*2<=idx)
			dfs(current*2);
		//right
		if(current*2+1<=idx)
			dfs(current*2+1);
	}
	
	public void bfs(int start) {
		Queue<Integer> Q= new LinkedList();
		Q.add(start);
		while(!Q.isEmpty()) {
			int current = Q.poll();
			System.out.print(nodes[current-1]+" ");
			if(current*2<=idx) Q.add(current*2);
			if(current*2+1<=idx) Q.add(current*2+1);
		}
		
	}
	
	
	public static void main(String[] args) {
		BinaryTreeSearch bt=new BinaryTreeSearch(10);
		
		for (int i = 1; i <= bt.size; i++) {
			bt.add(i);
		}
		System.out.println(Arrays.toString(bt.nodes));
		bt.dfs(1);
		System.out.println();
		bt.bfs(1);
	}

}

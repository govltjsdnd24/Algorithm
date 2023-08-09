package edu.ssafy.bfs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class CompleteBinaryTree<T> {
	private Object[]nodes;
	private int lastIndex=0; //ä���� ������ ����� �ε���
	private final int SIZE; //�ִ� ����� ����
	
	public CompleteBinaryTree(int size) {
		this.SIZE=size;
		nodes=new Object[size+1];
		
	}
	
	public boolean isEmpty() {
		return lastIndex==0;
	}
	
	public boolean isFull() {
		return lastIndex==SIZE;
	}
	public boolean add(T data) {
		if(isFull()) return false;
		nodes[++lastIndex]=data;
		return true;
	}
	
	public void bfs() {
		if(isEmpty())return;
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(1);
		while(!queue.isEmpty()) { 
			int current = queue.poll();  
			
			System.out.println(nodes[current]);
			
			if(current*2<=lastIndex) queue.offer(current*2);
			if(current*2+1<=lastIndex) queue.offer(current*2+1);
			
		}
	}
	
	public void bfs2() {
		if(isEmpty())return;
		//
		Queue<Integer> queue = new ArrayDeque<Integer>();
		//
		queue.offer(1); //
		
		int breadth=0;
		while(!queue.isEmpty()) { //탐색 대상이 있다면
			int size=queue.size();
			while(--size>=0) {
				int current = queue.poll();  //탐색 대상 큐에서 꺼내기
				//탐색대상 방문처리
				System.out.println(nodes[current]);
				//현재 탐색대상을 통해 탐색해야할 새로운 대상을 큐에 넣기
				if(current*2<=lastIndex) queue.offer(current*2);
				if(current*2+1<=lastIndex) queue.offer(current*2+1);
			}
			System.out.println();
			System.out.println("========="+breadth+"너비 탐색 완료");
			breadth++;
		}
	}
	
	public void bfs3() {
		if(isEmpty())return;
		Queue<int[]> queue = new ArrayDeque<int[]>(); //int []: {탐색노드의 인덱스,너비}
		queue.offer(new int[] {1,0});
		
		while(!queue.isEmpty()) { 
			int [] info= queue.poll();
			int current = info[0];
			
			System.out.println(nodes[current]+"//"+info[1]);
			
			if(current*2<=lastIndex) queue.offer(new int[] {current*2, info[1]+1});
			if(current*2+1<=lastIndex) queue.offer(new int[] {current*2+1, info[1]+1});
			
		}
	}
	
	public void dfsByPreOrder(int current) { //현재 노드를 전위순회로 탐색
		//탐색 대상 방문처리
		System.out.print(nodes[current]);  
		// 현재 탐색대상을 통해 탐색해야할 새로운 대상을 재귀 호출로 탐색시키기
		if(current*2<=lastIndex) dfsByPreOrder(current*2);
		if(current*2+1<=lastIndex) dfsByPreOrder(current*2+1);
	}
	
	public void dfsByInOrder(int current) { //현재 노드를 전위순회로 탐색
		
		// 현재 탐색대상을 통해 탐색해야할 새로운 대상을 재귀 호출로 탐색시키기
		if(current*2<=lastIndex) dfsByInOrder(current*2);
		//탐색 대상 방문처리
		System.out.print(nodes[current]);  
		if(current*2+1<=lastIndex) dfsByInOrder(current*2+1);
	}
	
	public void dfsByPostOrder(int current) { //현재 노드를 전위순회로 탐색
			
			// 현재 탐색대상을 통해 탐색해야할 새로운 대상을 재귀 호출로 탐색시키기
			if(current*2<=lastIndex) dfsByPostOrder(current*2);
			if(current*2+1<=lastIndex) dfsByPostOrder(current*2+1);
			//탐색 대상 방문처리
			System.out.print(nodes[current]);  	
	}
	
	public void dfs() {
		if(isEmpty())return;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		while(!stack.isEmpty()) { 
			int current = stack.pop();  
			
			System.out.print(nodes[current]);
			if(current*2+1<=lastIndex) stack.push(current*2+1);
			if(current*2<=lastIndex) stack.push(current*2);
			
			
		}
	}

	
}

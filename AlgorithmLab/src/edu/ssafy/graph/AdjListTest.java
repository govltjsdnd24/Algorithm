package edu.ssafy.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

class Node{
	int vertext; //관계를 맺고 있는 타정점 정보
	Node next; // 연결리스트 유지를 위한 다음 노드 참조
	
	public Node(int vertext,Node next) {
		this.vertext=vertext; this.next=next;
	}

	@Override
	public String toString() {
		return "Node [vertext=" + vertext + ", next=" + next + "]";
	}
	
}

public class AdjListTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int V= scan.nextInt();
		int E= scan.nextInt();
		Node adjList[] = new Node[V];

		for (int i = 0; i < E; i++) {
			int from= scan.nextInt();
			int to= scan.nextInt();
			adjList[from]= new Node(to,adjList[from]); //첫 원소 삽입
			adjList[to]=new Node(from,adjList[to]);
			System.out.println(adjList[from]+" \n"+adjList[to]);
		}
		
//		bfs(adjList);
		dfs(adjList,new boolean[V],0);
		
		for(Node node: adjList) { // node: 각 정점의 인접리스트의 헤드
			System.out.println(node);
		}
	}
	
	public static void bfs(Node adjList[]) {
		Queue<Integer> queue = new ArrayDeque<>(); //큐에 넣는 값은 방문대상은
		int size=adjList.length;
		
		boolean[] visited=new boolean[size];
		//탐색 시작점 정점 0으로 하자.
		queue.offer(0);
		visited[0]=true;
		
		while(!queue.isEmpty()) {
			int current= queue.poll();
			System.out.println((char)(current+65));
			
			//현 정점의 인접정점들 체크하며 대기열에 넣기
			for(Node temp=adjList[current];temp!=null;temp=temp.next) {
				if(!visited[temp.vertext]) {
					queue.offer(temp.vertext);
					visited[temp.vertext]=true;
				}
			}
			
		}
		
	}
	
	
	public static void dfs(Node[]adjList,boolean[] visited,int current) {
		visited[current]=true;
		System.out.println((char)(current+65));
		
		//현 정점의 인접정점들 체크하며 대기열에 넣기
		for(Node temp= adjList[current]; temp!=null; temp= temp.next) {
			if(!visited[temp.vertext]) {
				dfs(adjList,visited,temp.vertext);
			}
		}
			
		
	}

}

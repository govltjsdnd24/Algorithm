package edu.ssafy.graph;

import java.util.Arrays;
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
		}
		
		for(Node node: adjList) { // node: 각 정점의 인접리스트의 헤드
			System.out.println(node);
		}
	}

}

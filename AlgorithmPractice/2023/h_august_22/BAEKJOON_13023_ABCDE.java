package h_august_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

class Node{
	int vertex; Node next;
	Node(int vertex, Node next){
		this.vertex=vertex; this.next=next;
	}
	@Override
	public String toString() {
		return "Node [vertex=" + vertex + ", next=" + next + "]";
	}
	
}

public class BAEKJOON_13023_ABCDE {
	static int N,M;

	static Node[] adjList;
	static boolean visited[];
	
	static int output=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());

		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		adjList=new Node[N];
		visited=new boolean[N];

		for (int i = 0; i < M; i++) {
			st= new StringTokenizer(br.readLine());
			
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			
			adjList[from]=new Node(to,adjList[from]);
			adjList[to]=new Node(from,adjList[to]);
		}
		for(int i=0;i<N;i++) {
			if(output==1)
				break;
			visited[i]=true;
			checkRelation(adjList[i],1);
			visited[i]=false;
		}
		System.out.println(output);
		
	}
	
	public static void checkRelation(Node current, int count) {
		//basis
		if(count==5) {
			output=1;
			return;
		}
		
		//inductive
		for(Node node=current;node!=null;node=node.next) {
			if(!visited[node.vertex]) {
				visited[node.vertex]=true;
				checkRelation(adjList[node.vertex],count+1);
				visited[node.vertex]=false;
			}
		}
	}

}

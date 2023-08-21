package h_august_21;

import java.io.*;
import java.util.*;

class Node{
	int vertex;
	Node next;
	public Node(int vertex, Node next) {
		this.vertex = vertex;
		this.next = next;
	}
}

public class BAEKJOON_2252_줄세우기 {
	
	static int N,M;
	static Node[] adjList;
	static int[] inDegree;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		adjList=new Node[N+1];
		inDegree= new int[N+1];

		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			adjList[from]=new Node(to,adjList[from]);
			++inDegree[to];
		}
		
		ArrayList<Integer> orderList= topologySort();
		
		StringBuilder sb= new StringBuilder();
		
		for(int o: orderList) {
			sb.append(o);
			if(o!=orderList.get(orderList.size()-1))
				sb.append(" ");
		}
		System.out.println(sb.toString());
	}
	
	static ArrayList<Integer> topologySort() {
		ArrayList<Integer> orderList= new ArrayList<>();
		Queue<Integer> queue= new LinkedList<Integer>();
		
		for(int i=1;i<=N;i++) {
			if(inDegree[i]==0)
				queue.offer(i);
		}
		
		
		while(!queue.isEmpty()) {
			int current=queue.poll();
			orderList.add(current);
			
			for(Node temp=adjList[current];temp!=null; temp=temp.next) {
				if(--inDegree[temp.vertex]==0)
					queue.offer(temp.vertex);
			}
		}
		return orderList;
	}

}

package h_august_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int index,weight;
	Node(int index,int weight){
		this.index=index; this.weight=weight;
	}
	@Override
	public int compareTo(Node o) {
		return this.weight-o.weight;
	}

}

public class BAEKJOON_1753_최단경로 {

	static int V,E;
	static int S;
	static ArrayList<Node>[] nodeList;
	
	static int[] distance;
	static boolean[] visited;
	
	static StringBuilder sb= new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());

		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		
		st= new StringTokenizer(br.readLine());
		S=Integer.parseInt(st.nextToken());
		
		nodeList=new ArrayList[V+1];
		
		for(int i=1;i<=V;i++) {
			nodeList[i]=new ArrayList<Node>();
		}
		for (int i = 0; i < E; i++) {
			st= new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			nodeList[s].add(new Node(e,w));
		}
		
		distance=new int[V+1];
		visited=new boolean[V+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[S]=0;
		
		PriorityQueue<Node> pQueue=new PriorityQueue<Node>();
		pQueue.add(new Node(S,distance[S]));
		
		while(!pQueue.isEmpty()) {
			Node minNode=pQueue.poll();
			int minIdx=minNode.index;
			int minWeight=minNode.weight;
			
			if(visited[minIdx]) 
				continue;
			visited[minIdx]=true;
			
			int size=nodeList[minIdx].size();
			for (int i = 0; i < size; i++) {
				Node currNode=nodeList[minIdx].get(i);
				if(distance[currNode.index]>currNode.weight+distance[minIdx]) {
					distance[currNode.index]=currNode.weight+distance[minIdx];
					pQueue.add(new Node(currNode.index,distance[currNode.index]));
				}
			}
			
			
			
		}
		for (int i = 1; i < distance.length; i++) {
			if(distance[i]==Integer.MAX_VALUE)
				sb.append("INF\n");
			else
				sb.append(distance[i]+"\n");
		}
		
		System.out.println(sb.toString());
	}
}

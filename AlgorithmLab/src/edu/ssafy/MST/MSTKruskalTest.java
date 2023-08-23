package edu.ssafy.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int from,to,weight;

	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		//return this.weight- o.weight;
		return Integer.compare(this.weight, o.weight);
	}
	
}

public class MSTKruskalTest {
	
	static Edge[] edgeList;
	static int V,E;
	
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		
		edgeList=new Edge[E];
		for (int i = 0; i < E; i++) {
			st= new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int weight=Integer.parseInt(st.nextToken());
			edgeList[i]=new Edge(from,to,weight);
		}
		
		
		//간선리스트를 가중치 기준 오름차순 정렬
		Arrays.sort(edgeList);
		
		//V개의 정점으로 make set 작업
		make();
		
		int result=0; //MST 비용
		int count=0; //연결된 간선 개수
		
		for(Edge edge: edgeList) { // 비용이 작은 간선 순으로 꺼내어서 처리
			if(union(edge.from,edge.to)) {
				result+=edge.weight;
				if(++count==V-1)
					break;
			}
			
		}
		System.out.println(result);
	}
	
	static void make() {
		parents=new int[V];
		for (int i = 0; i <V; i++) {
			parents[i]=i;
		}
	}
	
	static int find(int a) {
		if(parents[a]==a)
			return a;
		return parents[a]=find(parents[a]);
	}

	static boolean union(int a,int b) {
		int rootA=find(a);
		int rootB=find(b);
		
		if(rootA==rootB) //싸이클 발생 의미로 해석 됨
			return false;
		
		parents[rootB]=rootA;
		return true;
	}
}

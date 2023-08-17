package edu.ssafy.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class graph구현 {
	static class Edge{
		int s,d,w;
		public Edge(int s,int d,int w){
			this.s=s;this.d=d;this.w=w;
		}
		@Override
		public String toString() {
			return "Edge [s=" + s + ", d=" + d + ", w=" + w + "]";
		}
		
	}
	
	static int N,E;
	static int[][] adjMat;
	static ArrayList[] adjList;
	static Edge[] edge;
	
	public static void main(String[] args) {
		System.setIn(graph구현.class.getResourceAsStream("그래프.txt"));
		Scanner scan = new Scanner(System.in);

		N=scan.nextInt();
		E=scan.nextInt();
		//인접행렬
		adjMat=new int[N][N];
		
		//인접리스트
		adjList= new ArrayList[N];
		//arraylist 초기화
		for (int i = 0; i < N; i++) {
			adjList[i]=new ArrayList();
		}
		
		//간선리스트
		edge=new Edge[E];
		
		for(int i=0;i<E;i++) {
			int s=scan.nextInt();
			int d=scan.nextInt();
			int w=scan.nextInt();
			//간선리스트
			edge[i]=new Edge(s,d,w);
			
			//인접리스트
			//무방향 무가중치
			adjList[s].add(new int[] {d,0});
			adjList[d].add(new int[] {s,0});
			
//			//유방향 유가중치
//			adjList[s].add(new int[] {d,w});
//			//인접행렬
//			//무방향 무가중치
//			adjMat[s][d]=1;
//			adjMat[d][s]=1;
//			//유방향 유가중치
////			adjMat[s][d]=w;
		}
//		print();
//		print(adjList);
		print(edge);
		scan.close();
	}
	
	private static void print(Edge[] edge) {
		for (int i = 0; i < edge.length; i++) {
			System.out.println(edge[i]);
		}
	}
	
	private static void print(ArrayList<Integer[]>[] adjList) {
		for (int i = 0; i < adjList.length; i++) {
			System.out.print(i+" : ");
			for (int j = 0; j < adjList[i].size(); j++) {
				System.out.print(adjList[i].get(j)+" ");
			}
			System.out.println();
		}
	}
	
	
	
	private static void print() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(adjMat[r][c]+" ");
			}
			System.out.println();
		}
	}
}

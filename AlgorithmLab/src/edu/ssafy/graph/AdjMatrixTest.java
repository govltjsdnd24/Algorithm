package edu.ssafy.graph;

import java.util.*;


public class AdjMatrixTest {


	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int V= scan.nextInt();
		int E= scan.nextInt();
		
		int [][]adjMatrix= new int[V][V]; //초기값 0
		//간선 있으면 1, 없으면 0

		for (int i = 0; i < E; i++) {
			int from= scan.nextInt();
			int to= scan.nextInt();
			adjMatrix[to][from]=adjMatrix[from][to]=1;
		}
		bfs(adjMatrix);
		
		for(int[] is: adjMatrix) {
			System.out.println(Arrays.toString(is));
		}
	}
	
	public static void bfs(int [][]adjMatrix) {
		Queue<Integer> queue = new ArrayDeque<>(); //큐에 넣는 값은 방문대상은
		int size=adjMatrix.length;
		
		boolean[] visited=new boolean[size];
		//탐색 시작점 정점 0으로 하자.
		queue.offer(0);
		visited[0]=true;
		
		while(!queue.isEmpty()) {
			int current= queue.poll();
			System.out.println((char)(current+65));
			
			//현 정점의 인접정점들 체크하며 대기열에 넣기
			for(int i=0;i<size;i++) {
				if(adjMatrix[current][i]==1 && !visited[i]) {
					queue.offer(i);
					visited[i]=true;
				}
			}
			
		}
		
	}

}

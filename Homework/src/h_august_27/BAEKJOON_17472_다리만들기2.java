package h_august_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

class Island{
	int r,c;

	public Island(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}




public class BAEKJOON_17472_다리만들기2 {
	
	static int N,M;
	static int[][]map;
	
	static int []dr= {1,-1,0,0};
	static int []dc= {0,0,1,-1};
	static boolean[][]visited;
	static ArrayList<Edge> edgeList=new ArrayList<Edge>();
	
	static int[] parents;
	
	static class Edge implements Comparable<Edge>{
		int from,to,weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}


		@Override
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		visited=new boolean[N][M];
		int index=1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]!=0 && !visited[i][j])
					islandFlag(i,j,index++);
			}
		}
		print();
		visited=new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]!=0 && !visited[i][j])
					formBridges(i,j,map[i][j]);
			}
		}
		
		Collections.sort(edgeList);
		System.out.println(edgeList.toString());
		
		make(index);
		
		int sum=0;
		for(Edge edge: edgeList) {
			if(find(edge.from)!=find(edge.to)) {
				union(edge.from,edge.to);
				sum+=edge.weight;
			}
		}
		
		int temp=parents[1];
		for (int i = 2; i < parents.length; i++) {
			System.out.println(parents[1]+ " " +parents[i]);
			if(temp!=parents[i]) {
				sum=0;
				break;
			}
		}
		System.out.println(sum!=0?sum:-1);
	}
	
	static void islandFlag(int r,int c, int islandIndex) {
		Queue<Island> queue=new ArrayDeque<Island>();
		queue.offer(new Island(r,c));
		
		while(!queue.isEmpty()) {
			Island current=queue.poll();
			int sr=current.r;
			int sc=current.c;
			visited[sr][sc]=true;
			map[sr][sc]=islandIndex;
			
			for (int i = 0; i < 4; i++) {
				int nr=sr+dr[i];
				int nc=sc+dc[i];
				if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]==1 && !visited[nr][nc] ) {
					visited[nr][nc]=true;
					queue.offer(new Island(nr,nc));
				}
			}
		}
	}
	
	
	static void formBridges(int r,int c,int index) {
		Queue<Island> queue= new ArrayDeque<Island>();
		
		for (int i = 0; i < 4; i++) {
			int counter=0;
			queue.offer(new Island(r,c));
			
			while(!queue.isEmpty()) {
				Island current=queue.poll();
				int nr=current.r+dr[i];
				int nc=current.c+dc[i];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]!=index) {
					if(map[nr][nc]==0) {
						queue.offer(new Island(nr,nc));
						counter++;
					}
					else {
						if(counter==1)
							break;
						edgeList.add(new Edge(index,map[nr][nc],counter));
					}
				}
			
			}
			
		}
	}
	
	static void make(int index) {
		parents=new int[index];
		for (int i = 1; i < index; i++) {
			parents[i]=i;
		}
	}
	
	static int find(int a) {
		if(a==parents[a])
			return a;
		return parents[a]=find(parents[a]);
	}
	
	static boolean union(int a,int b) {
		int rootA=find(a);
		int rootB=find(b);
		
		if(rootA==rootB)
			return false;
		parents[rootB]=rootA;
		return true;
	}
	
	
	static void print() {
		for (int i = 0; i < N;i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);	
			}
			System.out.println();
		}
	}

}

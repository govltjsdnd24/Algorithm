package h_august_27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge>{
	int s,e,w;

	public Edge(int s, int e, int w) {
		super();
		this.s = s;
		this.e = e;
		this.w = w;
	}

	@Override
	public String toString() {
		return "Edge [s=" + s + ", e=" + e + ", w=" + w + "]";
	}

	@Override
	public int compareTo(Edge o) {
		return this.w-o.w;
	}
}

class Vertex implements Comparable<Vertex>{
	int e,w;
	
	public Vertex(int e, int w) {
		super();
		this.e = e;
		this.w = w;
	}
	
	@Override
	public String toString() {
		return "Vertex [e=" + e + ", w=" + w + "]";
	}

	@Override
	public int compareTo(Vertex o) {
		return this.w-o.w;
	}
	
}

public class practice {
	
	static int[] array= {1,2,3,4,5};
	static int[] permutation=new int [2];
	static int[] combination=new int[2];
	static boolean[] isVisited= new boolean[array.length];
	static boolean[] isSelected= new boolean[array.length];
	
	static int[] parents;
	static int V=5;
	static int E=V-1;
	static boolean[] edgeVisited=new boolean[E];
	

	public static void main(String[] args) {
		powerSet(0);

	}

	
	public static void dupPermu(int index) {
		if(index==permutation.length) {
			System.out.println(Arrays.toString(permutation));
			return;
		}
		
		for (int i = 0; i < array.length; i++) {
			permutation[index]=array[i];
			dupPermu(index+1);
		}
	}
	
	public static void permu(int index) {
		if(index==permutation.length) {
			System.out.println(Arrays.toString(permutation));
			return;
		}
		
		for (int i = 0; i < array.length; i++) {
			if(!isVisited[i]) {
				isVisited[i]=true;
				permutation[index]=array[i];
				permu(index+1);
				isVisited[i]=false;
			}
		}
	}
	
	
	public static void dupCombin(int aIndex,int cIndex) {
		if(cIndex==combination.length) {
			System.out.println(Arrays.toString(combination));
			return;
		}
		
		for (int i = aIndex; i < array.length; i++) {
			combination[cIndex]=array[i];
			dupCombin(i,cIndex+1);
		}
	}
	
	public static void combin(int aIndex,int cIndex) {
		if(cIndex==combination.length) {
			System.out.println(Arrays.toString(combination));
			return;
		}
		
		for (int i = aIndex; i < array.length; i++) {
			combination[cIndex]=array[i];
			dupCombin(i+1,cIndex+1);
		}
	}
	
	public static void powerSet(int index) {
		if(index==array.length) {
			ArrayList<Integer>list= new ArrayList<Integer>();
			for (int i = 0; i < array.length; i++) {
				if(isSelected[i])
					list.add(array[i]);
			}
			System.out.println(list.toString());
			return;
		}
		
		isSelected[index]=true;
		powerSet(index+1);
		isSelected[index]=false;
		powerSet(index+1);

	}
	
	
	public static void make() {
		parents=new int[V];
		for (int i = 0; i < parents.length; i++) {
			parents[i]=i;
		}
	}
	
	public static int find(int a) {
		if(a==parents[a])
			return a;
		return parents[a]=find(parents[a]);
	}
	
	public static boolean union(int a,int b) {

		int rootA=find(a);
		int rootB=find(b);
		if(rootA==rootB)
			return false;
		parents[rootB]=rootA;
		return true;
	}

	public static void kruskal() {
		Edge[] edges=new Edge[E];
		
		for (int i = 0; i < edges.length; i++) {
			edges[i]=new Edge(i,i,i);
		}
		
		Arrays.sort(edges);
		make();
		
		int sum=0;int count=0;
		for(Edge edge:edges) {
			if(union(edge.s,edge.e)) {
				sum+=edge.w;
				if(++count==E) {
					break;
				}
			}
		}
		System.out.println(sum);
	}
	
	public static void prim() {
		ArrayList<Vertex>[] vertList=new ArrayList[V];
		int[]distance=new int [V];
		boolean[]isVisited=new boolean[V];
		
		for (int i = 0; i < vertList.length; i++) {
			//vertlist안에 넣음
			//vertList[a].add(new Vertex(b,c));
		}
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[0]=0;
		
		PriorityQueue<Vertex> pQueue=new PriorityQueue<Vertex>();
		pQueue.offer(new Vertex(0,0));
		
		int count=0;
		
		while(!pQueue.isEmpty()) {
			Vertex current=pQueue.poll();
			int minIndex=current.e;
			int minWeight=current.w;
			
			if(isVisited[minIndex])
				continue;
			isVisited[minIndex]=true;
			
			if(count++==V)
				break;
			
			int size=vertList[minIndex].size();
			for (int i = 0; i < size; i++) {
				Vertex next=vertList[minIndex].get(i);
				int nextPos=next.e;
				int nextWeight=next.w;
				
				if(!isVisited[nextPos] && distance[nextPos]>nextWeight) {
					distance[nextPos]=nextWeight;
					pQueue.offer(new Vertex(nextPos,distance[nextPos]));
				}
			}
			
		}
	}

	public static void djikstra(int index) {
		ArrayList<Vertex>[]vertList=new ArrayList[V];
		
		for (int i = 0; i < vertList.length; i++) {
			
		}
		
		int distance[]=new int[V];
		boolean isVisited[]=new boolean[V];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[index]=0;
		
		PriorityQueue<Vertex>pQueue=new PriorityQueue<Vertex>();
		pQueue.offer(new Vertex(index,distance[index]));
		
		int sum=0;
		while(!pQueue.isEmpty()) {
			Vertex current=pQueue.poll();
			int currentPos=current.e;
			int currentWeight=current.w;
			
			if(isVisited[currentPos])
				continue;
			isVisited[currentPos]=true;
			
			sum+=currentWeight;
			
			int size=vertList[currentPos].size();
			for (int i = 0; i < size; i++) {
				Vertex next=vertList[currentPos].get(i);
				
				if(distance[next.e]>distance[currentPos]+next.w) {
					distance[next.e]=distance[currentPos]+next.w;
					pQueue.offer(new Vertex(next.e,distance[next.e]));
				}
			}
		}
	}


}

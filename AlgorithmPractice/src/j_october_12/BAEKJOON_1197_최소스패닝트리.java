package j_october_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{

	private int from,to,weight;
	
	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.weight, o.weight);
	}

	@Override
	public String toString() {
		return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
	}
	
}

public class BAEKJOON_1197_최소스패닝트리 {
	
	static int V,E;
	static int parents[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		
		Edge[] edges=new Edge[E+1];
		
		for (int i = 1; i <= E; i++) {
			st= new StringTokenizer(br.readLine());
			edges[i]=new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(edges,1,E+1);
		
		make();
		
		int result=0;
		int count=0;
		
		for(int i=1;i<=E;i++) {
			if(union(edges[i].getFrom(),edges[i].getTo())) {
				result+=edges[i].getWeight();
				if(++count==V-1)
					break;
			}
		}
		System.out.println(result);
	}
	
	static void make() {
		parents=new int[V+1];
		for (int i = 1; i <= V; i++) {
			parents[i]=i;
		}
	}
	
	static int find(int a) {
		if(parents[a]==a)
			return a;
		return parents[a]=find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int rootA=find(a);
		int rootB=find(b);
		
		if(rootA==rootB)
			return false;
		
		parents[rootB]=rootA;
		return true;
	}

}

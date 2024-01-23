package h_august_23;

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
		return Integer.compare(this.weight, o.weight);
	}
}

public class SWEA_3124_최소스패닝트리 {
	
	static Edge[] edgeList;
	static int V,E;
	static int[]parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int T=Integer.parseInt(st.nextToken());
		
		for(int testcase=1;testcase<=T;testcase++) {
			st= new StringTokenizer(br.readLine());
			V=Integer.parseInt(st.nextToken());
			E=Integer.parseInt(st.nextToken());
			
			edgeList=new Edge[E];
			for(int i=0;i<E;i++) {
				st= new StringTokenizer(br.readLine());
				edgeList[i]= new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(edgeList);
			
			make();
			
			long result=0;
			int count=0;
			for(Edge edge:edgeList) {
				if(union(edge.from, edge.to)) {
					result+=edge.weight;
					if(++count==V-1)
						break;
				}
			}
			System.out.println("#"+testcase+" "+result);
			
		}

	}
	
	public static void make() {
		parents=new int[V+1];
		
		for(int i=1;i<=V;i++) {
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

}

package h_august_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Island{
	double x,y;
	Island(double x,double y){
		this.x=x;this.y=y;
	}
}

class Node implements Comparable<Node>{
	int end;
	double weight;

	public Node(int end, double weight) {
		super();
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return Double.compare(this.weight, o.weight);
	}

	@Override
	public String toString() {
		return "Node [end=" + end + ", weight=" + weight + "]";
	}
	
}

public class SWEA_1251_하나로 {
	static int N;
	static double E;
	static Island[] islands;
	static ArrayList<Node>[] nodeList;
	
	static boolean[] visited;
	static double[] distance;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int T=Integer.parseInt(st.nextToken());
		for(int testcase=1;testcase<=T;testcase++) {
			st= new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			
			islands=new Island[N];
			nodeList=new ArrayList[N];
			
			double []xs=new double[N];
			double []ys=new double[N];
			
			st= new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				xs[i]=Double.parseDouble(st.nextToken());
			}
			st= new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				ys[i]=Double.parseDouble(st.nextToken());
			}
			for (int i = 0; i < N; i++) {
				islands[i]=new Island(xs[i],ys[i]);
			}
			
			
			st= new StringTokenizer(br.readLine());
			E=Double.parseDouble(st.nextToken());
			System.out.println("#"+testcase+" "+MST_Prim());
		}

	}
	
	public static long MST_Prim () {
		
		long totalSum=0;
		
		//form connected graph
		for (int i = 0; i < islands.length; i++) {
			nodeList[i]=new ArrayList<Node>();
			for (int j = 0; j < islands.length; j++) {
				if(i!=j) {
					nodeList[i].add(new Node(j,calcDistance(islands[i],islands[j])));
				}
			}
		}
		
		//Prim
		visited=new boolean[N];
		distance=new double[N];
		Arrays.fill(distance, Double.MAX_VALUE);
		distance[0]=0.0;
		
		PriorityQueue<Node> pQueue=new PriorityQueue<Node>();
		pQueue.add(new Node(0,distance[0]));
		
		while(!pQueue.isEmpty()) {
			Node current=pQueue.poll();
			int currPos=current.end;
			double currWeight=current.weight;
			
			if(visited[currPos])
				continue;
			
			visited[currPos]=true;
			int size=nodeList[currPos].size();
			for(int i=0;i<size;i++) {
				Node next=nodeList[currPos].get(i);
				int nextPos=next.end;
				double nextWeight=next.weight;
				if(!visited[nextPos] && distance[nextPos]>nextWeight) {
					distance[nextPos]=nextWeight;
					pQueue.add(new Node(nextPos,nextWeight));
				}
			}	
		}
		for (int i = 0; i < distance.length; i++) {
			totalSum+=E*Math.pow(distance[i],2);

		}
		
		return totalSum;
	}
	
	
	
	public static double calcDistance(Island a, Island b) {
		double x=Math.abs(a.x-b.x);
		double y=Math.abs(a.y-b.y);
		
		return(Math.sqrt(Math.pow(x, 2.0)+Math.pow(y, 2.0)));
	}
	
	public static void print() {
		for (int i = 0; i < nodeList.length; i++) {
			System.out.println(nodeList[i].toString());
		}
	}
}

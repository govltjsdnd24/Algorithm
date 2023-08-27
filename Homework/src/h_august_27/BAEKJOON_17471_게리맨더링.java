package h_august_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int vertex;
	Node next;

	public Node(int vertex, Node next) {
		this.vertex=vertex; this.next=next;
	}

	@Override
	public String toString() {
		return "Node [vertex=" + vertex + ", next=" + next + "]";
	}
	
}

public class BAEKJOON_17471_게리맨더링 {
	
	static int min=Integer.MAX_VALUE;
	static int N;
	static int populations[];
	static int regions[][];
	static Node[] nodeList;
	static int parents[];
	static int array[];
	static boolean isSelected[];
	static boolean isVisited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		populations=new int[N];
		regions=new int[N][];
		
		isSelected=new boolean[N];
		nodeList=new Node[N];
		make();	
		
		st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			populations[i]=Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			regions[i]=new int[Integer.parseInt(st.nextToken())];
			for (int j = 0; j < regions[i].length; j++) {
				regions[i][j]=Integer.parseInt(st.nextToken())-1;
				nodeList[i]=new Node(regions[i][j],nodeList[i]);
				union(i,regions[i][j]);
			}
		}
		
		makePowerSets(0);
		System.out.println(min!=Integer.MAX_VALUE?min:-1);
	}
	
	static void make() {
		parents=new int[N];
		array=new int[N];
		
		for (int i = 0; i < N; i++) {
			parents[i]=i;
			array[i]=i;
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
		
		if(rootA==rootB) {
			return false;
		}
		parents[rootB]=rootA;
		return true;
	}
	
	static void makePowerSets(int index) {
		//
		if (index==N) {
			ArrayList<Integer>regA= new ArrayList<Integer>();
			ArrayList<Integer>regB= new ArrayList<Integer>();
			
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {
					for(int j=0;j<regA.size();j++) {
						if(find(regA.get(j))!=find(array[i]))
							return;
					}
					regA.add(array[i]);
					union(regA.get(0),regA.get(regA.size()-1));
				}
				else if(!isSelected[i]) {
					for(int j=0;j<regB.size();j++) {
						if(find(regB.get(j))!=find(array[i]))
							return;
					}
					regB.add(array[i]);
					union(regB.get(0),regB.get(regB.size()-1));
				}
			}
			
			if(regA.isEmpty() || regB.isEmpty())
				return;
			
			//System.out.println("regA: "+regA.toString());
			//System.out.println("regB: "+regB.toString());
			int aSum=bfs(regA);
			int bSum=bfs(regB);
			if(aSum==Integer.MIN_VALUE || bSum==Integer.MIN_VALUE)
				return;
			
			min=Math.min(min,Math.abs(aSum-bSum));
			
			return;
		}
		
		//
		isSelected[index]=true;
		makePowerSets(index+1);
		isSelected[index]=false;
		makePowerSets(index+1);
	}
	
	
	static int bfs(ArrayList<Integer> regionList) {
		if(regionList.size()==1)
			return populations[regionList.get(0)];
		
		int counter=regionList.size()-1;
		isVisited=new boolean[N];
		Queue<Node> queue= new ArrayDeque<Node>();
		queue.offer(nodeList[regionList.get(0)]);
		isVisited[regionList.get(0)]=true;
		int sum=populations[regionList.get(0)];
		
		while(!queue.isEmpty()) {
			Node current=queue.poll();
			
			for(Node next=current;next!=null;next=next.next) {
				//if the nodes are connected
				if(!isVisited[next.vertex] && regionList.contains(next.vertex)) {
					isVisited[next.vertex]=true;
					queue.offer(nodeList[next.vertex]);
					counter--;
					sum+=populations[next.vertex];
				}
			}
		}
		
		if(counter!=0)
			sum=Integer.MIN_VALUE;
		return sum;
	}
	

}

package h_august_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Node{
	int vertex;Node next;
	Node(int vertex,Node next){
		this.vertex=vertex; this.next=next;
	}
	@Override
	public String toString() {
		return "Node [vertex=" + vertex + ", next=" + next + "]";
	}
	
}

public class SWEA_1238_Contact {
	
	static int L,S;
	static Map<Integer,Node> nodeMap;
	static Object[] nodes;
	static boolean []visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int testcase=1;testcase<=10;testcase++) {
			st= new StringTokenizer(br.readLine());
			L=Integer.parseInt(st.nextToken());
			S=Integer.parseInt(st.nextToken());
			
			int []froms=new int[L/2];
			int []tos=new int[L/2];
			Set<Integer> set=new HashSet<Integer>();
			st= new StringTokenizer(br.readLine());
			for(int i=0;i<L/2;i++) {
				froms[i]=Integer.parseInt(st.nextToken());
				tos[i]=Integer.parseInt(st.nextToken());
				set.add(froms[i]);
				set.add(tos[i]);
			}
			
			nodeMap= new HashMap<Integer,Node>();
			Iterator<Integer>iterator=set.iterator();
			visited=new boolean[set.size()];
			nodes=set.toArray();
			
			int index=0;
			int counter=0;
			while(iterator.hasNext()) {
				int next=iterator.next();
				nodeMap.put(next, null);
				if(next==S)
					index=counter;
				counter++;
			}
			
			for(int i=0;i<L/2;i++) {
				nodeMap.put(froms[i],new Node(tos[i],nodeMap.get(froms[i])));
			}
			
			System.out.println("bfs "+bfsContact(index));
			
		}
	}
	
	public static int bfsContact(int index) {
		Queue<Node> queue=new LinkedList<Node>();
		queue.offer(nodeMap.get(nodes[index]));
//		visited[index]=true;
		int max=Integer.MIN_VALUE;
		
		int depth=0;
		while(!queue.isEmpty()) {
			System.out.println(queue.size());
			int size=queue.size();
			while(--size>=0) {
				Node current=queue.poll();
				max=Integer.MIN_VALUE;
				System.out.println("here");
				while(current!=null) {
					System.out.println("cur: "+current.vertex);
					int currIndex=find(current.vertex);
					if(!visited[currIndex]) {
						System.out.println(current.vertex);
						max=Math.max(max, current.vertex);
						visited[currIndex]=true;
						queue.offer(current.next);
					}
					current=current.next;
				}
			}			
			depth++;
		}
		
		return max;
	}
	
	public static int find(int vertex) {
		for (int i = 0; i < nodes.length; i++) {
			if((int)nodes[i]==vertex)
				return i;
		}
		return -1;
	}

}

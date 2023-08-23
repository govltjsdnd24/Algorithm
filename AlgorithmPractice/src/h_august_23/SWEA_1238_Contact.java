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
	static Node[] nodeList;
	static Map<Integer,Node[]> nodeMap;

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
			
			nodeMap= new HashMap<Integer,Node[]>();
			Iterator<Integer>iterator=set.iterator();
			
			while(iterator.hasNext()) {
				nodeMap.put(iterator.next(), null);
			}
			
			System.out.println(nodeMap.toString());
			
		}
	}

}

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class july_30 {
	
	static boolean visited[];
	static ArrayList<Integer>[]A;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int i,n,m;
		int s,e;
		n=sc.nextInt();
		m=sc.nextInt();
		visited=new boolean[n+1];
		A=new ArrayList[n+1];
		
		for(i=1;i<=n;i++) {
			A[i]=new ArrayList<Integer>();
		}
		for(i=0;i<m;i++) {
			s=sc.nextInt();
			e=sc.nextInt();
			A[s].add(e);
			A[e].add(s);
		}
		int count=0;
		for(i=1;i<=n;i++) {
			if(!visited[i]) {
				count++;
				DFS(i);
			}
		}
		System.out.println(count);
	}
	private static void DFS(int v) {
		if(visited[v])
			return;
		visited[v]=true;
		for(int i: A[v]) {
			if(!visited[i]) {
				DFS(i);
			}
		}
	}
}



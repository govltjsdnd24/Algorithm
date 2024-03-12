package c_march_12;

import java.io.*;
import java.util.*;



public class BAEKJOON_2606_바이러스 {

	static int M,N;
	
	static int[][] node;
    static boolean[] visited;
    
    static int result=0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		M=Integer.parseInt(br.readLine());
		N=Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		node=new int[M][M];
		visited=new boolean[M];
		int i,j;
		
		for(int tc=0;tc<N;tc++) {
			st=new StringTokenizer(br.readLine());
			int m=Integer.parseInt(st.nextToken())-1;
			int n=Integer.parseInt(st.nextToken())-1;
			node[m][n]=node[n][m]=1;
		}
		
		bfs();
		
		System.out.println(result);
		
	}
	
	static void bfs() {
		Queue<Integer>queue=new ArrayDeque<Integer>();
		visited[0]=true;
		queue.add(0);
		
		while(!queue.isEmpty()) {
			int current=queue.poll();
			
			for(int i=0;i<M;i++) {
				if(node[current][i]==1 && !visited[i]) {
					queue.add(i);
					visited[i]=true;
					result++;
				}
			}
		}
		
	}
	


}

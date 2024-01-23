package i_september_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEKJOON_1197_최소스패닝트리 {

	static int V,E;
	static int adjMatrix[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		adjMatrix = new int[V][V];
		
		for (int i = 0; i < E; i++) {
			st= new StringTokenizer(br.readLine());
			adjMatrix[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=Integer.parseInt(st.nextToken());
		}
		
		boolean[] visited= new boolean[V];
		int[] minEdge=new int[V];
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[0]=0;
		
		int result=0;
		int min=0, minVertex=0;
		
		for(int c=0;c<V;c++) {
			minVertex=-1;
			min=Integer.MAX_VALUE;
			
			for (int i = 0; i < V; i++) {
				if(!visited[i] && min>minEdge[i]) {
					minVertex=i;
					min=minEdge[i];
				}
			}
			
			visited[minVertex]=true;
			result+=min;
			
			for(int i=0;i<V;i++) {
				if(!visited[i] && adjMatrix[minVertex][i]!=0 && minEdge[i]>adjMatrix[minVertex][i]) 
					minEdge[i]=adjMatrix[minVertex][i];
				
			}
		}
		System.out.println(result);
	}

}

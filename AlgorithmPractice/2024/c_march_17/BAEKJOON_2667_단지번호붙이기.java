package c_march_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BAEKJOON_2667_단지번호붙이기 {
	
	static int[] dr= {0,1,0,-1};
	static int[] dc= {1,0,-1,0};
	
	static int N;
	static int[][]matrix;
	static boolean[][]visited;
	
	static int count;
	static List<Integer> counts;

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		
		matrix=new int[N][N];
		visited= new boolean[N][N];
		counts=new ArrayList<Integer>();
		int i,j;
		
		for(i=0;i<N;i++) {
			String str=br.readLine();
			for(j=0; j<N;j++) {
				matrix[i][j]=str.charAt(j)-'0';
			}
		}
		
		//dfs
		count=1;
		for(i=0;i<N;i++) {
			for(j=0; j<N;j++) {
				if(matrix[i][j]==1 && !visited[i][j]) {
					dfs(i,j);
					counts.add(count);
					count=1;
				}
			}
		}
		
		
		//print
		Collections.sort(counts);
		System.out.println(counts.size());
		for(i=0;i<counts.size();i++) {
			System.out.println(counts.get(i));
		}
		
		
	}
	
	static void dfs (int r, int c) {
		//basis
		visited[r][c]=true;
		
		//recursive
		int nr,nc;
		for(int n=0;n<4;n++) {
			nr=r+dr[n];
			nc=c+dc[n];
			if(nr>=0&&nr<N&&nc>=0&&nc<N&&matrix[nr][nc]==1&&!visited[nr][nc]) {
				count++;
				dfs(nr,nc);
			}
		}
	}
	
	static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0; j<N;j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

}


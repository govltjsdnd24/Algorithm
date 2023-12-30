package l_december_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BAEKJOON_14889_스타트와링크 {

	static int N;
	static int[][] matrix;
	
	static int[] original;
	static int[] selected1;
	static int[] selected2;
	static boolean[] visited;
	static Set<Integer>set= new HashSet<Integer>();
	
	static int difference=Integer.MAX_VALUE;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		matrix=new int[N][N];
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				matrix[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		original=new int[N];
		for(int i=1;i<N;i++) {
			original[i-1]=i;
		}
		selected1=new int[N/2];
		selected2=new int[N/2];
		visited=new boolean[N];
		
		comb1(0,0);
		
		System.out.println(difference);
	}
	
	static int startSum;
	static int linkSum;
	
	static void comb1(int selIndex,int origIndex) {
		if(selIndex==selected1.length) {
			startSum=0;
			linkSum=0;
			
			int counter=0;
			for(int i=0;i<N;i++) {
				if(!visited[i])
					selected2[counter++]=original[i];
			}
			
			comb2("start",selected1,new int[2],0,0);
			comb2("link",selected2,new int[2],0,0);
			
			if(difference>(Math.abs(startSum-linkSum))){
				difference=(Math.abs(startSum-linkSum));
			}
			return;
		}
		
		for(int i=origIndex;i<N;i++) {
			selected1[selIndex]=original[i];
			visited[i]=true;
			comb1(selIndex+1,i+1);
			visited[i]=false;
		}
	}
	
	
	static void comb2(String str,int[] array, int[] selected,int selIndex,int origIndex) {
		if(selIndex==selected.length) {
			if(str=="start") {
				startSum+=matrix[selected[0]][selected[1]];
				startSum+=matrix[selected[1]][selected[0]];

			}
			else if (str=="link") {
				linkSum+=matrix[selected[0]][selected[1]];
				linkSum+=matrix[selected[1]][selected[0]];
			}
			return;
		}
		
		for(int i=origIndex;i<array.length;i++) {
			selected[selIndex]=array[i];
			comb2(str,array,selected,selIndex+1,i+1);
		}
	}

}

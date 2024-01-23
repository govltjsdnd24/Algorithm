package i_september_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEKJOON_14889_스타트와링크 {
	
	static int[][] field;
	static int output=0;
	
	static int[] array;
	static boolean[] visited;
	static int[] combination;
	static ArrayList<Integer[]>teams=new ArrayList();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());

		int N=Integer.parseInt(st.nextToken());
		field=new int[N][N];
		array=new int[N];
		visited=new boolean[N];
		combination=new int[N/2];
		for (int i = 1; i <= N; i++) {
			array[i-1]=i;
		}
		
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				field[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		formCombinations(0,0);
		for (int i = 0; i <teams.size()/2; i++) {
			calculate(i,teams.size()-1-i);
		}
		
		System.out.println();
	}
	
	static void formCombinations(int oIndex,int cIndex) {
		
		if(cIndex==2) {
			Integer[] temp=new Integer[2];
			int current=0;
			for (int i = 0; i < array.length; i++) {
				if(!visited[i]) {
					temp[current++]=array[i];
				}
			}
			
			System.out.println("teams: "+Arrays.toString(temp));
			teams.add(temp);
			return;
		}
		
		for (int i = oIndex; i < array.length; i++) {
			if(!visited[i]) {
				visited[i]=true;
				formCombinations(i+1,cIndex+1);
				visited[i]=false;
			}
		}
	}
	
	static void calculate(int one,int two) {
		Integer[] teamA=teams.get(one);
		Integer[] teamB=teams.get(two);
//		System.out.println(Arrays.toString(teamA));
//		System.out.println(Arrays.toString(teamB));
		
		for (int i = 0; i < teamA.length; i++) {
			
		}
		
	}

}

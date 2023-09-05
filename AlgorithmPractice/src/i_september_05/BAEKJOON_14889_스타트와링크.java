package i_september_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEKJOON_14889_스타트와링크 {
	
	static int[][] field;
	static int output=0;
	
	static int[] array;
	static boolean[] visited;
	static int[] combination;

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
		
		System.out.println();
	}
	
	static void formCombinations(int oIndex,int cIndex) {
		if(cIndex==combination.length) {
			System.out.println(Arrays.toString(combination));
			calculate();
			return;
		}
		
		for (int i = oIndex; i < array.length; i++) {
			if(!visited[i]) {
				visited[i]=true;
				combination[cIndex]=array[oIndex];
				formCombinations(i+1,cIndex+1);
				visited[i]=false;
			}
		}
	}
	
	static void calculate() {
		
	}

}

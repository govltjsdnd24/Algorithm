package j_october_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEKJOON_17281_야구 {
	
	static int[] array= {1,2,3,4,5,6,7,8,9};
	static int[] selected=new int[9];
	static boolean[] visited= new boolean[9];
	static int max=Integer.MIN_VALUE;

	static int N;
	static int [][]innings;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		innings=new int[N][9];
		
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				innings[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		formPermutation(0);
		System.out.println(max);
	}

	private static void formPermutation(int index) {
		if(index==selected.length) {
			if(selected[3]==1)
				//print(selected);
				max=Math.max(simulateInnings(selected),max);
			return;
		}
		for (int i = 0; i < array.length; i++) {
			if(!visited[i]) {
				visited[i]=true;
				selected[index]=array[i];
				formPermutation(index+1);
				visited[i]=false;
			}
		}
		
	}

	private static int simulateInnings(int[] selected) {
		int score=0;
		int order=0;
		
		for (int i = 0; i < N; i++) {
			boolean[] baseFilled=new boolean[4];
			int outs=0;
			while(outs<3){
				int hit=innings[i][selected[order]-1];
				order=(order+1)%9;
				if(hit==0)
					outs++;
				else {
					score+=moveBases(baseFilled,hit);
				}
			}
		}
		if(selected[0]==4 &&selected[1]==5 &&selected[2]==6 &&selected[4]==0)
			System.out.println("Sel:" +score);
		return score;
	}

	private static int moveBases(boolean[] baseFilled, int hit) {
		boolean[] baseCopied=baseFilled.clone();
		baseCopied[0]=true;
		baseFilled=new boolean[4];
		int score=0;
		
		for (int i = 0; i < baseCopied.length; i++) {
			int dest=i+hit;
			if(dest>=4) {
				if(baseCopied[i]==true)
					score++;
			}
			else
				baseFilled[dest]=baseCopied[i];
		}
		return score;
	}

	private static void print(int[] selected) {
		for (int i = 0; i < selected.length; i++) {
			System.out.print(selected[i]+" ");
		}
		System.out.println();
	}
	
	

}

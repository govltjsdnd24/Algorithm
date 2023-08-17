package edu.ssafy.graph;

import java.util.Arrays;
import java.util.Scanner;

public class AdjMatrixTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int V= scan.nextInt();
		int E= scan.nextInt();
		
		int [][] adjMatrix= new int[V][V]; //초기값 0
		//간선 있으면 1, 없으면 0

		for (int i = 0; i < E; i++) {
			int from= scan.nextInt();
			int to= scan.nextInt();
			adjMatrix[to][from]=adjMatrix[from][to]=1;
		}
		
		for(int[] is: adjMatrix) {
			System.out.println(Arrays.toString(is));
		}
	}

}

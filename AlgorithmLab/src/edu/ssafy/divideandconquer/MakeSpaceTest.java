package edu.ssafy.divideandconquer;

import java.util.Scanner;

public class MakeSpaceTest {

	static int spaces[][], white,green;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N= scan.nextInt();
		spaces= new int[N][N];
		
		for (int r = 0; r < N; r++) 
			for (int c = 0; c < N; c++) 
				spaces[r][c]= scan.nextInt();
			
		makeSpace(0,0,N);
		System.out.println(white);
		System.out.println(green);
	}
	
	private static void makeSpace(int sr, int sc,int size) {//영역의 좌상단 r,c, 영역 크기 사이즈
		int sum=0;
		for (int r = sr; r < sr+size; r++) 
			for (int c = sc; c< sc+size ; c++) 
				sum+=spaces[r][c];
		
		if(sum==0) { // 모두 하얀색인 공간 (기저조건)
			white++;
		} else if(sum==size*size) { // 모두 초록색인 공간(기저조건)
			green++;
		} else {// 두 색이 섞여있는 공간
			int half=size/2;
			makeSpace(sr,sc,half); // 1
			makeSpace(sr,sc+half,half); // 2
			makeSpace(sr+half,sc,half); //3
			makeSpace(sr+half,sc+half,half); //4
		}
	}

}

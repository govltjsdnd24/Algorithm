package h_august_16;

import java.util.Scanner;

public class BAEKJOON_1992_쿼드트리 {
	
	
	static int[][] quadTree;
	static String output=new String("");

	public static void main(String[] args) {
		int N;
		Scanner scan = new Scanner(System.in);
		N=scan.nextInt();
		String line;
		int i,j;
		
		quadTree=new int[N][N];
		for(i=0;i<N;i++) {
			line=scan.next();
			for(j=0;j<N;j++) {
				quadTree[i][j]=line.charAt(j)-'0';
			}
		}
		
		formulateQuadTree(0,0,N);
		System.out.println(output);
		scan.close();
	}
	
	private static void formulateQuadTree(int r,int c,int size) {
		int i,j;
		int white=0;
		
		for(i=r;i<r+size;i++){
			for(j=c;j<c+size;j++) {
				if(quadTree[i][j]==1)
					white++;
			}
		}
		
		if(white==0)
			output+="0";
		else if(white==size*size)
			output+="1";
		else {
			output+="(";
			int half=size/2;
			formulateQuadTree(r,c,half);
			formulateQuadTree(r,c+half,half);
			formulateQuadTree(r+half,c,half);
			formulateQuadTree(r+half,c+half,half);
			output+=")";
		}
		
		
	}

}

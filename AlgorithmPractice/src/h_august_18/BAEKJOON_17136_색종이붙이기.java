package h_august_18;

import java.util.Scanner;

class ColoredPaper{
	int size,count;
	public ColoredPaper(int size, int count){
		this.size=size; this.count=count;
	}
}

public class BAEKJOON_17136_색종이붙이기 {
	static int N=10;
	static int S=5;
	static int[][]paper=new int[N][N];
	static ColoredPaper[] squares=new ColoredPaper[6];
	static boolean[][]visited=new boolean[N][N];
	static int output=Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		
		for(int i=0;i<N;i++) {
			for(int j=0; j<N;j++) {
				paper[i][j]=scanner.nextInt();
			}
		}
		
		for(int i=1;i<=S;i++) {
			squares[i]=new ColoredPaper(i, 5);
		}
		
		fitSquares(0);
		if(output==Integer.MAX_VALUE)
			output=-1;
		System.out.println(output);
	}
	
	public static void fitSquares(int count) {
		int i=0,j=0;
		//find nonduplicate 1
		Loop:
		for(i=0;i<N;i++) {
			for(j=0;j<N;j++) {
				if(!visited[i][j] && paper[i][j]==1) {
					break Loop;
				}
					
			}
		}
		if(i==N && j==N) {
			output=Math.min(output, count);
			return;
		}
		
		int size=findBiggestRect(i,j);
		
		for(int k=size;k>0;k--) {
			if(squares[k].count>0) {
				squares[k].count--;
				processVisit(i,j,k,true);
				fitSquares(count+1);
				processVisit(i,j,k,false);
				squares[k].count++;
			}
		}
		
	}
	
	public static int findBiggestRect(int r,int c) {
		int size=0;
		boolean checker;

		for(int i=S;i>0;i--) {
			if(squares[i].count<=0) 
				continue;
			
			//check if this size of a colored paper can fit 
			checker=true;
			Loop:
			for(int j=r;j<r+i;j++) {
				for(int k=c;k<c+i;k++) {
					if(j>=N || k>=N || paper[j][k]==0 || visited[j][k]) {
						checker=false;
						break Loop;
					}
				}
			}
			if(checker) {
				size=i;
				break;
			}
		}
		
		return size;
	}
	
	public static void processVisit(int r,int c, int size, boolean vou) {
		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
					visited[i][j]=vou;
			}
		}
	}

}

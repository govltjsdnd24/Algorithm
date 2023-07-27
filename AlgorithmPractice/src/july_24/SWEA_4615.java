package july_24;

import java.util.Scanner;

class Othello{
	
	private char[][]  board;
	private int[][]  plays;
	
	private int[]dr= {1,-1,0,0,1,1,-1,-1};
    private int[]dc= {0,0,1,-1,1,-1,1,-1};
	
	public Othello(int[][] plays,int dim) {
		this.plays=plays;
		board=new char[dim][dim];
		board[dim/2-1][dim/2-1]='W';
		board[dim/2][dim/2]='W';
		board[dim/2][dim/2-1]='B';
		board[dim/2-1][dim/2]='B';
	}
	
	public void play(){
		int i,j;
		int sr,sc;
		
		for(i=0;i<plays.length;i++) {
			sr=plays[i][1]-1;
			sc=plays[i][0]-1;
			
			if(plays[i][2]==1)
				board[sr][sc]='B';
			else if(plays[i][2]==2)
				board[sr][sc]='W';
			
			for(j=0;j<8;j++) {
//				if(board[sr+dr[j]][sc+dc[j]]=='B' && board[sr][sc]=='W') {
//					if(board[sr-dr[j]][sc-dc[j]]=='B')
//						board[sr][sc]='B';
//				}
//				else if(board[sr+dr[j]][sc+dc[j]]=='W' && board[sr][sc]=='B') {
//					if(board[sr-dr[j]][sc-dc[j]]=='W')
//						board[sr][sc]='W';
//				}
				removeCenter(sr,sc,board[sr][sc]);
			}
		}
		for(i=0;i<plays.length;i++) {
			for(j=0;j<plays.length;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private void removeCenter(int sr,int sc,char c) {
		
	}
	
	
}

public class SWEA_4615 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		int N,M;
		int i,j;
		int [][]plays;
		int output[]=new int[2];
		
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N=sc.nextInt(); //length of one side
			M=sc.nextInt(); //# of plays
			plays=new int[M][3];
			
			//put in numbers;
			for(i=0;i<M;i++) {
				for(j=0;j<3;j++) {
					plays[i][j]=sc.nextInt();
				}
			}
			
			Othello oth=new Othello(plays,N);
			oth.play();
			
			//System.out.println("#"+test_case+" "+output[0]+" "+output[1]);
		}
		sc.close();
	}
}

package h_august_18;

import java.io.*;
import java.util.*;


public class BAEKJOON_1987_알파벳 {

	static int R,C;
	static char[][] board;
	static Set<Character> visited= new HashSet<Character>();
	static int output=0;
	
	static int[]dr= {1,-1,0,0};
	static int[]dc= {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		String line;
		board=new char[R+1][C+1];
		for(int i=1;i<=R;i++) {
			line=br.readLine();
			for(int j=1;j<=C;j++) {
				board[i][j]=line.charAt(j-1);
			}
		}
		
		visited.add(board[1][1]);
		traverseBoard(1,1,1);
		System.out.println(output);
	}
	
	public static void traverseBoard(int r, int c,int counter) {
	
		for(int i=0;i<4;i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			if(nr>0 && nr<=R && nc>0 && nc<=C && !visited.contains(board[nr][nc])) {
				visited.add(board[nr][nc]);
				traverseBoard(nr,nc,counter+1);
				visited.remove(board[nr][nc]);
			}
		}
		
		output=Math.max(output,counter);
	}

}

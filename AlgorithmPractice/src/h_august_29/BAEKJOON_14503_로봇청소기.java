package h_august_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_14503_로봇청소기 {
	
	static int N,M;
	static boolean room[][];
	
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	
	static int count=0;
	static int d;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		room=new boolean[N][M];
		st= new StringTokenizer(br.readLine());
		int r= Integer.parseInt(st.nextToken());
		int c= Integer.parseInt(st.nextToken());
		d= Integer.parseInt(st.nextToken());
		
		int i,j;
		for (i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			for (j = 0; j < M; j++) {
				if(Integer.parseInt(st.nextToken())==1)
					room[i][j]=true;
			}
		}
		
		dfsClean(r,c);
		
		for (i = 0; i < N; i++) {
			for (j = 0; j < M; j++) {
				System.out.print(room[i][j]==true?1:0);
			}
			System.out.println();
		}
		
		System.out.println(count);
	}
	
	
	static void dfsClean(int r,int c) {
		
		room[r][c]=true;
		count++;
		System.out.println(r+ " "+c+ " "+d);
		
		int nr,nc;
		for (int i = d; i > d-4; i++) {
			if((i+4)%4==-3)
				System.out.println("here");
			
			nr=r+dr[(i+4)%4];
			nc=c+dc[(i+4)%4];
			
			if(nr>=0 && nr<N && nc>=0 && nc<M && !room[nr][nc]) {
				room[nr][nc]=true;
				dfsClean(nr,nc);
			}
		}
		
	}

}

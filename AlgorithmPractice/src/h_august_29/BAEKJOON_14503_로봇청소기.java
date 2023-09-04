package h_august_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_14503_로봇청소기 {
	
	static int N,M;
	static int room[][];
	
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	
	static int count=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		room=new int[N][M];
		st= new StringTokenizer(br.readLine());
		int r= Integer.parseInt(st.nextToken());
		int c= Integer.parseInt(st.nextToken());
		int d= Integer.parseInt(st.nextToken());
		
		int i,j;
		for (i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			for (j = 0; j < M; j++) {
				if(Integer.parseInt(st.nextToken())==1)
					room[i][j]=1;
			}
		}
		
		
		System.out.println(simulateClean(r,c,d));
		
		
		
		
	}
	
	static int simulateClean(int r,int c,int d) {
		int tilesCleaned=0;
		
		int sr=r;
		int sc=c;
		int nr,nc,dir;
		
		Loop:
		while(true) {
				
			//현재 타일 청소
			if(room[sr][sc]!=-1) {
				room[sr][sc]=-1;
				tilesCleaned++;
			}
			
			//빈 칸 확인
			for (int i = d-1; i >=d-4 ; i--) {
				dir=(i+4)%4;
				nr=sr+dr[dir];
				nc=sc+dc[dir];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M && room[nr][nc]==0) {
					sr=nr;
					sc=nc;
					d=dir;
					continue Loop;
				}
			}
			
			//빈 칸 없을 시
			sr=sr-dr[d];
			sc=sc-dc[d];
			if(room[sr][sc]!=1)
				continue Loop;
			else
				break;
		}
		
		
		return tilesCleaned;
	}

}

package h_august_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Cell{
	static final int SUSPEND=0, ACTIVE=1, MORT=2;
	int r,c,level,cycle,status;
	Cell(int r, int c, int level,int cycle){
		this.r=r; this.c=c; this.level=level; this.cycle=cycle;
	}
	public void changeState() {
		switch(status) {
		case SUSPEND: //비활성 상태
			if(--cycle == level)
				status=ACTIVE;
			break;
		case ACTIVE: //활성 상태
			if(--cycle==0) 
				status=MORT;
			break;
		default:
			break;
		}
	}
}

public class 줄기세포_Solution {
	static final int SUSPEND=0, ACTIVE=1, MORT=2;
	static int N,M,K;
	static int[][]map;
	static int MAXN,MAXM;
	static int startN,startM;
	static Queue <Cell> Q;
	static boolean visited[][];
	
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());

		int T=Integer.parseInt(st.nextToken());
		
		int N,M;
		int i,j;
		
		for(int testcase=1;testcase<=T;testcase++) {
			st= new StringTokenizer(br.readLine());
			Q= new ArrayDeque<>();
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			
			MAXN=2*K+N+2;
			MAXM=2*K+M+2;
			startN=MAXN/2-N/2;
			startM=MAXM/2-M/2;
			visited=new boolean[MAXN][MAXM];
			
			map= new int[MAXN][MAXM];
			
			for(i=0;i<N;i++) {
				st= new StringTokenizer(br.readLine());
				for(j=0;j<M;j++) {
					int temp=Integer.parseInt(st.nextToken());
					if(temp>0) {
						map[startN+i][startM+j]=temp;
						visited[startN+i][startM+j]=true;
						Q.add(new Cell(startN+i,startM+j,temp,temp*2));
					}
				}
			}
			solution();
			//K번 번식하고도 
			System.out.println("#"+testcase+" "+Q.size());
		}

	}
	
	static void solution() {
		//K번 번식
		for (int i = 0; i < K; i++) {
			//활성 상태의 셀을 번식
			for (Cell c: Q) {
				if(c.status== ACTIVE) {
					spread(c);
				}
			}
			//bfs level
			int size= Q.size();
			
			for(int step=0; step< size; step++) {
				Cell cell= Q.poll();
				//세포가 활성상태면 번식
				if(cell.status==ACTIVE) {
					for (int j = 0; j < 4; j++) {
						int nr=cell.r+dr[j];
						int nc=cell.c+dc[j];
						if(visited[nr][nc])
							continue;
						Q.add(new Cell(nr,nc,map[nr][nc], map[nr][nc]*2));
						visited[nr][nc]=true;
					}
				}
				//세포의 상태변화
				cell.changeState();
				
				if(cell.status==MORT)continue;
				//아직 살아있다면 다시 Q로 넣습니다
				Q.add(cell);
			}
		}
	}
	
	static void spread(Cell c) {
		for (int i = 0; i < dc.length; i++) {
			int nr= c.r+dr[i];
			int nc=c.c+dc[i];
			if(visited[nr][nc])continue;
			//나중에 온놈의 라이프가 더 크면 먹음
			if(c.level>map[nr][nc]) 
				map[nr][nc]=c.level;
			
		}
	}

}

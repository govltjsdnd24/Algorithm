package j_october_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Road implements Comparable<Road>{
	int r,c,time,acculumated;

	public Road(int r, int c,int time,int accumulated) {
		super();
		this.r = r;
		this.c = c;
		this.time=time;
		this.acculumated=accumulated;
	}

	@Override
	public int compareTo(Road o) {
		return Integer.compare(acculumated,o.acculumated);
	}
}


public class SWEA_1249_보급로 {

	static int[][]map;
	static int N;
	
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		
		int T=Integer.parseInt(str);
		for (int testcase = 1; testcase <=T; testcase++) {
			str=br.readLine();
			N=Integer.parseInt(str);
			map=new int[N][N];
			
			for (int i = 0; i < N; i++) {
				str=br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j]=str.charAt(j)-'0';
				}
			}
			
			System.out.println("#"+testcase+" "+traverseBFS());
		}
	
	}

	private static int traverseBFS() {
		PriorityQueue<Road>queue=new PriorityQueue<Road>();
		queue.add(new Road(0,0,0,0));
		boolean [][]visited=new boolean[N][N];
		int timeTaken=0;
		
		while(!queue.isEmpty()) {
			Road current=queue.poll();
			
			int r=current.r;
			int c=current.c;
			int time=current.time;
			int accumulated=current.acculumated;
			
			if(r==N-1 && c==N-1) {
				timeTaken=accumulated;
				break;
			}
			
			if(current.time!=0) {
				queue.add(new Road(r,c,time-1,accumulated));
			}
			else {
				for (int i = 0; i < 4; i++) {
					int nr=r+dr[i];
					int nc=c+dc[i];
					
					if(nr>=0 && nr<N && nc>=0 && nc<N ) {
						if(!visited[nr][nc]) {
							visited[nr][nc]=true;
							queue.add(new Road(nr,nc,map[nr][nc],accumulated+map[nr][nc]));
						}
					
					}
				}
			}
		}
		return timeTaken;
	}
}

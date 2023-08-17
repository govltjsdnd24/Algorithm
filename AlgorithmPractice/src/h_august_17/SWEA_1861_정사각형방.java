package h_august_17;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Room{
	private int r,c;
	public Room(int r,int c){
		this.r=r; this.c=c;
	}
	public int getR() {
		return r;
	}
	public int getC() {
		return c;
	}
	
}

public class SWEA_1861_정사각형방 {
	
	static int[][]rooms;
	static boolean[][]visited;
	static int N;
	static int[]results;

	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int testcase,T;
		int i,j;
		int max,max_pos;
		
		T=scan.nextInt();
		for(testcase=1;testcase<=T;testcase++) {
			N=scan.nextInt();
			rooms=new int[N][N];
			
			results=new int[N*N+1];
			
			for(i=0;i<N;i++)
				for(j=0;j<N;j++)
					rooms[i][j]=scan.nextInt();
			
			for(i=0;i<N;i++)
				for(j=0;j<N;j++) {
					visited=new boolean[N][N];
					results[rooms[i][j]]=roomTraverse(i,j);
				}
			
			max=0;max_pos=0;
			for(i=1;i<results.length;i++) {
				//System.out.print(results[i]+" ");
				if(results[i]>max) {
					max=results[i];
					max_pos=i;
				}
			}
			System.out.println("#"+testcase+" "+max_pos+ " "+max);
		}
		scan.close();

	}
	
	public static int roomTraverse(int r,int c) {
		int max=1;
		Queue<Room> queue=new LinkedList<Room>();
		queue.offer(new Room(r,c));
		visited[r][c]=true;
		
		int sr,sc,nr,nc,i;
		while(!queue.isEmpty()) {
			Room room=queue.poll();
			sr=room.getR();
			sc=room.getC();
			
			for(i=0;i<4;i++) {
				nr=sr+dr[i];
				nc=sc+dc[i];
				if(nr>=0&&nr<N&&nc>=0&&nc<N && !visited[nr][nc] && rooms[nr][nc]==rooms[sr][sc]+1) {
					max++;
					queue.offer(new Room(nr,nc));
					visited[nr][nc]=true;
				}
			}
			
		}
		return max;
	}
	
	

}

package august_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Monkey{
	private int x,y,depth,jumps;
	public Monkey(int x,int y,int depth,int jumps) {
		this.x=x;this.y=y;
		this.depth=depth;this.jumps=jumps;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getDepth() {
		return depth;
	}
	public int getJumps() {
		return jumps;
	}
}

class Visited{
	private List<Integer> depth,jumps;
	
	public Visited() {
		this.depth=new ArrayList<Integer>();
		this.jumps=new ArrayList<Integer>();
	}
	
	public void addDJ(int depth,int jump) {
		this.depth.add(depth);
		this.depth.add(jump);
	}
	public boolean findDJ(int depth,int jumps) {
		if(this.depth.isEmpty() || this.jumps.isEmpty())
			return false;
		for(int i=0;i<this.depth.size();i++) {
			if(this.depth.get(i)==depth && this.jumps.get(i)==jumps) {
				return true;
			}
		}
		return false;
	}
	
	
}

public class BAEKJOON_1600 {

	static int [][]ground;
	static boolean [][]visited;
	static boolean[][][]mVisited;
	
	static int[]dxh= {1,2,2,1,-1,-2,-2,-1};
	static int[]dyh= {2,1,-1,-2,-2,-1,1,2};
	static int[]dxm= {0,1,0,-1};
	static int[]dym= {1,0,-1,0};
	static int K,W,H;
	static int reached=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		K= Integer.parseInt(br.readLine());
		String line=br.readLine();
		StringTokenizer st= new StringTokenizer(line);
		W=Integer.parseInt(st.nextToken());
		H= Integer.parseInt(st.nextToken());
		
		int i,j;
		ground=new int[W][H];
		visited=new boolean[W][H];
		mVisited=new boolean[W][H][100000000];
		
		for (i = 0;  i< H; i++) {
			line=br.readLine();
			st= new StringTokenizer(line," ");
			for (j = 0; j < W; j++) {
				ground[j][i]=Integer.parseInt(st.nextToken());
			}
		}
			
		
		//if the monkey couldn't reach the destination
//		if(reached==Integer.MAX_VALUE || (H==1&&W==1&&ground[0][0]==1))
//			reached=-1;
//		System.out.println(reached);
		System.out.println(bfs(0,0,0,0));
		
		
	}
	
	public static void dfs(int x,int y,int depth,int jumps) {
		//basis part
		
		if(x==W-1 && y==H-1) {
			reached=Math.min(reached, depth);
			return;
		}
		
		//inductive part
		//horse-like movement
		if(jumps<K) {
			for(int i=0;i<8;i++) {
				int nx=x+dxh[i];
				int ny=y+dyh[i];
				if(nx>=0 && nx<W && ny>=0 && ny<H && ground[nx][ny]!= 1 && !visited[nx][ny]) {
					visited[nx][ny]=true;
					dfs(nx,ny,depth+1,jumps+1);
					visited[nx][ny]=false;
				}
			}
		}
		
		//monkey-like movement
		for(int i=0;i<4;i++) {
			int nx=x+dxm[i];
			int ny=y+dym[i];
			if(nx>=0 && nx<W && ny>=0 && ny<H && ground[nx][ny]!= 1 && !visited[nx][ny]) {
				visited[nx][ny]=true;
				dfs(nx,ny,depth+1,jumps);
				visited[nx][ny]=false;
			}
		}
		
	}
	
	public static int bfs(int x,int y,int depth,int jumps) {
		Queue<Monkey> monkeyQue=new LinkedList<Monkey>();
		Monkey monkeyPos=new Monkey(x,y,depth,jumps);
		monkeyQue.offer(monkeyPos);
		
		int breadth=0;
		while(!monkeyQue.isEmpty()) {
			int size=monkeyQue.size();
			while(--size>=0) {
				monkeyPos=monkeyQue.poll();
				x=monkeyPos.getX();
				y=monkeyPos.getY();
				depth=monkeyPos.getDepth();
				jumps=monkeyPos.getJumps();
				//return breadth if monkey reaches the destination
				if(x==W-1 && y==H-1) {
					return breadth;
				}
				
				for(int i=0;i<4;i++) {
					int nx=x+dxm[i];
					int ny=y+dym[i];
					if(nx>=0 && nx<W && ny>=0 && ny<H && ground[nx][ny]!= 1) {
						if(!mVisited[nx][ny][jumps]) {
							mVisited[nx][ny][jumps]=true;
							//System.out.println(nx+" "+ny+" "+depth);
							monkeyQue.offer(new Monkey(nx,ny,depth+1,jumps));
						}
					}
				}
			
				if(jumps<K) {
					for(int i=0;i<8;i++) {
						int nx=x+dxh[i];
						int ny=y+dyh[i];
						if(nx>=0 && nx<W && ny>=0 && ny<H && ground[nx][ny]!= 1) {
							if(!mVisited[nx][ny][jumps]) {
								mVisited[nx][ny][jumps]=true;
								monkeyQue.offer(new Monkey(nx,ny,depth+1,jumps+1));
							}
						}
					}
				}
				
				
			}
			//System.out.println(breadth);
			breadth++;
		}
		return -1;
	}

}

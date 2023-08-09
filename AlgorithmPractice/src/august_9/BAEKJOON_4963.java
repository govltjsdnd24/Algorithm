package august_9;

import java.util.*;
import java.io.*;

class Layout{
	private int h,w;
	public Layout(int h,int w) {
		this.h=h; this.w=w;
	}
	public int getH() {
		return h;
	}
	public int getW() {
		return w;
	}
}


public class BAEKJOON_4963 {
	static int[][] map;
	static boolean[][] visited;
	static int H,W;
	
	static int[] dh= {1,-1,0,0,1,1,-1,-1};
	static int[] dw= {0,0,1,-1,1,-1,1,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line;
		StringTokenizer st;
		List<Integer[]> al=new ArrayList<Integer[]>();
		int i,j;
		int counter;
		
		while((line=br.readLine())!=null) {
			st=new StringTokenizer(line);
			W=Integer.parseInt(st.nextToken());
			H=Integer.parseInt(st.nextToken());
			if(W==0 && H==0)
				break;
			
			map=new int[H][W];
			visited=new boolean[H][W];
			counter=0;
			
			for(i=0;i<H;i++) {
				line=br.readLine();
				st=new StringTokenizer(line);
				for(j=0;j<W;j++) 
					map[i][j]=Integer.parseInt(st.nextToken());
			}
			
			for(i=0;i<H;i++)
				for(j=0;j<W;j++) 
					if(map[i][j]==1 && !visited[i][j]) {
						bfs(i,j);
						counter++;
					}
			System.out.println(counter);
				
		}
		
	}
	
	public static void bfs(int height,int width) {
		Queue<Layout> queue= new LinkedList<Layout>();
		queue.offer(new Layout(height,width));
		
		Layout l;
		int h,w,i,nh,nw;
		while(!queue.isEmpty()) {
			l=queue.poll();
			h=l.getH();
			w=l.getW();
			
			for(i=0;i<8;i++) {
				nh=h+dh[i];
				nw=w+dw[i];
				if(nh>=0 && nh<H && nw>=0 && nw<W && map[nh][nw]==1 && !visited[nh][nw]) {
					queue.offer(new Layout(nh,nw));
					visited[nh][nw]=true;
				}
				
			}
			
		}
		
	}

}

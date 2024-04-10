package d_april_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


class Fireball{
	int row,col,mass,dir,speed;
	
	public Fireball(int row,int col,int mass, int dir,int speed) {
		this.row=row;
		this.col=col;
		this.mass=mass;
		this.dir=dir;
		this.speed=speed;
	}
	
	@Override
	public String toString() {
		return "Row: "+row+", Column: "+col+", Mass: "+mass+", Direction: "+dir+", Speed: "+speed;
	}
}


public class BAEKJOON_20056_마법사상어와파이어볼 {
	
	static int[][]grid;
	
	static int[]dr= {-1,-1,0,1,1,1,0,-1};
	static int[]dc= {0,1,1,1,0,-1,-1,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		int N=Integer.parseInt(st.nextToken()); //grid dimension
		int M=Integer.parseInt(st.nextToken()); //number of fireballs
		int K=Integer.parseInt(st.nextToken()); //number of moves
		
		grid=new int[N][N];
		Queue<Fireball>queue=new ArrayDeque<Fireball>();
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			queue.add(new Fireball(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));	
		}
		
		//turn simulation
		for(int k=0;k<K;k++) {
			int queueSize=queue.size();
			
			//move fireballs
			for(int i=0;i<queueSize;i++) {
				Fireball current=queue.poll();
				current.row=dr[current.dir]*current.speed;
				current.col=dc[current.dir]*current.speed;
				queue.add(current);
			}
			
			
		}
		
	}

}

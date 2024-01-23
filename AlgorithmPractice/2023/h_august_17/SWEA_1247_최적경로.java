package h_august_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Coordinate{
	
	private int x,y;

	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + "]";
	}
	
}

public class SWEA_1247_최적경로 {
	
	static int min;
	static Coordinate[] coordinates;
	static Coordinate home;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int T=Integer.parseInt(st.nextToken());
		int N;
		for (int testcase = 1; testcase <= T; testcase++) {
			min=Integer.MAX_VALUE;
			st= new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			coordinates= new Coordinate[N];
			
			st= new StringTokenizer(br.readLine());
			Coordinate company= new Coordinate(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			home=new Coordinate(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			
			for (int i = 0; i < N; i++) {
				coordinates[i]=new Coordinate(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			visited=new boolean[N];
			visitCoordinates(new Coordinate(company.getX(),company.getY()), 0,0);

			System.out.println("#"+testcase+" "+min);
		}
	}
	
	private static void visitCoordinates(Coordinate lastVisited,int depth, int accumulation) {
		if(depth==coordinates.length-1) {
			//System.out.println(accumulation);
			accumulation+=Math.abs(home.getX()-lastVisited.getX())+Math.abs(home.getY()-lastVisited.getY());
			min=Math.min(accumulation, min);
			return;
		}
		
		if(accumulation>min)
			return;
	
		for(int i=0;i<coordinates.length-1;i++) {
			if(!visited[i]) {
				visited[i]=true;
				int tempAcc=accumulation+Math.abs(coordinates[i].getX()-lastVisited.getX())+Math.abs(coordinates[i].getY()-lastVisited.getY());
				visitCoordinates(new Coordinate(coordinates[i].getX(),coordinates[i].getY()),depth+1,tempAcc);
				visited[i]=false;
			}
		}
		
	}
	

	
	
	
}

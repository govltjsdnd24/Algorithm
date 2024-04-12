package d_april_12;

import java.io.*;
import java.util.*;

class Tornado {
	int r;int c;int dir;
	
	public Tornado(int r,int c) {
		this.r=r;this.c=c;this.dir=0;
	}
}

public class BAEKJOON_20057_마법사상어와토네이도 {

	static int[] dr= {0,1,0,-1};
	static int[] dc= {-1,0,1,0};
	
	static int N;
	static int[][]grid;
	
	static int disposedSand=0;
	static Tornado tornado;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		
		grid=new int[N][N];

		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				grid[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		tornado=new Tornado(N/2,N/2);
		rotate();
		
		
		System.out.println(disposedSand);
	}
	
	static void rotate() {
		
		int offSet=-1;
		for(int scale=1;scale<N;scale++) {
			for(int j=0;j<scale;j++) {
				tornado.c+=offSet;
				pushSand(tornado.r,tornado.c);
			}
			tornado.dir=(tornado.dir+1)%4;
			offSet*=-1;
			for(int i=0;i<scale;i++) {
				tornado.r+=offSet;
				pushSand(tornado.r,tornado.c);
			}
			tornado.dir=(tornado.dir+1)%4;
		}
		for(int j=N-1;j>0;j--) {
			tornado.c--;
			pushSand(tornado.r,tornado.c);
			print();
		}
	}
	
	static void pushSand(int r,int c) {
		if(grid[r][c]>0) {
			switch(tornado.dir) {
			case 0:
				leftInteraction();
				break;
			case 1:
				downInteraction();
				break;
			case 2:
				rightInteraction();
				break;
			case 3:
				upInteraction();
				break;
			}
		}
		grid[r][c]=0;
		
	}
	
	static void leftInteraction() {
		int r=tornado.r;
		int c=tornado.c;
		

		if(r-1<0)
			disposedSand+=grid[r][c]*0.07;
		else
			grid[r-1][c]+=grid[r][c]*0.07;
		System.out.println(disposedSand);
		if(r+1>=N)
			disposedSand+=grid[r][c]*0.07;
		else
			grid[r+1][c]+=grid[r][c]*0.07;
		
		if(r-2<0)
			disposedSand+=grid[r][c]*0.02;
		else
			grid[r-2][c]+=grid[r][c]*0.02;
		if(r+2>=N)
			disposedSand+=grid[r][c]*0.02;
		else
			grid[r+2][c]+=grid[r][c]*0.02;
		
		if(r+1>=N || c-1<0)
			disposedSand+=grid[r][c]*0.1;
		else
			grid[r+1][c-1]+=grid[r][c]*0.1;
		if(r-1<0 || c-1<0)
			disposedSand+=grid[r][c]*0.1;
		else
			grid[r-1][c-1]+=grid[r][c]*0.1;
		
		if(r-1<0 || c+1>=N)
			disposedSand+=grid[r][c]*0.01;
		else
			grid[r-1][c+1]+=grid[r][c]*0.01;
		if(r+1>=N || c+1>=N)
			disposedSand+=grid[r][c]*0.01;
		else
			grid[r+1][c+1]+=grid[r][c]*0.01;
		
		if(c-2<0)
			disposedSand+=grid[r][c]*0.05;
		else
			grid[r][c-2]+=grid[r][c]*0.05;
		if(c-1<0)
			disposedSand+=grid[r][c]*0.45;
		else
			grid[r][c-1]+=grid[r][c]*0.45;
	}
	
	static void downInteraction() {
		int r=tornado.r;
		int c=tornado.c;
		
		if(c-1<0)
			disposedSand+=grid[r][c]*0.07;
		else
			grid[r][c-1]+=grid[r][c]*0.07;
		if(c+1>=N)
			disposedSand+=grid[r][c]*0.07;
		else
			grid[r][c+1]+=grid[r][c]*0.07;
		
		if(c-2<0)
			disposedSand+=grid[r][c]*0.02;
		else
			grid[r][c-2]+=grid[r][c]*0.02;
		if(c+2>=N)
			disposedSand+=grid[r][c]*0.02;
		else
			grid[r][c+2]+=grid[r][c]*0.02;
		
		if(c+1>=N || r-1<0)
			disposedSand+=grid[r][c]*0.1;
		else
			grid[r-1][c+1]+=grid[r][c]*0.1;
		if(c-1<0 || r-1<0)
			disposedSand+=grid[r][c]*0.1;
		else
			grid[r-1][c-1]+=grid[r][c]*0.1;
		
		if(c-1<0 || r+1>=N)
			disposedSand+=grid[r][c]*0.01;
		else
			grid[r+1][c-1]+=grid[r][c]*0.01;
		if(r+1>=N || c+1>=N)
			disposedSand+=grid[r][c]*0.01;
		else
			grid[r+1][c+1]+=grid[r][c]*0.01;
		
		if(r+2>=N)
			disposedSand+=grid[r][c]*0.05;
		else
			grid[r+2][c]+=grid[r][c]*0.05;
		if(r+1>=N)
			disposedSand+=grid[r][c]*0.45;
		else
			grid[r+1][c]+=grid[r][c]*0.45;
	}
	
	static void rightInteraction() {
		int r=tornado.r;
		int c=tornado.c;
		
		if(r+1>=N)
			disposedSand+=grid[r][c]*0.07;
		else
			grid[r+1][c]+=grid[r][c]*0.07;
		if(r-1<0)
			disposedSand+=grid[r][c]*0.07;
		else
			grid[r-1][c]+=grid[r][c]*0.07;
		
		if(r+2>=N)
			disposedSand+=grid[r][c]*0.02;
		else
			grid[r+2][c]+=grid[r][c]*0.02;
		if(r-2<0)
			disposedSand+=grid[r][c]*0.02;
		else
			grid[r-2][c]+=grid[r][c]*0.02;
		
		if(r-1<0 || c+1>=N)
			disposedSand+=grid[r][c]*0.1;
		else
			grid[r-1][c+1]+=grid[r][c]*0.1;
		if(r+1>=N || c+1>=N)
			disposedSand+=grid[r][c]*0.1;
		else
			grid[r+1][c+1]+=grid[r][c]*0.1;
		
		if(r+1>=N || c-1<N)
			disposedSand+=grid[r][c]*0.01;
		else
			grid[r+1][c-1]+=grid[r][c]*0.01;
		if(r-1<0 || c-1<0)
			disposedSand+=grid[r][c]*0.01;
		else
			grid[r-1][c+-1]+=grid[r][c]*0.01;
		
		if(c+2<0)
			disposedSand+=grid[r][c]*0.05;
		else
			grid[r][c+2]+=grid[r][c]*0.05;
		if(c+1<0)
			disposedSand+=grid[r][c]*0.45;
		else
			grid[r][c+1]+=grid[r][c]*0.45;
	}
	
	static void upInteraction() {
		int r=tornado.r;
		int c=tornado.c;
		
		
		if(c+1>=N)
			disposedSand+=grid[r][c]*0.07;
		else
			grid[r][c+1]+=grid[r][c]*0.07;
		if(c-1<0)
			disposedSand+=grid[r][c]*0.07;
		else
			grid[r][c-1]+=grid[r][c]*0.07;
		
		if(c-2<0)
			disposedSand+=grid[r][c]*0.02;
		else
			grid[r][c-2]+=grid[r][c]*0.02;
		if(c+2>=N)
			disposedSand+=grid[r][c]*0.02;
		else
			grid[r][c+2]+=grid[r][c]*0.02;
		
		if(c-1<0 || r+1>=N)
			disposedSand+=grid[r][c]*0.1;
		else
			grid[r+1][c-1]+=grid[r][c]*0.1;
		if(c+1>=N || r+1>=N)
			disposedSand+=grid[r][c]*0.1;
		else
			grid[r+1][c+1]+=grid[r][c]*0.1;
		
		if(c+1>=N || r-1<0)
			disposedSand+=grid[r][c]*0.01;
		else
			grid[r-1][c+1]+=grid[r][c]*0.01;
		if(r-1<0 || c-1<0)
			disposedSand+=grid[r][c]*0.01;
		else
			grid[r-1][c-1]+=grid[r][c]*0.01;
		
		if(r-2<0)
			disposedSand+=grid[r][c]*0.05;
		else
			grid[r-2][c]+=grid[r][c]*0.05;
		if(r-1<0)
			disposedSand+=grid[r][c]*0.45;
		else
			grid[r-1][c]+=grid[r][c]*0.45;
	}

	static void print() {
		System.out.println("R: "+tornado.r+ " C: "+tornado.c);
	}

}

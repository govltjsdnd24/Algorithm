package h_august_17;

import java.io.*;
import java.util.*;

class Bomb{
	int r,c,timer;
	char tile;
	public Bomb(int r,int c,char tile) {
		this.r=r; this.c=c; this.tile=tile;
		if(tile=='O')
			setTimer(0);
	}
	public int getR() {
		return r;
	}
	public int getC() {
		return c;
	}
	public int getTimer() {
		return timer;
	}
	public void setTimer(int timer) {
		this.timer=timer;
	}
	public void decreaseTimer() {
		timer--;
	}
	public char getTile() {
		return tile;
	}
	public void setTile(char tile) {
		this.tile = tile;
	}
	
	
}

public class BAEKJOON_16918_봄버맨 {

	static int R,C,N;
	static Bomb[][] grid;
	static char[][] temp;
	
	static int []dr= {1,-1,0,0};
	static int []dc = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		
		grid=new Bomb[R][C];
		temp=new char[R][C];
		
		String line;
		for(int i=0;i<R;i++) {
			line=br.readLine();
			for(int j=0;j<C;j++) {
				grid[i][j]=new Bomb(i,j,line.charAt(j));
			}
		}
		
		bombGame(1);
		printGrid();
	}
	
	private static void bombGame(int timer) {
		while(timer<=N) {
			copyGrid();
			if(timer%2==1) {
				explodeBombs();
			}
			else if(timer%2==0) {
				layBombs();
			}
			passTimer();
			timer++;
			printGrid();
		}
	}
	
	private static void layBombs() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(grid[i][j].getTile()=='.') {
					grid[i][j].setTile('O');
					grid[i][j].setTimer(2);
				}
			}
		}
	}
	
	private static void explodeBombs() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(grid[i][j].getTile() + "  " + grid[i][j].getTimer());
				if(grid[i][j].getTile()=='O' && grid[i][j].getTimer()==0) {
					for(int k=0;k<4;k++) {
						int nr=i+dr[k]; int nc=j+dc[k];
						if(nr>=0 && nr<R && nc>=0 && nc<C)
							temp[i+dr[k]][j+dc[k]]='.';
					}
				}
			}
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				grid[i][j].setTile(temp[i][j]);
				if(temp[i][j]=='.')
					grid[i][j].setTimer(0);
			}
		}
		
	}
	
	private static void copyGrid() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				temp[i][j]=grid[i][j].getTile();
			}
		}
	}
	
	private static void printGrid() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(grid[i][j].getTile());
			}
			System.out.println();
		}
	}
	
	private static void passTimer() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(grid[i][j].getTile()=='O')
					grid[i][j].decreaseTimer();
			}
		}
	}

}

package d_april_10;

import java.io.*;
import java.util.*;


public class BAEKJOON_14499_주사위굴리기 {
	
	static int[] dr= {0,0,-1,1};
	static int[] dc= {1,-1,0,0};

	static int N,M; //height, width
	static int x,y; //coordinate of dice
	static int K; //number of commands
	
	static int[][]grid;
	
	static List<Integer>vertical=new ArrayList<Integer>();
	static List<Integer>horizontal=new ArrayList<Integer>();
	
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		y=Integer.parseInt(st.nextToken());
		x=Integer.parseInt(st.nextToken());
		
		K=Integer.parseInt(st.nextToken());
		
		grid=new int[N][M];
		for(int i=0;i<4;i++) {
			vertical.add(0);
			horizontal.add(0);
		}
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				grid[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		st=new StringTokenizer(br.readLine());
		for(int k=0;k<K;k++) {
			int command=Integer.parseInt(st.nextToken());
			switch(command) {
			case 1:
				rotateRight();
				break;
			case 2:
				rotateLeft();
				break;
			case 3:
				rotateUp();
				break;
			case 4:
				rotateDown();
				break;
			}
		}
		
		
		String answer="";
		if(sb.length()>0)
			answer=sb.substring(0,sb.length()-1);
		
		System.out.println(answer);
		
	}
	
	static void rotateRight() {
		if(!checkAvailability(1))
			return;
		x++;
		
		//horizontal
		int temp=horizontal.get(3);
		horizontal.remove(3);
		horizontal.add(0,temp);
		//vertical
		vertical.set(0, horizontal.get(0));
		vertical.set(2, horizontal.get(2));
		
		interaction();
	}
	
	static void rotateLeft() {
		if(!checkAvailability(2))
			return;
		x--;
		
		//horizontal
		int temp=horizontal.get(0);
		horizontal.remove(0);
		horizontal.add(temp);
		//vertical
		vertical.set(0, horizontal.get(0));
		vertical.set(2, horizontal.get(2));
		
		interaction();
		
	}
	
	static void rotateUp() {
		if(!checkAvailability(3))
			return;
		y--;
		
		//vertical
		int temp=vertical.get(0);
		vertical.remove(0);
		vertical.add(temp);
		//horizontal
		horizontal.set(0, vertical.get(0));
		horizontal.set(2, vertical.get(2));
		
		interaction();
	}
	
	static void rotateDown() {
		if(!checkAvailability(4))
			return;
		y++;
		
		//horizontal
		int temp=vertical.get(3);
		vertical.remove(3);
		vertical.add(0,temp);
		//vertical
		horizontal.set(0, vertical.get(0));
		horizontal.set(2, vertical.get(2));
		
		interaction();
		
	}
	
	static boolean checkAvailability(int command) {
		switch(command) {
		case 1:
			if(x==M-1)
				return false;
			break;
		case 2:
			if(x==0)
				return false;
			break;
		case 3:
			if(y==0)
				return false;
			break;
		case 4:
			if(y==N-1)
				return false;
			break;
		}
		return true;
	}
	
	static void interaction() {
		if(grid[y][x]==0) {
			grid[y][x]=vertical.get(2);
		}
		else {
			vertical.set(2, grid[y][x]);
			horizontal.set(2, grid[y][x]);
			grid[y][x]=0;
		}
		sb.append(vertical.get(0)+"\n");
	}

}

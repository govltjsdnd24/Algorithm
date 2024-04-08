package d_april_08;

import java.io.*;
import java.nio.file.spi.FileSystemProvider;
import java.util.*;

class Snake{
	int r,c;
	
	public Snake(int r,int c) {
		this.r=r; this.c=c; 
	}
	
	@Override
	public boolean equals(Object obj) {
		Snake snake=(Snake)obj;
		if(snake.r==this.r && snake.c==this.c)
			return true;
		return false;
	}
}

class Apple{
	int r,c;
	
	public Apple(int r, int c) {
		this.r=r; this.c=c;
	}
	
	@Override
	public boolean equals(Object obj) {
		Apple apple=(Apple)obj;
		if(apple.r==this.r && apple.c==this.c)
			return true;
		return false;
	}
}

public class BAEKJOON_3190_뱀 {
	
	static int N,K; //size of board and number of apples
	static int L; //number of commands
	
	static List<Apple> apples;
	static Deque<Snake> snake= new ArrayDeque<Snake>();
	static int direction=0;
	
	
	static int []dr= {0,1,0,-1};
	static int []dc= {1,0,-1,0};
	
	static int answer=0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		
		st= new StringTokenizer(br.readLine());
		K=Integer.parseInt(st.nextToken());
		
		apples=new ArrayList<Apple>();
		snake.add(new Snake(0,0));
		
		for(int i=0;i<K;i++) {
			st= new StringTokenizer(br.readLine());
			apples.add(new Apple(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1));
		}
		
		st= new StringTokenizer(br.readLine());
		L=Integer.parseInt(st.nextToken());
		int temp=0;
		for(int i=0;i<L;i++) {
			st= new StringTokenizer(br.readLine());
			int time=Integer.parseInt(st.nextToken());
			char command=st.nextToken().charAt(0);
			
			for(int j=temp;j<time;j++) {
				int nr=snake.peekFirst().r+dr[direction];
				int nc=snake.peekFirst().c+dc[direction];
				
				answer++;
				if(nr>=N || nc>=N || nr<0 || nc<0 || isCollided(nr,nc)) {
					System.out.println(answer);
					return;
				}
				
				//move
				snake.addFirst(new Snake(nr,nc));
				if(apples.contains(new Apple(nr,nc))) 
					apples.remove(new Apple(nr,nc));
				else 
					snake.pollLast();
				temp=j+1;
			}
			switch(command) {
			case 'D':
				direction=Math.abs(direction+1)%4;
				break;
			case 'L':
				direction=Math.abs(direction+3)%4;
				break;
			}
		}
		for(int i=0;i<N;i++) {
			int nr=snake.peekFirst().r+dr[direction];
			int nc=snake.peekFirst().c+dc[direction];
			
			answer++;
			if(nr>=N || nc>=N || nr<0 || nc<0 || isCollided(nr,nc)) {
				System.out.println(answer);
				return;
			}
			
			//move
			snake.addFirst(new Snake(nr,nc));
			if(apples.contains(new Apple(nr,nc))) 
				apples.remove(new Apple(nr,nc));
			else 
				snake.pollLast();
		}
		System.out.println(answer);
	}
	
	static boolean isCollided(int nr,int nc) {
		if(snake.contains(new Snake(nr,nc))) {
			return true;
		}
		return false;
	}

}

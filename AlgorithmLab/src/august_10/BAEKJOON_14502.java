package august_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Square{
	private int r,c;
	Square(int r,int c){
		this.r=r;
		this.c=c;
	}
	public int getR() {
		return r;
	}
	public int getC() {
		return c;
	}
	@Override
	public String toString() {
		return "Square [r=" + r + ", c=" + c + "]";
	}
}

public class BAEKJOON_14502 {
	static int[][] lab;
	static boolean[][] visited;
	static int N,M;
	
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	
	static List<Square>walls=new ArrayList<Square>();
	static Square[] selections= new Square[3];
	static List<Square[]>combinations=new ArrayList<Square[]>();
	static List<Square>viruses=new ArrayList<Square>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
	
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		lab=new int[N][M];

		visited=new boolean[N][M];
		
		int i,j;
		
		for(i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(j=0;j<M;j++) {
				lab[i][j]=Integer.parseInt(st.nextToken());
				if(lab[i][j]==1)
					viruses.add(new Square(i,j));
				else if(lab[i][j]==0)
					walls.add(new Square(i,j));
			}
		}
		
		combRecursion(0,0);
//		System.out.println(combinations.get(0)[0]);
//		for(int qwe=0; qwe<combinations.size(); qwe++) {
//			System.out.println(combinations.get(qwe)[0]+" "+combinations.get(qwe)[1]+" "+combinations.get(qwe)[2]);
//		}

		Queue<Square>queue=new LinkedList<Square>();
		int max=Integer.MIN_VALUE;
		for(i=0;i<combinations.size();i++) {
			int[][]temp=new int[N][M];
			//copy original graph to copy
			for(j=0;j<N;j++)
				temp[j]=lab[j].clone();
			
			//plot in walls to graph
			for(j=0;j<3;j++) {
				int r=combinations.get(i)[j].getR();
				int c=combinations.get(i)[j].getC();
				temp[r][c]=1;
			}
			
			//do bfs
			max=Math.max(max,bfs(temp));
		}		
		System.out.println(max);
	}
	
	public static void combRecursion(int oIndex, int sIndex) {
		//basis
		if(sIndex==selections.length) {
			Square[] sTemp=selections.clone();
			combinations.add(sTemp);
			return;
		}
		
		//inductive
		for(int i=oIndex;i<walls.size();i++) {
			selections[sIndex]=walls.get(i);
			combRecursion(i+1,sIndex+1);
		}
	}
	
	public static int bfs(int[][]temp_o) {	
		int r,c,i,j,nr,nc;
		Square square;
		Queue<Square>queue=new LinkedList<Square>();
		
		int temp[][]=new int[N][M];
		for(i=0;i<N;i++)
			temp[i]=temp_o[i].clone();
		
		//put in viruses into queue
		for(i=0;i<viruses.size();i++)
			queue.offer(viruses.get(i));
		
		while(!queue.isEmpty()) {
			square= queue.poll();
			r=square.getR();
			c=square.getC();
			
			for(i=0;i<4;i++) {
				nr=r+dr[i];
				nc=c+dc[i];
				if(nr>=0 && nr<N && nc>=0 && nc<M && temp[nr][nc]==0 && !visited[nr][nc]) {
					visited[nr][nc]=true;
					temp[nr][nc]=2;
					queue.offer(new Square(nr,nc));
					System.out.println();
				}
			}
		}
		
		//check 0's in lab
		int counter=0;
		for(i=0;i<N;i++)
			for(j=0;j<M;j++)
				if(temp[i][j]==0)
					counter++;
		
//		for(int o=0;o<N;o++) {
//			for(int p=0;p<M;p++)
//				System.out.print(temp[o][p]);
//			System.out.println();
//		}
//		System.out.println();
		
		return counter;
	}
}

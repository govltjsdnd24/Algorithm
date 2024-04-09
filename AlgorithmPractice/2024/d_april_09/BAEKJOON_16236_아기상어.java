package d_april_09;

import java.io.*;
import java.util.*;

class Fish implements Comparable<Fish>{
	int r,c;
	int stockpile;
	int size;
	
	public Fish(int r,int c,int size) {
		this.r=r;this.c=c;this.size=size;
		this.stockpile=0; 
	}
	
	
	@Override
	public boolean equals(Object obj) {
		Fish fish=(Fish)obj;
		if(fish.r==this.r && fish.c==this.c && fish.size== this.size)
			return true;
		return false;
	}
	
	@Override
	public int compareTo(Fish fish) {
		return Integer.compare( this.size,fish.size);
	}
}

class Cell implements Comparable<Cell>{
	int r,c;
	public Cell(int r,int c) {
		this.r=r; this.c=c;
	}
	
	@Override
	public int compareTo(Cell cell) {
		if(cell.r==this.r)
			return Integer.compare( this.c,cell.c);
		return Integer.compare( this.r,cell.r);
	}
	
	@Override
	public String toString() {
		return "r: "+r+" c: "+c;
	}
}


public class BAEKJOON_16236_아기상어 {

	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	
	static int N;
	static int[][] grid;
	
	static Fish shark;
	static PriorityQueue<Fish> fishList=new PriorityQueue<Fish>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());

		N=Integer.parseInt(st.nextToken());
		
		grid=new int[N][N];
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				grid[i][j]=Integer.parseInt(st.nextToken());
				if(grid[i][j]==9) {
					shark=new Fish(i,j,2);
					grid[i][j]=0;
				}
				else if(grid[i][j]!=0) {
					fishList.add(new Fish(i,j,grid[i][j]));
				}
			}
		}
		
		System.out.println(bfs());
		
	}
	
	static int bfs() {
		boolean[][]visited;
		int stage=0;
		int answer=0;
		
		int length=fishList.size();
		for(int i=0;i<length;i++) {
			Queue<Cell>queue=new ArrayDeque<Cell>();
			queue.add(new Cell(shark.r,shark.c));
			visited=new boolean[N][N];
			List<Cell>edible=new ArrayList<Cell>();
			while(!fishList.isEmpty() && fishList.peek().size<shark.size) {
				
				//nowhere to traverse to
				if(queue.isEmpty()) {
					return answer;
				}
				int queueSize=queue.size();
				for(int step=0;step<queueSize;step++) {
					Cell current=queue.poll();
					
					//interaction
					if(grid[current.r][current.c]!=0) {
						if(grid[current.r][current.c]<shark.size) {
							edible.add(new Cell(current.r,current.c));
						}
					}
					
					//traversal
					for(int n=0;n<4;n++) {
						int nr=current.r+dr[n];
						int nc=current.c+dc[n];
						
						if(nr<N&&nc<N&&nr>=0&&nc>=0&&!visited[nr][nc]&&grid[nr][nc]<=shark.size) {
							queue.add(new Cell(nr,nc));
							visited[nr][nc]=true;
						}
					}
				}
				stage++;
				
//				print();
				if(!edible.isEmpty()) {
					edible.sort(null);
					//removal
					int r=edible.get(0).r;
					int c=edible.get(0).c;
					fishList.remove(new Fish(r,c,grid[r][c]));
					grid[r][c]=0;
					shark.r=r;
					shark.c=c;
					shark.stockpile++;
					if(shark.stockpile==shark.size) {
						shark.size++;
						shark.stockpile=0;
					}
					stage--;
					answer=stage;
					break;
				}
				
			}
		}
		
		return answer;
	}
	
	static void print() {
		for(int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
		System.out.println(shark.r+" "+shark.c);
		System.out.println();
	}

}

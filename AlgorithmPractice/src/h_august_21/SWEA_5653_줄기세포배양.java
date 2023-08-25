package h_august_21;

import java.io.*;
import java.util.*;




public class SWEA_5653_줄기세포배양 {
	static class Cell{
		int r,c,level,counter,rcounter;
		Cell(int r,int c){
			this(r,c,0);
		}
		
		Cell(int r,int c,int level){
			this.r=r; this.c=c; this.level = level;
			this.counter=level;
			
			this.rcounter=level;
		}
		void decreaseCounter() {
			counter--;
		} 
		
		@Override
		public boolean equals(Object obj) {
			Cell other = (Cell) obj;
			if (c != other.c)
				return false;
			if (r != other.r)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Cell [r=" + r + ", c=" + c + ", level=" + level + ", counter=" + counter + ", rcounter=" + rcounter
					+ "]";
		}
		
	}
	
	static ArrayList<Cell> active;
	static ArrayList<Cell> dormant;
	static int[][] container;
	
	static int[]dr= {1,-1,0,0};
	static int[]dc = {0,0,1,-1};
	
	static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());

		int T=Integer.parseInt(st.nextToken());
		
		int N,M;
		int i,j;
		
		for(int testcase=1;testcase<=T;testcase++) {
			st= new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			
			container= new int[N][M];
			active= new ArrayList<>();
			dormant= new ArrayList<>();
			
			for(i=0;i<N;i++) {
				st= new StringTokenizer(br.readLine());
				for(j=0;j<M;j++) {
					container[i][j]=Integer.parseInt(st.nextToken());
					if(container[i][j]!=0) 
						active.add(new Cell(i,j,container[i][j]));
				}
			}
			
			System.out.println("#"+testcase+" "+germinate());
			
		}
	}
	

	
	static int germinate() {
		
		int breadth=0;
		
		while(breadth!=K) {
			int size=active.size();
			int index=0;
			ArrayList<Cell>added=new ArrayList<>();
			while(--size>=0) {
				//find cell with counter==0
				Cell cell=null;
				for(int i=index;i<=index+size;i++) {
					if(active.get(i).counter==0 && active.get(i).rcounter==active.get(i).level && !added.contains(active.get(i))) {
						added.add(active.get(i));
						cell=active.get(i);
						break;
					}
				}
				System.out.println(cell);
				
				//if 세포's hibernation is done, move 4 ways
				if(cell!=null) {
					for(int i=0;i<4;i++) {
						int nr=cell.r+dr[i];
						int nc=cell.c+dc[i];
						Cell temp=new Cell(nr,nc);
						if(!active.contains(temp) && !dormant.contains(temp)) {
							//after that mark as visited
							active.add(new Cell(nr,nc,cell.level));
						}
						else if(active.contains(temp)){
							Cell compCell=active.get(active.indexOf(temp));
							if(compCell.level<cell.level && compCell.level==compCell.counter) {
								compCell.level=cell.level;
							}
						}
					}
					//move cell from active to dormant

					
					if(cell.rcounter==0) {
						active.remove(cell);
						dormant.add(cell);
					}
							
				}
				
				index++;
				
			}
			System.out.println();
			
			breadth++;
			//세포들 count down
			for(int i=0;i<active.size();i++) {
				if(active.get(i).counter>0 && (i<index || active.get(i).level>1))
					active.get(i).decreaseCounter();
				else if(active.get(i).counter==0)
					active.get(i).rcounter--;
			}
		}
		
		return active.size();
	}

}

package h_august_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_16919_봄버맨2 {
	static int R,C;
	static long N;
	static int[][] first;
	static int[][] second;
	static int[][] third;
	static int[][] fourth;
	static int[][] fifth;
	static boolean[][]visited;
	
	static int []dr= {1,-1,0,0};
	static int []dc = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		N=Long.parseLong(st.nextToken());
		
		first=new int[R][C];
		second=new int[R][C];
		third=new int[R][C];
		fourth=new int[R][C];
		fifth=new int[R][C];
		
		String line;
		for(int i=0;i<R;i++) {
			line=br.readLine();
			for(int j=0;j<C;j++) {
				if(line.charAt(j)=='.')
					first[i][j]=0;
				else if(line.charAt(j)=='O')
					first[i][j]=2;
			}
		}
		
		findPattern();
		
		if(N==1)
			printGrid(first);
		else if(N%2==0)
			printGrid(second);
		else if(N%4==3)
			printGrid(third);
		else if(N%4==1)
			printGrid(fifth);

		
	}
	public static void findPattern() {
		int i,j,k;
		
		//second pattern
		for(i=0;i<R;i++) {
			for(j=0;j<C;j++) {
				if(first[i][j]>0) 
					second[i][j]=first[i][j]-1;
				else if(first[i][j]==0)
					second[i][j]=3;
			}
		}
		
		int [][] temp= new int [R][C];
		
		//third pattern
		for(i=0;i<R;i++) {
			for(j=0;j<C;j++) {
				third[i][j]=second[i][j]-1;
			}
		}		
		for(i=0;i<R;i++) {
			temp[i]=third[i].clone();
		}
		for(i=0;i<R;i++) {
			for(j=0;j<C;j++) {
				if(temp[i][j]==0) {
					for(k=0;k<4;k++) {
						int nr=i+dr[k]; 
						int nc=j+dc[k];
						if(nr>=0 && nr<R && nc>=0 && nc<C ) {
							third[nr][nc]=0;
						}
					}
				}
			}
		}
		
		//fourth pattern
		for(i=0;i<R;i++) {
			for(j=0;j<C;j++) {
				if(third[i][j]>0) 
					fourth[i][j]=third[i][j]-1;
				else if(third[i][j]==0)
					fourth[i][j]=3;
			}
		}
		
		//fifth pattern
		for(i=0;i<R;i++) {
			for(j=0;j<C;j++) {
				fifth[i][j]=fourth[i][j]-1;
			}
		}
		for(i=0;i<R;i++) {
			temp[i]=fifth[i].clone();
		}
		
		for(i=0;i<R;i++) {
			for(j=0;j<C;j++) {
				if(temp[i][j]==0) {
					for(k=0;k<4;k++) {
						int nr=i+dr[k]; int nc=j+dc[k];
						if(nr>=0 && nr<R && nc>=0 && nc<C)
							fifth[i+dr[k]][j+dc[k]]=0;
					}
				}
			}
		}
		
		
	}
	
	public static void printGrid(int[][] grid) {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(grid[i][j]>0)
					System.out.print('O');
				else if(grid[i][j]==0)
					System.out.print('.');
			}
			System.out.println();
		}
	}
	
}

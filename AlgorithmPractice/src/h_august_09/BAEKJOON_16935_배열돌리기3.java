package h_august_09;

import java.util.*;

public class BAEKJOON_16935_배열돌리기3 {

	static int N,M;
	static int[][]grid;
	static int[][]temp;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N=scan.nextInt();
		M=scan.nextInt();
		int R=scan.nextInt();
		
		grid=new int[N][M];
		int i,j;
		for(i=0;i<N;i++) {
			for(j=0;j<M;j++) {
				grid[i][j]=scan.nextInt();
			}
		}
		
		for(i=0;i<R;i++) {
			int operation=scan.nextInt();
			
			
			switch(operation) {
			case 1:
				flipUpsideDown(R);
				break;
			case 2:
				flipLeftRight(R);
				break;
			case 3:
				rotateClockwise(R);
				break;
			case 4:
				rotateCounterClockwise(R);
				break;
			case 5:
				swapClockwise(R);
				break;
			case 6:
				swapCounterClockwise(R);
				break;
			}
			
			
		}
	}
	
	public static void flipUpsideDown(int times) {
		int i,j,k;
		temp=new int[N][M];
		
		for(i=0;i<times;i++) {
			//push in integers
			for(j=0;j<N;j++) {
				for(k=0;k<M;k++) {
					temp[N-j-1][k]=grid[j][k];
				}
			}
		}
		
		printGrid();
	}
	
	public static void flipLeftRight(int times) {
		int i,j,k;
		temp=new int[N][M];
		
		for(i=0;i<times;i++) {
			//push in integers
			for(j=0;j<N;j++) {
				for(k=0;k<M;k++) {
					temp[j][M-k-1]=grid[j][k];
				}
			}
		}
		
		printGrid();
	}
	
	
	
	public static void rotateClockwise(int times) {
		Queue<Integer> queue= new LinkedList<Integer>();
		int i,j,k;
		
		if(times%2==1)
			temp=new int[M][N];
		else
			temp=new int[N][M];
				
		for(i=0;i<times;i++) {
			//push in integers
			for(j=0;j<N;j++) {
				for(k=0;k<M;k++) {
					queue.offer(grid[j][k]);
				}
				for(k=0;k<M;k++) {
					temp[k][N-j-1]=queue.poll();
				}
			}
		}
		
		printGrid();
		
	}
	
	
	public static void rotateCounterClockwise(int times) {
		Stack<Integer> stack= new Stack<Integer>();
		int i,j,k;
		
		if(times%2==1)
			temp=new int[M][N];
		else
			temp=new int[N][M];
				
		for(i=0;i<times;i++) {
			//push in integers
			for(j=0;j<N;j++) {
				for(k=0;k<M;k++) {
					stack.push(grid[j][k]);
				}
				for(k=0;k<M;k++) {
					temp[k][j]=stack.pop();
				}
			}
		}
		
		printGrid();
		
	}
	
	public static void swapClockwise(int times) {
		int i,j,k,l;
		temp=new int[N][M];
		
		int []sr= {0,0,N/2,N/2};
		int []sc= {0,M/2,M/2,0};
		
		for(i=0;i<times;i++) {
			//push in integers
			for(j=0;j<4;j++) {
				for(k=0;k<N/2;k++) {
					for(l=0;l<M/2;l++) {
						temp[k+sr[(j+1)%4]][l+sc[(j+1)%4]]=grid[sr[j]+k][sc[j]+l];
					}
				}
			}
		}
		
		printGrid();
		
	}
	
	public static void swapCounterClockwise(int times) {
		int i,j,k,l;
		temp=new int[N][M];
		
		int []sr= {0,N/2,N/2,0};
		int []sc= {0,0,M/2,M/2};
		
		for(i=0;i<times;i++) {
			//push in integers
			for(j=0;j<4;j++) {
				for(k=0;k<N/2;k++) {
					for(l=0;l<M/2;l++) {
						temp[k+sr[(j+1)%4]][l+sc[(j+1)%4]]=grid[sr[j]+k][sc[j]+l];
					}
				}
			}
		}
		
		printGrid();
		
	}
	
	
	
	
	
	public static void printGrid() {
		for(int i=0;i<temp.length;i++) {
			for(int j=0;j<temp[0].length;j++) {
				System.out.print(temp[i][j]);
				if(j!=M-1)
					System.out.print(" ");
			}
			System.out.println();
		}
	}

}

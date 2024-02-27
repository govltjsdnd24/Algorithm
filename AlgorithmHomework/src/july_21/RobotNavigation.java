package july_21;

import java.util.Scanner;

class Movement{
	private char [][]map;
	private final static int[] dr= {0,0,1,-1}; //우좌후상
	private final static int[] dc= {1,-1,0,0};
	
	public Movement(char[][] map) {
		super();
		this.map = map;
	}
	
	public char[][] getMap() {
		return map;
	}
	public void setBlock(int y,int x,char content) {
		this.map[y][x]=content;
	}
	
	public int checkCount() {
		int output=0;
		int sr,sc,i;
		for(sr=0;sr<map.length;sr++) {
			for(sc=0;sc<map.length;sc++) {
				if(map[sr][sc]=='A') {
					output=visit(sr,sc,output,0);
				}
				else if(map[sr][sc]=='B') {
					for(i=0;i<2;i++)
						output=visit(sr,sc,output,i);
				}
				else if(map[sr][sc]=='C') {
					for(i=0;i<4;i++)
						output=visit(sr,sc,output,i);
				}
			}
		}
		return output;
	}
	
	private int visit(int sr,int sc,int count,int dir) {
		int moves=0;
		
		while(true) {
			int r,c;
			r=sr+dr[dir];
			c=sc+dc[dir];
			moves++;
			if(r>=map.length ||r<0||c>=map.length||c<0||map[r][c]=='W')
				break;
			sr=r;
			sc=c;
		}
		
		return moves;
	}
	
}

public class RobotNavigation {

	public static void main(String[] args) {
		int N;
		int test_case,t;
		
		int i,j;
		
		Scanner sc= new Scanner(System.in);
		t=sc.nextInt();
		
		
		for(test_case=1;test_case<=t;test_case++) {
			N=sc.nextInt();
			Movement mv=new Movement(new char[N][N]);
			
			//S is space, W is a wall, A/B/C are robots
			for(i=0;i<N;i++) {
				for(j=0;j<N;j++) {
					mv.setBlock(i,j,sc.next().charAt(0));
				}
			}
			
			System.out.println("#"+test_case+" "+mv.checkCount());

		}

	}

}

package h_august_14;

import java.io.*;
import java.util.StringTokenizer;

class Tank{
	int r,c,d;
	
	public Tank(int r, int c, int d){
		this.r=r;this.c=c; this.d=d;
	}

	public int getR() {
		return r;
	}

	public int getC() {
		return c;
	}

	public int getD() {
		return d;
	}
	public void setD(int d) {
		this.d=d;
	}

	public void setR(int r) {
		this.r = r;
	}

	public void setC(int c) {
		this.c = c;
	}
	
}

public class SWEA_1873_상호의배틀필드 {

	static char[][] battlefield;
	static char[] commands;
	static Tank tank;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	
	static int H,W,N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int T=Integer.parseInt(st.nextToken());
		int i,j;
		String line;
		
		for(int test_case=1;test_case<=T;test_case++) {
			st= new StringTokenizer(br.readLine());
			H=Integer.parseInt(st.nextToken());
			W=Integer.parseInt(st.nextToken());
			
			battlefield=new char[H][W];
			for(i=0;i<H;i++) {
				line=br.readLine();
				for(j=0;j<W;j++) {
					battlefield[i][j]=line.charAt(j);
					switch(battlefield[i][j]) {
					case '^':
						tank=new Tank(i,j,0); break;
					case 'v': 
						tank=new Tank(i,j,1); break;
					case '<':
						tank=new Tank(i,j,2); break;
					case '>':
						tank=new Tank(i,j,3); break;
					}
					
				}
			}
			st= new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			line=br.readLine();
			
			for(i=0;i<N;i++)
				executeCommand(line.charAt(i));
			
			
			System.out.print("#"+test_case+" ");
			for(i=0;i<H;i++) {
				for(j=0;j<W;j++) {
					System.out.print(battlefield[i][j]);
				}
				System.out.println();
			}
				
			
			
		}
		

	}
	
	static void executeCommand(char command){
		int r,c,current,nr,nc;
		r=tank.getR();
		c=tank.getC();
		
		if(command=='S') {
			while(true) {
				r+=dr[tank.getD()];
				c+=dc[tank.getD()];
				if(r<0 || r>=H || c< 0 || c>=W)
					break;
				current=battlefield[r][c];
				if(current=='#')
					break;
				else if(current=='*') {
					battlefield[r][c]='.';
					break;
				}
			}
		}
		else {
			switch(command) {
			case 'U':
				battlefield[tank.getR()][tank.getC()]='^';
				tank.setD(0);
				break;
			case 'D':
				battlefield[tank.getR()][tank.getC()]='v';
				tank.setD(1);
				break;
			case 'L':
				battlefield[tank.getR()][tank.getC()]='<';
				tank.setD(2);
				break;
			case 'R':
				battlefield[tank.getR()][tank.getC()]='>';
				tank.setD(3);
				break;
			}
			
			nr=r+dr[tank.getD()];
			nc=c+dc[tank.getD()];
			
			if(nr>=0 && nr<H && nc>= 0 && nc<W && battlefield[nr][nc]=='.') {
				tank.setR(nr);
				tank.setC(nc);
				battlefield[nr][nc]=battlefield[r][c];
				battlefield[r][c]='.';
			}
			
			
		}
	}

}

package h_august_17;

import java.util.Arrays;
import java.util.Scanner;

class Pipe{
	private int sr,sc,er,ec,d;
	public Pipe() {
		this.sr=1; this.sc=1;
		this.er=1; this.ec=2;
		this.d=0;
	}
	public Pipe(int sr,int sc,int er,int ec,int d) {
		this.sr=sr; this.sc=sc;
		this.er=er; this.ec=ec;
		this.d=d;
	}
	public int getSr() {return sr;}
	public int getSc() {return sc;}
	public int getEr() {return er;}
	public int getEc() {return ec;}
	public int getD() {return d;}
	@Override
	public String toString() {
		return "Pipe [sr=" + sr + ", sc=" + sc + ", er=" + er + ", ec=" + ec + ", d=" + d + "]";
	}
}

public class BAEKJOON_17070_파이프옮기기1 {

	static int N;
	static int[][]house;
	static int count=0;
	
	
	static int[][] ds=new int[3][];
	static int[] dr= {0,1,1};
	static int[] dc= {1,1,0};
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		N=scan.nextInt();
		house= new int[N+1][N+1];
		
		//0: right, 1: diagonal, 2:down
		ds[0]= new int[] {0,1};
		ds[1]= new int[] {0,1,2};
		ds[2]= new int[] {1,2};
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				house[i][j]=scan.nextInt();
			}
		}
		
		pipeTraverse(new Pipe());
		System.out.println(count);
		scan.close();
	}
	
	static void pipeTraverse(Pipe pipe) {
		//pruning
		if(!isAvailable(pipe)) {
			return;
		}
		
		//end condition
		if(pipe.getEr()==N && pipe.getEc()==N) {
			count++;
			return;
		}
		
		//inductive part
		int sr,sc,er,ec;
		for(int i:ds[pipe.getD()]) {
			sr=pipe.getSr()+dr[pipe.getD()];
			sc=pipe.getSc()+dc[pipe.getD()];
			er=pipe.getEr()+dr[i];
			ec=pipe.getEc()+dc[i];
			if(er<=N && ec<=N) {
				pipeTraverse(new Pipe(sr,sc,er,ec,i));
			}
		}
	}
	
	static boolean isAvailable(Pipe pipe) {
		for(int i=pipe.getSr();i<=pipe.getEr();i++) {
			for(int j=pipe.getSc();j<=pipe.getEc();j++) {
				if(house[i][j]==1)
					return false;
			}
		}
		return true;
	}

}

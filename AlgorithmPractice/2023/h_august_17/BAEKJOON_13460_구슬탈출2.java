package h_august_17;

import java.util.*;

class Slot{
	private int r,c;
	public Slot(int r,int c) {
		this.r=r;this.c=c;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
}

public class BAEKJOON_13460_구슬탈출2 {
	static int N,M;
	static char[][] marbles;
	static Slot blue,red,out;
	static int moves=0;
	
	static int[]dr= {1,-1,0,0};
	static int[]dc= {0,0,1,-1};

	public static void main(String[] args) {
		Scanner scan= new Scanner (System.in);
		N=scan.nextInt();
		M=scan.nextInt();
		
		
		
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++) {
				marbles[i][j]=scan.next().charAt(0);
				switch(marbles[i][j]) {
				case 'B':
					blue=new Slot(i,j);
					break;
				case 'R':
					red=new Slot(i,j);
					break;
				case 'O':
					out=new Slot(i,j);
					break;
				}
			}
		
		marbleEscape();
		
		
		scan.close();
	}
	
	public static void marbleEscape() {
		Queue<Slot> rQueue =new LinkedList<Slot>();
		Queue<Slot> bQueue =new LinkedList<Slot>();
		rQueue.offer(red);
		bQueue.offer(blue);
		int counter=0;
		
		Slot sRed,sBlue;
		while(!rQueue.isEmpty() && counter<=10) {
			sRed=rQueue.poll();
			sBlue=bQueue.poll();
			
			int rr,rc,br,bc;
			for(int i=0;i<4;i++) {
				while(true) {
					rr=red.getR()+dr[i];
					rc=red.getC()+dc[i];
					if(marbles[rr][rc]=='#') {
						red.setR(rr-dr[i]);
						red.setC(rc-dc[i]);
						break;
					}
					else if(marbles[rr][rc]=='O') {
						
					}
				}
			}
		}
	}

}

//int rr,rc,br,bc;
//for(int i=0;i<4;i++) {
//	while(rr==0) {
//		rr=red.getR()+dr[i];
//		rc=red.getC()+dc[i];
//	}
//	br=blue.getR()+dr[i];
//	bc=blue.getC()+dc[i];
//	
//}

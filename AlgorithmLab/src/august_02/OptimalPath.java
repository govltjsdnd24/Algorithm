package august_02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Point{
	int r,c;
	public Point(int r,int c) {
		this.r=r;
		this.c=c;
	}
	@Override
	public String toString() {
		return "Point [r=" + r + ", c=" + c + "]";
	}
	
}

public class OptimalPath {

	static int T,N,Ans;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("최적경로.txt"));
		Scanner scan= new Scanner(System.in);
		T=scan.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			Ans= Integer.MAX_VALUE;
			N=scan.nextInt();
			
			Point company = new Point(scan.nextInt(), scan.nextInt());
			Point home = new Point(scan.nextInt(),scan.nextInt());
			Point [] customers = new Point[N];
			
			for (int i = 0; i < customers.length; i++) {
				customers[i]= new Point(scan.nextInt(), scan.nextInt());
			}
			recursive(customers,0,new Point[N],new boolean[N],company,home);
			
			System.out.printf("#%d %d\n",tc,Ans);
		}

	}
	private static void recursive (Point[] customers, int idx, Point[] sel, boolean[] v, Point company, Point home) {
		//basis part
		//inductive part의 선택을 N번 했다면
		if(idx==N) {
			
			//sel[]은 고객방문 순서를 의미합니다
			// 회사 + 고객 방문 순서+집
			int dist=0;
			dist+=Math.abs(company.c- sel[0].c)+ Math.abs(company.r-sel[0].r);
			//고객의 집
			for(int i=1;i<customers.length;i++) {
				dist+= Math.abs(sel[i-1].r - sel[i].r) + Math.abs(sel[i-1].c-sel[i].c);
			}
			dist+=Math.abs(sel[sel.length-1].c- home.c)+ Math.abs(sel[sel.length-1].r-home.r);
			Ans=Math.min(Ans, dist);
		}
		
		//inductive part
		//어느 고객에게 갈껀지 선택 (가지)
		
		for (int i = 0; i < customers.length; i++) {
			if(v[i]==false) {
				sel[idx]=customers[i];
				v[i]=true;
				recursive(customers, idx+1, sel, v,company,home);
				v[i]=false;
			}
		}
	}

}

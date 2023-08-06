package august_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class fish{
	private int r,c,size;
	
	public fish(int r,int c,int size) {
		this.r=r; this.c=c;
	}
	
	public int getR() {return r;}
	public int getC() {return c;}
	public int getSize() {return size;}
}


public class BAEKJOON_16236 {
	
	static int[][] sea;
	static int N;
	static fish sharkPos;
	static List<fish> fishPos=new ArrayList<fish>();

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		N=scan.nextInt();
		
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < N; j++) {
				sea[i][j]=scan.nextInt();
				if(sea[i][j]==9)
					sharkPos=new fish(i,j,2);
				else if(sea[i][j]>0)
					fishPos.add(new fish(i,j,sea[i][j]));
			}
		
		fishRecursion(0);

	}
	
	private static void fishRecursion(int timer) {
		if(fishPos.isEmpty()|| fishPos.) {
			System.out.println(timer);
			return;
		}
		
		
	}

}

package g_july_24;

import java.util.Scanner;

class Snail{
	private int n;
	private int grid[][];
	
	public Snail(int n) {
		this.n=n;
		grid=new int[n][n];
	}
	
	public void drawSnail() {
		int i,j;
		plotSnail();
		for(i=0;i<n;i++) {
			for(j=0;j<n;j++) {
				System.out.print(grid[i][j]);
				if(j<n-1)
					System.out.print(" ");
			}
			System.out.println();
		}
			
	}
	private void plotSnail() {
		int i;
		int h_track=0; int v_track=0;
		int counter=1; 
		
		while(h_track<(n-h_track)) {
			for(i=h_track;i<n-h_track;i++)
				grid[v_track][i]=counter++;
			for(i=v_track+1;i<n-v_track-1;i++) 
				grid[i][n-h_track-1]=counter++;
			for(i=n-h_track-1;i>h_track;i--)
				grid[n-v_track-1][i]=counter++;
			for(i=n-v_track-1;i>v_track;i--)
				grid[i][h_track]=counter++;
			h_track++; v_track++;
		}
	}
}

public class JUNGOL_1707 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Snail s=new Snail(sc.nextInt());
		s.drawSnail();
	}
}

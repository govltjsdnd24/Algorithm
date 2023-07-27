package july_24;

import java.util.Scanner;

class Triangle{
	private int n;
	
	public Triangle(int n) {
		this.n=n;
	}
	
	public void drawRightArrow() {
		int i,j;
		for(i=1;i<=n;i++) {
			if(i<=n/2) {
				for(j=1;j<i;j++)
					System.out.print(" ");
				for(j=1;j<=i*2-1;j++)
					System.out.print("*");
			}
			else {
				for(j=1;j<=n-i;j++)
					System.out.print(" ");
				for(j=1;j<=(n-i+1)*2-1;j++)
					System.out.print("*");
			}
			System.out.println();
		}
	}
}
public class JUNGOL_1329 {

	public static void main(String[] args) {
		int N;
		Scanner sc= new Scanner(System.in);
		N=sc.nextInt();
		if(N>100 || N<0 ||N%2==0)
			System.out.println("INPUT ERROR!");
		else {
			Triangle tri=new Triangle(N);
			tri.drawRightArrow();
		}
		sc.close();
	}
}

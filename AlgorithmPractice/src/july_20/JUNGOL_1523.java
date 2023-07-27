package july_20;

import java.util.Scanner;

//class Triangle{
//	private int i,j=0;
//
//	public int getI() {
//		return i;
//	}
//
//	public int getJ() {
//		return j;
//	}
//	
//}

class RightTriangle extends Triangle{
	int i=getI(); int j=getJ();
	public void drawRightTri(int height) {
		for(i=1;i<=height;i++) {
			for(j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

class InverseRightTriangle extends Triangle{
	int i=getI(); int j=getJ();
	public void drawInvRightTri(int height) {
		for(i=height;i>=1;i--) {
			for(j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

class IsoscelesTriangle extends Triangle {
	int i=getI(); int j=getJ();
	public void drawIsoTri(int height) {
		for(i=height;i>=1;i--) {
			for(j=1;j<i;j++) {
				System.out.print(" ");
			}
			for(j=1;j<=2*(height-i+1)-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}


public class JUNGOL_1523 {
	
	public static void main(String[] args) {
		int n,m;
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();
		
		if(n>100||n<0 || m>3||m<1) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		switch(m) {
			case 1:
				RightTriangle rt=new RightTriangle();
				rt.drawRightTri(n);
				break;
			case 2:
				InverseRightTriangle irt=new InverseRightTriangle();
				irt.drawInvRightTri(n);
				break;
			case 3:
				IsoscelesTriangle it=new IsoscelesTriangle();
				it.drawIsoTri(n);
				break;
		}
	}
}

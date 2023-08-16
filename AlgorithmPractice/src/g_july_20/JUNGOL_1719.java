package g_july_20;

import java.util.Scanner;

class Triangle{
	private int i,j=0;
	private int height;

	public int getI() {
		return i;
	}
	public int getJ() {
		return j;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}

class RightArrowHead extends Triangle{
	int i=getI(); int j=getJ(); 
	
	public void drawRightAH() {
		int height=getHeight();
		
		for(i=1;i<=height;i++) {
			if(i<=height/2) {
				for(j=1;j<=i;j++)
					System.out.print("*");
			} else {
				for(j=height-i;j>=0;j--)
					System.out.print("*");
			}
			System.out.println();
		}
	}
}

class LeftArrowHead extends Triangle{
	int i=getI(); int j=getJ();
	
	public void drawLeftAH() {
		int height=getHeight();
		
		for(i=1;i<=height;i++) {
			if(i<=height/2) {
				for(j=0;j<=height/2-i;j++)
					System.out.print(" ");
				for(j=1;j<=i;j++)
					System.out.print("*");
			} else {
				for(j=1;j<i-height/2;j++)
					System.out.print(" ");
				for(j=1;j<=height-i+1;j++)
					System.out.print("*");
			}
			System.out.println();
		}
	}
}

class HourGlass extends Triangle {
	int i=getI(); int j=getJ(); 
	
	public void drawHG() {
		int height=getHeight();
		
		for(i=1;i<=height;i++) {
			if(i<=height/2) {
				for(j=1;j<i;j++)
					System.out.print(" ");
				for(j=1;j<=height-2*(i-1);j++)
					System.out.print("*");
			} else {
				for(j=0;j<height-i;j++)
					System.out.print(" ");
				for(j=1;j<2*(i-height/2)+(height+1)%2;j++)
					System.out.print("*");
			}
			System.out.println();
		}
	}
}

class SlantedHourGlass extends Triangle {
	int i=getI(); int j=getJ(); 
	
	public void drawSlantedHG() {
		int height=getHeight();
		
		for(i=1;i<=height;i++) {
			if(i<=height/2) {
				for(j=1;j<i;j++)
					System.out.print(" ");
				for(j=0;j<=height/2-i+height%2;j++)
					System.out.print("*");
			} else {
				for(j=0;j<height/2-(height+1)%2;j++)
					System.out.print(" ");
				for(j=1;j<=(i-height/2)+(height+1)%2;j++)
					System.out.print("*");
			}
			System.out.println();
		}
	}
}

public class JUNGOL_1719 {
	
	public static void main(String[] args) {
		int n,m;
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();
		
		if(n>100||n<0 || m>4||m<1 || n%2==0) {
			System.out.println("INPUT ERROR!");
			return;
		}
		switch(m) {
		case 1:
			RightArrowHead rah=new RightArrowHead();
			rah.setHeight(n);
			rah.drawRightAH();
			break;
		case 2:
			LeftArrowHead lah=new LeftArrowHead();
			lah.setHeight(n);
			lah.drawLeftAH();
			break;
		case 3:
			HourGlass hg=new HourGlass();
			hg.setHeight(n);
			hg.drawHG();
			break;
		case 4:
			SlantedHourGlass shg=new SlantedHourGlass();
			shg.setHeight(n);
			shg.drawSlantedHG();
			break;
		}
	}

}

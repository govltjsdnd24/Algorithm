package august_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Fish{
	private int r,c,size;
	
	public Fish(int r,int c,int size) {
		this.r=r; this.c=c;this.size=size;
	}
	
	public int getR() {return r;}
	public int getC() {return c;}
	public void setR(int r) {this.r=r;}
	public void setC(int c) {this.c=c;}
	public int getSize() {return size;}
}

class Shark extends Fish{
	private int count;
	public Shark(int r,int c, int size) {
		super(r,c,size);
	}
	public void countUp() {count++;}
	public int getCount(){return count;}
	public boolean comparePos(Fish fish) {
		return (fish.getC()==this.getC() && fish.getR() == this.getR());		
	}
}


public class BAEKJOON_16236 {
	
	static int[][] sea;
	static int N;
	static Shark shark;
	static List<Fish>[] fish=new ArrayList[7];

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		N=scan.nextInt();
		
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < N; j++) {
				sea[i][j]=scan.nextInt();
				if(sea[i][j]==9)
					shark=new Shark(i,j,2);
				else if(sea[i][j]>0)
					fish[sea[i][j]].add(new Fish(i,j,sea[i][j]));
			}
		
		fishRecursion(0);
		scan.close();
	}
	
	private static void fishRecursion(int timer) {
		if(fish[shark.getSize()].isEmpty()) {
			System.out.println(timer);
			return;
		}
		
		if(shark.comparePos(fish[shark.getSize()]))
		

		if(fish[shark.getSize()].get(0).getC()>shark.getC())
			shark.setC(shark.getC()+1);
		else if(fish[shark.getSize()].get(0).getC()<shark.getC())
			shark.setC(shark.getC()-1);
		if(fish[shark.getSize()].get(0).getR()>shark.getR())
			shark.setC(shark.getR()+1);
		else if(fish[shark.getSize()].get(0).getR()<shark.getR())
			shark.setC(shark.getR()-1);
		
		fishRecursion(timer+1);
	}

}

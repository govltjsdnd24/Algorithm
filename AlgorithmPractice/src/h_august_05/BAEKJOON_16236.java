package h_august_05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Fish implements Comparable<Fish>{
	private int r,c,size;
	
	public Fish(int r,int c,int size) {
		this.r=r; this.c=c;this.size=size;
	}
	
	public int getR() {return r;}
	public int getC() {return c;}
	public void setR(int r) {this.r=r;}
	public void setC(int c) {this.c=c;}
	public int getSize() {return size;}
	public void setSize(int size) {this.size=size;}
	
	@Override
	public int compareTo(Fish fish) {
		if(this.getR()==fish.getR())
			if(this.getC()>fish.getC())
				return 1;
		if(this.getR()>fish.getR())
			return 1;
		else 
			return -1;
	}
}

class Shark extends Fish{
	private int count;
	public Shark(int r,int c, int size) {
		super(r,c,size);
	}
	public void countUp() {
		if(++count==getSize())
			setSize(getSize()+1);
	}
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
		sea=new int[N][N];
		for (int i = 1; i <= 6; i++) {
			fish[i]=new ArrayList<Fish>();
		}
		
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
		if(fish[shark.getSize()-1].isEmpty()) {
			System.out.println(timer);
			return;
		}
		
		//if shark reaches fish( that's smaller than it)
		if(shark.comparePos(fish[shark.getSize()-1].get(0))) {
			fish[shark.getSize()-1].remove(0);
			//if the shark grows in size, but there are still lower-size fish left
			fishReshuffle();
			shark.countUp();
		}
		else {
			//move
			if(fish[shark.getSize()-1].get(0).getC()>shark.getC()) {
				shark.setC(shark.getC()+1); timer++;
			}
			else if(fish[shark.getSize()-1].get(0).getC()<shark.getC()) {
				shark.setC(shark.getC()-1); timer++;
			}
			if(fish[shark.getSize()-1].get(0).getR()>shark.getR()) {
				shark.setR(shark.getR()+1); timer++;
			}
			else if(fish[shark.getSize()-1].get(0).getR()<shark.getR()) {
				shark.setR(shark.getR()-1); timer++;
			}
		}
		
		fishRecursion(timer);
	}
	
	public static void fishReshuffle() {
		if(!fish[shark.getSize()-1].isEmpty())
			for(int i=0;i<fish[shark.getSize()-1].size();i++) {
				shark.getSize();
				fish[shark.getSize()].add(fish[shark.getSize()-1].get(i));
			}
		
			Collections.sort(fish[shark.getSize()]);
	}

}

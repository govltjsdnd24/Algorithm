package h_august_18;

import java.util.Scanner;

class Egg{
	private int durability, weight;
	public Egg(int S, int W) {
		durability=S; weight=W;
	}
	public int getDurability() {
		return durability;
	}
	public void setDurability(int durability) {
		this.durability = durability;
	}
	public int getWeight() {
		return weight;
	}
}

public class BAEKJOON_16987_계란으로계란치기 {
	static int N;
	static Egg[] eggs;
	static int max=0;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		N=scan.nextInt();
		int i;
		eggs= new Egg[N];
		for(i=0;i<N;i++) {
			eggs[i]=new Egg(scan.nextInt(), scan.nextInt());
		}
		
		eggCollision(0,0);
		System.out.println(max);
		scan.close();
	}
	
	private static void eggCollision(int index, int breaks) {
		if(index==N) {
			max=Math.max(max, breaks);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(index!=i) {
				if(durabCheck(eggs[index]) && durabCheck(eggs[i])) {
					int temp=breaks;
					eggs[index].setDurability(eggs[index].getDurability()-eggs[i].getWeight());
					eggs[i].setDurability(eggs[i].getDurability()-eggs[index].getWeight());
					if(!durabCheck(eggs[index]))
						temp++;
					if(!durabCheck(eggs[i]))
						temp++;
					eggCollision(index+1,temp);
					eggs[index].setDurability(eggs[index].getDurability()+eggs[i].getWeight());
					eggs[i].setDurability(eggs[i].getDurability()+eggs[index].getWeight());
				}
				else
					eggCollision(index+1,breaks);
			}
		}
	}
	
	private static boolean durabCheck(Egg egg) {
		if(egg.getDurability()>0)
			return true;
		else return false;
	}

}

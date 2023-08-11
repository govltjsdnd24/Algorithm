package h_august_03;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class rcPair{
	private int r,c;
	
	public rcPair(int r,int c) {
		this.r=r; this.c=c;
	}

	public int getR() {return r;}
	public int getC() {return c;}
	@Override
	public String toString() {
		return "<" + r + ", " + c + ">";
	}
}


public class BAEKJOON_15686 {
	static int[][]town;
	static int N,M;
	static List<rcPair> stores=new ArrayList<rcPair>();
	static List<rcPair> houses=new ArrayList<rcPair>();
	static rcPair[] selection;
	static List<Integer> chickenDistances=new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();
		M= scan.nextInt();
		town= new int[N][N];
		int i,j;
		
		for(i=0;i<N;i++) 
			for(j=0;j<N;j++) {
				town[i][j]=scan.nextInt();
				if(town[i][j]==2) 
					stores.add(new rcPair(j,i));
				else if(town[i][j]==1)
					houses.add(new rcPair(j,i));
			}
		
		selection= new rcPair[M];
		
		//make combinations of the stores
		combRecursion(0,0);
		
		System.out.println(Collections.min(chickenDistances));
	
	}
	
	
	public static void combRecursion(int origIndex,int selIndex) {
		if(selIndex==selection.length) {
			chickenDistances.add(findChickenDist());
			return;
		}
		
		for (int index = origIndex; index < stores.size(); index++) {
			selection[selIndex]=stores.get(index);
			combRecursion(index+1, selIndex+1);
		}
	}
	
	
	public static int findChickenDist() {
		int[] houseDistances=new int[houses.size()];
		Arrays.fill(houseDistances, Integer.MAX_VALUE);
		
		int difference,sum=0;
		
		for (int i = 0; i < selection.length; i++) {
			for (int j = 0; j < houses.size(); j++) {
				difference=Math.abs(selection[i].getR()-houses.get(j).getR())+Math.abs(selection[i].getC()-houses.get(j).getC());
				houseDistances[j]=Math.min(houseDistances[j], difference);
			}
		}
		
		for (int i = 0; i < houseDistances.length; i++) 
			sum+=houseDistances[i];
		
		return sum;
	}

}

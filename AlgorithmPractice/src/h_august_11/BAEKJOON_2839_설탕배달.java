package h_august_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class BAEKJOON_2839_설탕배달 {
	static int[] kg= {3,5};
	static int N;
	static List<Integer> combinations=new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		N=scan.nextInt();
		System.out.println(recursion(N,0));
	}
	
	public static int sugGreed() {
		if(N<=2)
			return -1;
		int temp=N;
		int count=0;
		while(true) {
			if(temp>=5) {
				temp-=5;
				count++;
			}
		}
		
	}
	
	
	
	public static int sugarGreedy() {
		int bags=0;
		int temp=N;
		
		if ((temp%5)%3<3 || temp%5==0 ) {
			bags+=(temp%5)%3;
			temp/=5;
			bags+=temp;
			temp/=3;
			bags+=temp;
		}
		else if((temp%3)%5<3 || temp%3==0 ) {
			bags+=(temp%3)%5;
			temp/=3;
			bags+=temp;
			temp/=5;
			bags+=temp;
		}
		else
			bags=-1;
		
		return bags;
	}
	
	
	
	
	
	
	
	
	private static int recursion(int carriable,int count) {
		if(carriable<0)
			return -1;
		if(carriable==0)
			return count;
		
		return (Math.max(recursion(carriable-3,count+1), recursion(carriable-5,count+1)));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

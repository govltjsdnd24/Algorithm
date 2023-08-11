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
	
	private static int recursion(int carriable,int count) {
		if(carriable<0)
			return -1;
		if(carriable==0)
			return count;
		
		return (Math.max(recursion(carriable-3,count+1), recursion(carriable-5,count+1)));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

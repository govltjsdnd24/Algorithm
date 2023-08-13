package h_august_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class BAEKJOON_2839_설탕배달 {
	static int N;
	
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		N=scan.nextInt();
		System.out.println(deliverSugar());
	}
	
	private static int deliverSugar() {
		int count;
		
		if(N==4 ||N==7 || N<3)
			return -1;
		
		count=N/5;
		switch(N%5) {
		case 1: case 4:
			count+=checkThrees(N%5+5)-1;
			break;
		case 2:
			count+=checkThrees(N%5+10)-2;
			break;
		case 3:
			count+=checkThrees(N%5);
			break;
		default:
			break;
		}
		return count;
	}
	
	private static int checkThrees(int num) {
		return num/3;
	}
	
	
//	private static int recursion(int carriable,int count) {
//	if(carriable<0)
//		return -1;
//	if(carriable==0)
//		return count;
//	
//	return (Math.max(recursion(carriable-3,count+1), recursion(carriable-5,count+1)));
//}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

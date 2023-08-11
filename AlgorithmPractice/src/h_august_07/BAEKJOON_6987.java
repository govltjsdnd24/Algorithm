package h_august_07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


public class BAEKJOON_6987 {
	
	static int [][][] distribution=new int [4][6][3];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i,j,k;
		
		for(i=0;i<4;i++) 
			for (j=0;j<6;j++) 
				for(k=0;k<3;k++)
					distribution[i][j][k]=scan.nextInt();
		
		int [] results=resultChecker();
		
		for(i=0;i<4;i++) {
			System.out.print(results[i]);
			if(i<3)
				System.out.print(" ");
		}
	}
	
	public static int[] resultChecker() {
		int []output=new int [4];
		int i,j,k;
		int wSum,dSum,lSum,cellSum=0;
		List<Integer>draws;
		AtomicInteger max=new AtomicInteger(),rest=new AtomicInteger();
		
		for(i=0;i<4;i++) { //rounds
			wSum=0;dSum=0;lSum=0;
			draws=new ArrayList<Integer>();
			max.set(0);rest.set(0);
			
			for (j=0;j<6;j++) { //countries
				cellSum=0;
				for(k=0;k<3;k++) { //wdl
					//get win,draw, lose sums
					cellSum+=distribution[i][j][k];
					switch(k) {
					case 0: wSum+=distribution[i][j][k]; break;
					case 1: dSum+=distribution[i][j][k]; 
					draws.add(distribution[i][j][k]);break;
					case 2: lSum+=distribution[i][j][k]; break;
					}
				}
				if(cellSum!=5)
					break;
			}
			
			int temp=0;
			for(int l=0;l<draws.size();l++) 
				if(draws.get(l)>0) 
					temp++;
			
			if(cellSum!=5)
				output[i]=0;
			drawMax(draws,max,rest);
			
			if((wSum!= lSum) || (wSum+dSum+lSum!=30) || (dSum%2!=0) || (temp==1)) {
				output[i]=0;
			}
			else if(drawMax(draws,max,rest)==1 && max.intValue()>rest.intValue()) {
				output[i]=0;
			}
			else 
				output[i]=1;
			
		}
		
		return output;
	} //end result checker
	
	public static int drawMax(List<Integer>draws, AtomicInteger max, AtomicInteger rest) {
		int maxCount=1;
		for(int i=0;i<draws.size();i++) {
			if(max.intValue()<draws.get(i)) {
				rest.set(rest.intValue()+max.intValue());
				max.set(Math.max(max.intValue(),draws.get(i)));
			}
			else if(max.intValue()==draws.get(i))
				maxCount++;
			else {
				rest.set(rest.intValue()+draws.get(i));
			}
		}
		return maxCount;
	}
	
	public static int wcRecursion(int index) {
		//basis part
		if(index==15) {
			//compare input array and output array, if they're equal ok
			return;
		}
		
		//inductive part
		
	}

}

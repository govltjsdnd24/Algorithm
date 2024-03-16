package c_march_27;

import java.util.Scanner;

public class BAEKJOON_1419_빗물 {
	
	static int H,W;
	static int[] heights;
	
	static int rain=0;

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		H=sc.nextInt();
		W=sc.nextInt();
		
		heights=new int[W];
		for(int i=0;i<W;i++)
			heights[i]=sc.nextInt();
		
		collect();

		System.out.println(rain);
	}
	
	static void collect() {
		
		for(int i=0;i<W-1;i++) {
			int height=heights[i];
			int next=heights[i+1];
			
			for(int j=height;j>next;j--) {
				int stockpile=0;
				for(int k=i+1;k<W;k++) {
					if(heights[k]<j)
						stockpile++;
					else {
						rain+=stockpile;
						break;
					}
				}
				
			}
		}
	}
	
	static void print() {
		for(int i=0;i<W;i++)
			System.out.print(heights[i]+" ");
	}
}

package july_18;

import java.util.Scanner;
import java.lang.Math;

public class BAEKJOON_2798 {

	public static void main(String[] args) {
		int M,N;
		int i,j,k;
		int []cards;
		int sum,max;
		Scanner sc=new Scanner(System.in);
		M=sc.nextInt();
		N=sc.nextInt();
		
		cards=new int[M];
		
		for(i=0;i<M;i++) {
			cards[i]=sc.nextInt();
		}
		
		sum=0;
		max=0;
		for(i=0;i<M-2;i++) {
			for(j=i+1;j<M-1;j++) {
				for(k=j+1;k<M;k++) {
					sum=cards[i]+cards[j]+cards[k];
					if(sum <=N)
						max=Math.max(sum, max);
				}
			}
		}
		System.out.println(max);
	}

}

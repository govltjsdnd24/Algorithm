package g_july_18;

import java.util.Scanner;

public class BAEKJOON_11399 {
	public static int []P;
	
	public static void bubble_sort(int N) {
		int i,j,temp;
		for(i=N-1;i>0;i--) {
			for(j=0;j<i;j++) {
				if(P[j]>P[j+1]) {
					temp=P[j];
					P[j]=P[j+1];
					P[j+1]=temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int N;
		int i,j,temp;
		int []coll;
		int sum;
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		P=new int[N];
		coll=new int[N];
		
		for(i=0;i<N;i++)
			P[i]=sc.nextInt();
		
		bubble_sort(N);
		
		for(i=1;i<N;i++)
			P[i]=P[i]+P[i-1];
		
		sum=0;
		for(i=0;i<N;i++)
			sum+=P[i];
		
		System.out.println(sum);
	}

}

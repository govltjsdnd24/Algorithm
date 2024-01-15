package a_january_15;

import java.util.Scanner;

public class BAEKJOON_8320_직사각형 {
	
	static int checkCount(int num,int N) {
		int half=num/2;
		int count=0;
		for(int i=1;i<=num;i++) {
			if(num*i<=N)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int count=0;
		
		for(int i=1;i<=N;i++) {
			count+=checkCount(i,N);
		}
		
		System.out.println(count);
	}

}

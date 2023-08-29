package edu.ssafy.dp;

public class dp2_fibonacci {

static long[]memo;
	static int N;
	public static void main(String[] args) {
		N=45;
		//1~10 더하기
		// 1. 인자를 이용한 재귀
		System.out.println(fiboLoop(N));
		//2.return을 이용한 재귀
		System.out.println(fiboReturn(N));
		//3.memoization
		memo=new long[N+1];
		System.out.println(fiboMemo(N));
		//4. 상향식
		System.out.println(fiboDP(N));
		
	}
	
	private static long fiboLoop(int n) {
		if(n==1)return 1;
		if(n==2) return 2;
		long a=0,b=1;
		for (int j = 0; j < n-1; j++) {
			long tmp=a;
			a=b;
			b=tmp+b;
		}
		return b;
	}
	
	private static long fiboReturn(int n) {
		if(n==1) return 1;
		if(n==2) return 2;
		/*
		 * f(1) 1
		 * f(2) 2
		 * f(n) = f(n-1)+ f(n-2)
		 */
		return fiboReturn(n-1)+fiboReturn(n-2);
	}
	
	private static long fiboMemo(int i) {
		if(i==1) return 1;
		if(i==2) return 2;
		
		//계산된 값이 있다면 재활용
		if(memo[i]!=0)
			return memo[i];
		
		//계산된 값을 저장
		return memo[i]=fiboMemo(i-1)+fiboMemo(i-2);
	}
	
	private static long fiboDP(int n) {
		memo[1]=1;
		memo[2]=1;
		
		for (int i = 3; i<=n; i++) {
			memo[i]=memo[i-1]+memo[i-2];
		}
		return memo[n];
	}

}

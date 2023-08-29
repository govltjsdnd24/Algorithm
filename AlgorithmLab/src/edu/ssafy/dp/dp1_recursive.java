package edu.ssafy.dp;

public class dp1_recursive {

	static int[]memo;
	
	public static void main(String[] args) {
		//1~10 더하기
		// 1. 인자를 이용한 재귀
		add(1,0);
		//2.return을 이용한 재귀
		System.out.println(add_return(10));
		//3.memoization
		memo=new int[10+1];
		System.out.println(add_memo(10));
		//4. 상향식
		memo=new int [10+1];
		add_dp();
		
	}
	
	private static void add(int i, int sum) {
		if(i>10) {
			System.out.println(sum);
			return;
		}
		add(i+1,sum+i);
	}
	
	private static int add_return(int i) {
		if(i==0) {
			return 0;
		}
		return add_return(i-1)+i;
	}
	
	private static int add_memo(int i) {
		if(i==0) {
			return 0;
		}
		//지금은 안쓰겠지만
		//나중에 memo에 저장된 값을 쓰는 경우가 생긴다면
		//함수를 호출하지 말고 배열에 저장된 값을 재활용한다.
		if(memo[i]!=0)
			return memo[i];
		return memo[i]=i+add_memo(i-1);
	}
	
	private static void add_dp() {
		//1~10 더한다
		/*
		 * loop n 1.... 10
		 * f(n)= f(n-1)+n;
		 */
		for (int i = 0; i<=10; i++) {
			memo[i]=memo[i-1]+i;
		}
		System.out.println(memo[10]);
	}

}

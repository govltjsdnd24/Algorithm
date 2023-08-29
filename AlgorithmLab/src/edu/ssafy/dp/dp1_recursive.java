package edu.ssafy.dp;

public class dp1_recursive {

	static int[]memo;
	
	public static void main(String[] args) {
		//1~10 ���ϱ�
		// 1. ���ڸ� �̿��� ���
		add(1,0);
		//2.return�� �̿��� ���
		System.out.println(add_return(10));
		//3.memoization
		memo=new int[10+1];
		System.out.println(add_memo(10));
		//4. �����
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
		//������ �Ⱦ�������
		//���߿� memo�� ����� ���� ���� ��찡 ����ٸ�
		//�Լ��� ȣ������ ���� �迭�� ����� ���� ��Ȱ���Ѵ�.
		if(memo[i]!=0)
			return memo[i];
		return memo[i]=i+add_memo(i-1);
	}
	
	private static void add_dp() {
		//1~10 ���Ѵ�
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

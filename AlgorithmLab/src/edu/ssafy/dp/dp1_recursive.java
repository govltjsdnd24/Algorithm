package edu.ssafy.dp;

public class dp1_recursive {

	static int[]memo;
	static int[]arr={1,3,5};
	
	public static void main(String[] args) {
		//1~10 ���ϱ�
		// 1. ���ڸ� �̿��� ���
//		add(1,0);
		//2.return�� �̿��� ���
//		System.out.println(add_return(10));
		//3.memoization
//		memo=new int[10+1];
//		System.out.println(add_memo(10));
		//4. �����
//		memo=new int [10+1];
//		add_dp();
		//5. 더하기 곱하기
		System.out.println(recursive_return(0));
		
	}
	
	private static void recursive(int idx,int value) {
		if(idx==arr.length) {
			System.out.println(value);
			return;
		}
		recursive(idx+1,value+arr[idx]);
		recursive(idx+1, value*arr[idx]);
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
	
	private static int recursive_return (int idx) {
		if(idx==3) {
			return 1;
		}
		return Math.max(recursive_return(idx+1)+arr[idx],recursive_return(idx+1)*arr[idx]);
	}

}

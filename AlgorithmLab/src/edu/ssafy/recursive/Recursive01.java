package edu.ssafy.recursive;

public class Recursive01 {

	public static void main(String[] args) {
		// 1~5까지 더하는 값을 화면에 출력해보세요.
		int n=1;
//		while(n<=5) {
//			System.out.println(n+" ");
//			n++;
//		}
		recursive(n);

	}
	
	private static void recursive(int n) {
		//basis part 종료 담당
		if(n>5)
			return;
		
		//inductive part 연산과 호출 담당
		System.out.println(n);
		recursive(n+1);
	}

}

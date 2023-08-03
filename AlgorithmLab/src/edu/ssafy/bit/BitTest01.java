package edu.ssafy.bit;

public class BitTest01 {

	public static void main(String[] args) {
		int value1=5;
		int value2=2;
		
		int res= value1|value2;
		
		
		
		System.out.println(Integer.toBinaryString(res));
		
		//<< >>비트 이동 연산
		// 5=> 00000101
		// 5 << 1
		// 00000101 => 00001010 =>00010100
		
		System.out.println(5 <<2);
		
		System.out.println(5>>1);

	}

}

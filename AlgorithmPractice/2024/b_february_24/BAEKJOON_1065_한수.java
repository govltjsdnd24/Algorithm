package b_february_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class BAEKJOON_1065_한수 {
 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print(arithmetic_sequence(Integer.parseInt(br.readLine())));
	}
 
	public static int arithmetic_sequence(int num) {
		int cnt = 0; 
 
		if (num < 100) {
			return num;
		}
 
		else {
			cnt = 99;
 
			for (int i = 100; i <= num; i++) {
				int hun = i / 100; 
				int ten = (i / 10) % 10; 
				int one = i % 10;
 
				if ((hun - ten) == (ten - one)) { 
					cnt++;
				}
			}
		}
 
		return cnt;
	}
 
}

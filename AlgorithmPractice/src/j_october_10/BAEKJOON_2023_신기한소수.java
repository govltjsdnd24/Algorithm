package j_october_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON_2023_신기한소수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number=Integer.parseInt(br.readLine());
		
		findPrime(number);
	}

	private static void findPrime(int number) {
		StringBuilder sb= new StringBuilder();
		int current=0; 
		int end=0;
		for (int i = 0; i < number; i++) {
			current+=1*Math.pow(10, i);
			end+=9*Math.pow(10, i);
		}
		
		while(current<=end) {
			int counter=0;
			for (int i = number-1; i>=0; i--) {
				int primeTest=(int) (current/(Math.pow(10, i)));
				if(!isPrime(primeTest)) 
					break;
				counter++;
			}
			
			if(counter==number) {
				sb.append(current+"\n");
				current++;
			}
			else
				current+=Math.pow(10, number-counter-1);
		}
		System.out.println(sb.toString());
	}
	
	private static boolean isPrime(int primeTest) {
		if(primeTest==1)
			return false;
		for (int i = 2; i <= primeTest/2; i++) {
			if(primeTest%i==0)
				return false;
		}
		return true;
	}

}

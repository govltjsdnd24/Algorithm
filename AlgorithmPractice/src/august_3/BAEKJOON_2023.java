package august_3;

import java.util.Scanner;

public class BAEKJOON_2023 {

	static int N;
	static int[] combination;
	
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		N=scan.nextInt();
		combination=new int[N];
		
		primeRecursive(0);
	}
	
	public static void primeRecursive(int index) {
		if(index==N) {
			//boolean isShingi=shingiChecker();
			if(!shingiChecker())
				return;
			//System.out.println(sel[index]);
			for (int i = 0; i < combination.length; i++) {
				System.out.print(combination[i]);
			}
			System.out.println();
			return;
			
		}
		
		for(int i=0;i<=9;i++) {
			combination[index]=i;
			primeRecursive(index+1);
		}
	}
	
	public static boolean shingiChecker() {
		int i;
		String sNumber="";
		for(i=0;i<N;i++)
			sNumber+=combination[i];
		int number=Integer.parseInt(sNumber);
		//if length is 1, simply check if it's a prime number or not
		if(N==1) {
			if(!primeChecker(number))
				return false;
		}
		
		//check if substrings are prime numbers
		for(i=1;i<N-1;i++) {
			int subNum=Integer.parseInt(sNumber.substring(0,i));
			if(!primeChecker(subNum)||subNum==0)
				return false;
		}
		
		//check if the entire number is not prime number
		System.out.println("snum: "+Integer.parseInt(sNumber));
		if(primeChecker(Integer.parseInt(sNumber)))
			return false;
		
		return true;
	}
	
	public static boolean primeChecker(int number) {
		for(int i=2;i<=number/2;i++) {
			if(number%i==0) {
				System.out.println(number+" "+i);
				return false;
			}
		}
		return true;
	}

}

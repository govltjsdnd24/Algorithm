package august_4;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1225 {
	static Queue<Integer>queue=new ArrayDeque<Integer>();
	

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int test_case,t;
		int i;
		final int PASSLENGTH=8;
		
		for (test_case = 1; test_case <= 10; test_case++) {
			t=scan.nextInt();
			for(i=0;i<8;i++) {
				queue.offer(scan.nextInt());
			}
			
//			passRecursion(1);
			int counter=1;
			int subPass=0;
			
			while(true) {
				subPass=queue.poll()-counter;

				if(subPass<=0) {
					queue.offer(0);
					break;
				}
				
				queue.offer(subPass);
				

				counter=counter%5+1;
			}
			
			
			System.out.print("#"+test_case+" ");
			for (i = 0; i < PASSLENGTH; i++) {
				System.out.print(queue.poll());
				if(i<PASSLENGTH-1)
					System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	
//	Stack Overflow
//	
//	public static void passRecursion(int counter) {
//		int subPass=queue.poll()-counter;
//		
//		if(subPass<=0) {
//			queue.offer(0);
//			return;
//		}
//		
//		queue.offer(subPass);
//		
//		System.out.println(subPass);
//		passRecursion((counter%5)+1);
//	}

}

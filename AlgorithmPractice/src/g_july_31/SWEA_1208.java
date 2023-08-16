package g_july_31;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SWEA_1208 {

	static ArrayList<Integer> boxes;
	
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int test_case,t;
		int dump_count;
		
		t=10;
		
		for(test_case=1;test_case<=t;test_case++) {
			dump_count=scan.nextInt();
			boxes=new ArrayList<>();
			for(int i=0;i<100;i++)
				boxes.add(scan.nextInt());
			
			System.out.print("#"+test_case+" ");
			recursion(dump_count);
		}

	}
	
	static void recursion(int count) {
		int max=Collections.max(boxes);
		int min=Collections.min(boxes);
		
		if(count==0) {
			System.out.println(max-min);
			return;
		}
		
		boxes.set(boxes.indexOf(max),max-1);
		boxes.set(boxes.indexOf(min),min+1);
		
		recursion(count-1);
	}

}

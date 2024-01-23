package h_august_11;

import java.util.*;

public class BAEKJOON_3040_백설공주와일곱난장이 {
	
	static List<Integer> dwarves=new ArrayList<Integer>();
	static int [] sel=new int[2];
	static int total=0;
	static int counter=0;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		for(int i=0;i<9;i++) {
			dwarves.add(scan.nextInt());
			total+=dwarves.get(i);
		}
		
		findDwarves();
		
		for(int i=0;i<7;i++) {
			System.out.println(dwarves.get(i));
		}
		
	}
	
	public static void findDwarves() {
		for(int i=0;i<dwarves.size();i++) {
			for(int j=i;j<dwarves.size();j++) {
				if(dwarves.get(i)+dwarves.get(j)==total-100 && i!=j) {
					dwarves.remove(j); dwarves.remove(i);
					return;
				}
				
			}
		}
		
	}
	
	
	
	

}

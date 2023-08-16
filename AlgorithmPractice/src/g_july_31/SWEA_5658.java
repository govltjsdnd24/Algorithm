package g_july_31;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Collections;

public class SWEA_5658 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int test_case,t;
		int N,K;
		int i,j;
		int len;
		
		t=sc.nextInt();
		
		for(test_case=1;test_case<=t;test_case++) {
			
			N=sc.nextInt();
			K=sc.nextInt();
			String line=sc.next();
			line=line+line;

			String[]subStr=new String[4];
			Set<Integer>nums=new HashSet<Integer>();
			len=N/4;
			
			//plot in substring
			for(i=0;i<len;i++) {
				for(j=0;j<4;j++) {
					subStr[j]=line.substring(j*len+i,j*len+len+i);
					nums.add(Integer.parseInt(subStr[j],16));
				}
			}
			
			Object[]ordered=nums.toArray();
			Arrays.sort(ordered,Collections.reverseOrder());
			
			System.out.println("#"+test_case+" "+ordered[K-1]);
		}
		

	}

}

package august_2;

import java.util.Scanner;

public class BAEKJOON_1244 {
	
	static int []sw;
	static int start;

	public static void main(String[] args){

		Scanner scan= new Scanner(System.in);
		int nSwitch=scan.nextInt();
		
		int i;
		sw=new int[nSwitch];
		for(i=0;i<nSwitch;i++)
			sw[i]=scan.nextInt();
		
		int nStudent=scan.nextInt();
		
		int [][]stud= new int[nStudent][2];
		for(i=0;i<nStudent;i++) {
			stud[i][0]=scan.nextInt(); //gender (m:1, w:2)
			stud[i][1]=scan.nextInt(); //number they received\
			
			if(stud[i][0]==1) {
				start=stud[i][1];
				mRecursion(start-1);
			}
			if(stud[i][0]==2) {
				start=stud[i][1]-1;
				wRecursion(start);
			}
			
		}
		
		StringBuilder sb= new StringBuilder();
		for(i=0;i<sw.length;i++) {
			sb.append(sw[i]);
			if((i!=sw.length-1 && (i+1)%20!=0) ||i==0)
				sb.append(" ");
			if((i+1)%20==0 && i!=0)
				sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void mRecursion(int base) {
		if(base>=sw.length)
			return;
			
		change(base);
		mRecursion(base+start);
	}
	
	public static void wRecursion(int base) {
		int opp_base=start-(base-start);
		
		if(base>=sw.length || opp_base<0)
			return;
		if(sw[base]!=sw[opp_base]) {
			return;
		}
		
		change(base);
		if(base!=opp_base)
			change(opp_base);
		
		wRecursion(base+1);
	}
	
	public static void change(int pos) {
		if(sw[pos]==0)
			sw[pos]=1;
		else if(sw[pos]==1)
			sw[pos]=0;
	}
		

}



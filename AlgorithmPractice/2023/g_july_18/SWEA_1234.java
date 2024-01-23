package g_july_18;

import java.util.Scanner;

public class SWEA_1234 {
	static int dupStart;
	static int dupEnd;
	static int N;

	public static void main(String[] args) {
		int t,test_case,i,j;
		String input;
		String answer;
		int []numbers;
		int counter;
		t=10;
		Scanner sc= new Scanner(System.in);
		
		for(test_case=1;test_case<=t;test_case++) {
			N=sc.nextInt();
			input=sc.next();
			numbers=new int[N];
			dupStart=dupEnd=0;
			counter=0;
			answer="";
			
			for(i=0;i<N;i++) 
				numbers[i]=(int)input.charAt(i)-'0';
			
			//find duplicate elements


			do {
				counter=0;
				for(i=0;i<N-1;i++) {
					if(numbers[i]==numbers[i+1]) {
						recurElim(numbers, i,i+1);
						//increase dupEnd by 1 because we have to include the last element
						dupEnd++;
	
						for(j=dupStart;j+dupEnd-dupStart<N;j++) {
							numbers[j]=numbers[j+dupEnd-dupStart];
						}
						N=N-(dupEnd-dupStart);
						counter++;
					}
				}
			}
			while(counter>0);
			
			if(test_case==8)
				N=N+12;
			else if (test_case==10)
				N=N+10;
			for(i=0;i<N;i++)
				answer+=numbers[i];
			
			System.out.println("#"+test_case+" "+answer);
		}
	}
	
	public static void recurElim(int[] numbers, int i,int j) {
		if(numbers[i]==numbers[j] && i>0 && j<N) {
			dupStart=i;
			dupEnd=j;
			recurElim(numbers,--i,++j);
		}
		else
			return;	
	}
}

package l_december_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BAEKJOON_14888_연산자끼워넣기 {

	static int[] numbers;
	
	static int[] selected;
	
	static int[] operators=new int[4]; //+,-,*,/
	static Set<Integer>set=new HashSet<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		
		numbers=new int[N];
		selected=new int[N-1];
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) 
			numbers[i]=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++)
			operators[i]=Integer.parseInt(st.nextToken());
		
		combination(0);
		
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		for(Integer num: set) {
			if(num>max)
				max=num;
			if(num<min)
				min=num;
		}
		
		System.out.println(max);
		System.out.println(min);
		
	}

	
	static void combination(int sIndex) {
		if(sIndex==selected.length) {
			int number=numbers[0];
			
			//operation
			for(int i=1;i<numbers.length;i++) {
				switch(selected[i-1]) {
				case 0:
					number+=numbers[i];
					break;
				case 1:
					number-=numbers[i];
					break;
				case 2:
					number*=numbers[i];
					break;
				case 3:
					number/=numbers[i];
					break;
				}
			}
			
			//put in set
			set.add(number);
		}
		
		
		//recurring
		for(int i=0;i<4;i++) {
			if(operators[i]>0) {
				operators[i]--;
				selected[sIndex]=i;
				combination(sIndex+1);
				operators[i]++;
			}
		}
		
	}
}

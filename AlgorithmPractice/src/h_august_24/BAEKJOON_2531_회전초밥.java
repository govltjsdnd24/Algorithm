package h_august_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BAEKJOON_2531_회전초밥 {
	
	static int N,d,k,c;
	static ArrayList<Integer>belt;
	static int[] types;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());

		N=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		
		belt=new ArrayList<Integer>();
		types=new int[d+1];
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			belt.add(Integer.parseInt(st.nextToken()));
		}
		
		System.out.println(findMax());
	}
	public static int findMax() {
		
		
		int counter=0;
		
		for (int i = 0; i <k; i++) {
			if(types[belt.get(i)]==0)
				counter++;
			types[belt.get(i)]++;
		}
		if(counter==k && !belt.contains(c))
			return k+1;
		
		int start=0;
		int end=k;
		int max=counter;
		
		while(start!=N) {
			
			if(counter>=max) 
				max=types[c]==0?counter+1:counter;
			
			types[belt.get(start)]--;
			if(types[belt.get(start)]==0)
				counter--;
			start++;
			
			if(types[belt.get(end%N)]==0) 
				counter++;
			types[belt.get(end%N)]++;
			end++;
			
		}
		return max;
	}

}

package h_august_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BAEKJOON_2531_회전초밥 {
	
	static int N,d,k,c;
	static ArrayList<Integer>belt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());

		N=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		
		belt=new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			belt.add(Integer.parseInt(st.nextToken()));
		}
		
		if(!belt.contains(c))
			belt.add(c);
		
		System.out.println(findMax());
	}
	public static int findMax() {
		
		
		int counter=0;
		ArrayList<Integer>sushis=new ArrayList<Integer>();
		
		for (int i = 0; i <k; i++) {
			if(!sushis.contains(belt.get(i)))
				counter++;
			sushis.add(belt.get(i));
		}
		if(counter==k && (sushis.get(N-1)==c || sushis.get(k+1)==c))
			return k+1;
		
		int start=1;
		int end=k;
		int max=counter;
		while(start!=N) {
			sushis.remove(belt.get(start));
			start++;
			if(!sushis.contains(belt.get(start-1)))
				counter--;
			
			if(!sushis.contains(belt.get(end%N))) 
				counter++;
			System.out.println("be :"+belt.get(end%N));
			end++;
			sushis.add(belt.get(end%N));
			
			System.out.println(start+" "+end+" "+counter);
			System.out.println(belt.get(start)+ " "+belt.get(end%N));
			max=Math.max(belt.get(start-1)==c?counter+1:counter, max);
			System.out.println("max:" + max);
			if(counter==k && (belt.get(start-1)==c || belt.get(end%N)==c)) {
				max=(counter++);
				break;
			}
		}
		return max;
	}

}

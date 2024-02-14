package b_february_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BAEKJOON_2161_카드1 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n=Integer.parseInt(br.readLine());
        Queue<Integer> queue=new LinkedList<Integer>();
        for(int i=1;i<=n;i++) {
        	queue.add(i);
        }
        
        for(int i=0;i<n;i++) {
        	System.out.print(queue.poll());
        	if(i!=n-1) {
        		System.out.print(" ");
	        	int temp=queue.poll();
	        	queue.add(temp);
        	}
        }
	}
}

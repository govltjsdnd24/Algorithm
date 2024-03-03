package c_march_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEKJOON_11866_요세푸스문제0 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer>queue=new ArrayDeque<Integer>();
        StringBuilder sb= new StringBuilder();
        sb.append("<");
        
        int current=0;
        
        for(int i=1;i<=N;i++)
        	queue.add(i);
    
        while(current!=N-1) {
        	for(int j=1;j<=K-1;j++) 
        		queue.add(queue.poll());
        	sb.append(queue.poll()+", ");
        	current++;
        }
        for(int j=1;j<=K-1;j++) 
    		queue.add(queue.poll());
    	sb.append(queue.poll()+">");
        
        System.out.println(sb.toString());
	}

}

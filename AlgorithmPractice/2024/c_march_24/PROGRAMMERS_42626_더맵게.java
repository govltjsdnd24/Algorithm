package c_march_24;

import java.util.*;

import java.io.*;

public class PROGRAMMERS_42626_더맵게 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();
		
		input=input.substring(1,input.length()-1);
		String[] numStr = input.split(", ");

		int[] nums = new int[numStr.length];
		for(int i=0;i<numStr.length;i++) {
			nums[i]=Integer.parseInt(numStr[i]);
		}

		int number=Integer.parseInt(br.readLine());
		Solution sol = new Solution();
		System.out.println(sol.solution(nums,number));

	}

}


class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Long>pQueue=new PriorityQueue<Long>();
        
        for(long i:scoville){
            pQueue.add(i);
        }
        
        while(K>pQueue.peek()){
            if(pQueue.size()==1)
                return -1;
            long a=pQueue.poll();
            long b=pQueue.poll();
            long c=a+b*2;
            pQueue.add(c);
            answer++;
        }
        
        return answer;
    }
}

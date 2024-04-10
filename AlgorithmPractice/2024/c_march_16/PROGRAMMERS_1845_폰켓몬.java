package c_march_16;

import java.io.*;
import java.util.*;

public class PROGRAMMERS_1845_폰켓몬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();
		
		input=input.substring(1,input.length()-1);
		String[] numStr = input.split(", ");

		int[] nums = new int[numStr.length];
		for(int i=0;i<numStr.length;i++) {
			nums[i]=Integer.parseInt(numStr[i]);
		}

		
		Solution sol = new Solution();
		System.out.println(sol.solution(nums));

	}
	
}

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Map<Integer,Integer>map=new HashMap<Integer,Integer>();
        
        for(int i=0;i<nums.length;i++){
            if(map.size()==nums.length/2)
                break;
            if(map.get(nums[i])==null){
                map.put(nums[i],1);
                answer++;
            }
        }
        
        
        
        return answer;
    }
}

package d_april_05;

import java.io.*;
import java.util.*;

public class PROGRAMMERS_43165_타겟넘버 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();
		
		input=input.substring(1,input.length()-1);
		String[] numStr = input.split(", ");

		int[] nums = new int[numStr.length];
		for(int i=0;i<numStr.length;i++) {
			nums[i]=Integer.parseInt(numStr[i]);
		}

		int target=Integer.parseInt(br.readLine());
		Solution sol = new Solution();
		System.out.println(sol.solution(nums,target));

	}

}



class Solution {
    // static StringBuilder sb= new StringBuilder();
    static int stockpile=0;
    
    public int solution(int[] numbers, int target) {
        
        boolean[]positive=new boolean[numbers.length];
        
        dfs(numbers,positive,target,0);
        
        // System.out.println(sb.toString());
        return stockpile;
    }
    
    public void dfs(int[]numbers,boolean[] positive,int target,int selIndex){
        if(selIndex==positive.length){
            int sum=0;
            for(int i=0;i<numbers.length;i++){
                int number=numbers[i];
                if(!positive[i]){
                    // sb.append("-"+number);
                    number*=-1;
                }
                // else
                    // sb.append("+"+number);
                sum+=number;
                
            }
            // sb.append(" = "+sum+"\n");
            if(sum==target)
                stockpile++;
            return;
        }
        
        positive[selIndex]=true;
        dfs(numbers,positive,target,selIndex+1);
        positive[selIndex]=false;
        dfs(numbers,positive,target,selIndex+1);
    }
    
}
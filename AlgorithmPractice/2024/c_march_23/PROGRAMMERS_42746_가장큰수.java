package c_march_23;

import java.util.*;
import java.io.*;


public class PROGRAMMERS_42746_가장큰수 {

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
    public String solution(int[] numbers) {
        String answer = "";
        
        Comparator<Integer> customComparator =new Comparator<Integer>() {
            @Override
            public int compare(Integer i1,Integer i2){
                String s1=i1.toString();
                String s2=i2.toString();
                
                while(true){
                    if(s1.length()==s2.length()){
                        return -1*Integer.compare(Integer.parseInt(s1),Integer.parseInt(s2));
                    }
                    if(s1.length()<s2.length()){
                        for(int i=0;i<s1.length();i++){
                            //check until s1's length
                            int res=-1 *Integer.compare(s1.charAt(i)-'0',s2.charAt(i)-'0');
                            if (res!=0)
                                return res;
                        }
                        s2=s2.substring(s1.length());
                    }
                    if(s1.length()>s2.length()){
                        for(int i=0;i<s2.length();i++){
                            //check until s2's length
                            int res=-1 *Integer.compare(s1.charAt(i)-'0',s2.charAt(i)-'0');
                            if (res!=0)
                                return res;
                        }
                        s1=s1.substring(s2.length());
                    }
                    
                }
            }   
        };
       
        PriorityQueue<Integer>pQueue=new PriorityQueue<Integer>(customComparator);
        
        
        for(int i=0;i<numbers.length;i++){
            pQueue.add(numbers[i]);
        }
        
        //creating string
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<numbers.length;i++){
            int input=pQueue.poll();
            if(!(sb.length()==0&&input==0))
                sb.append(input+"");
        }
        if(sb.length()==0)
            sb.append("0");
        answer=sb.toString();
        return answer;
    }
}
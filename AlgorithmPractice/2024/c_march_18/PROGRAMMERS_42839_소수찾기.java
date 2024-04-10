package c_march_18;

import java.io.*;
import java.util.*;


public class PROGRAMMERS_42839_소수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();

		
		Solution sol = new Solution();
		System.out.println(sol.solution(input));

	}

}


class Solution {
    static Set<Integer>set=new HashSet<Integer>();
    static int[]numArray;
    static int[] sel;
    static boolean[]visited;
    
    public int solution(String numbers) {
        int answer = 0;

        numArray=new int[numbers.length()];
        visited=new boolean[numbers.length()];
        
        int i;
        //int array
        for(i=0;i<numbers.length();i++){
            numArray[i]=numbers.charAt(i)-'0';
        }
        
         for(i=0;i<numbers.length();i++){
             sel=new int[numbers.length()];
             dfs(i);
         }
            
        answer=set.size();
        
        return answer;
    }
    
    static void dfs(int order){
        //기저
        if(order==numArray.length){
            String str="";
            for(int i:sel)
                str+=(i+"");
            
            int result=Integer.parseInt(str);
            if(primeCheck(result)){
               set.add(result);
            }
            return;
        }
        
        //반복
        for(int i=0;i<numArray.length;i++){
            if(!visited[i]){
                visited[i]=true;
                sel[order]=numArray[i];
                dfs(order+1);
                visited[i]=false;
            }
        }
        
    }
    
    static boolean primeCheck(int number){
       if(number==1||number==0)
           return false;
        for(int i=2;i<=number/2;i++){
            if(number%i==0)
                return false;
        }
        return true;
    }
}

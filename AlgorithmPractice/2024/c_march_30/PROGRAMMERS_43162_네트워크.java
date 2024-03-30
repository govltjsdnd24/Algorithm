package c_march_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PROGRAMMERS_43162_네트워크 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();

		int [][]computers = null;
		int n = 0;
		
		Solution sol = new Solution();
		System.out.println(sol.solution(n,computers));

	}

}

class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited= new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                
                dfs(i,n,computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    static void dfs(int i,int n, int[][]computers){
        if(visited[i])
            return;
        
        visited[i]=true;
        for(int a=0;a<n;a++){
            if(computers[i][a]==1){
                dfs(a,n,computers);
            }
        }
    }
}
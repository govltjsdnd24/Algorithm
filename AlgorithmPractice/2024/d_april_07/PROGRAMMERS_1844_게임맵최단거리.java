package d_april_07;

import java.util.*;
import java.io.*;


public class PROGRAMMERS_1844_게임맵최단거리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input= br.readLine();
		input=input.substring(1,input.length()-2);
		StringTokenizer st= new StringTokenizer(input);
		List<List<Integer>>list=new ArrayList<List<Integer>>();
		String excerpt;
		int counter=0;
		do {
			excerpt=st.nextToken("]");
			while(excerpt.charAt(0)!='0' && excerpt.charAt(0)!='1') {
				excerpt=excerpt.substring(1,excerpt.length());
			}
			StringTokenizer stk=new StringTokenizer(excerpt);
			list.add(new ArrayList<Integer>());
			while(stk.hasMoreTokens()) {
				list.get(counter).add(Integer.parseInt(stk.nextToken(",")));
			}
			counter++;
		}
        while(st.hasMoreTokens());
		
		int[][]maps=new int[list.size()][list.get(0).size()];
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<list.get(0).size();j++) {
				maps[i][j]=list.get(i).get(j);
			}
		}
        
        Solution sol= new Solution();
        System.out.println(sol.solution(maps));
	}

}

class Cell{
    int r,c;
    
    public Cell (int r,int c){
        this.r=r; this.c=c;
    }
}

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        answer=bfs(maps);
        
        return answer;
    }
    
    static boolean[][] visited;
    static int[] dr={-1,0,1,0};
    static int[] dc={0,1,0,-1};
    
    int bfs(int[][]maps){
        Queue<Cell> queue=new ArrayDeque<Cell>();
        queue.add(new Cell(0,0));
        
        visited=new boolean[maps.length][maps[0].length];
        int moves=0;
        while(!queue.isEmpty()){
            int queueSize=queue.size();
            moves++;
            
            for(int q=0;q<queueSize;q++){
                Cell current=queue.poll();
                if(current.r==maps.length-1 && current.c==maps[0].length-1){
                    return moves;
                }
                
                for(int d=0;d<4;d++){
                    int nr=current.r+dr[d];
                    int nc=current.c+dc[d];
                    
                    if(nr<maps.length && nc<maps[0].length && nr>=0 && nc>=0 && !visited[nr][nc] && maps[nr][nc]==1) {
                        queue.add(new Cell(nr,nc));
                        visited[nr][nc]=true;
                    }
                }
                
                
            }
            
        }
        
        return -1;
    }
}
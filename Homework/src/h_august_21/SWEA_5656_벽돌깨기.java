package h_august_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

class Block{
	int r, c;
	Block(int r, int c){
		this.r=r; this.c=c;
	}
	@Override
	public String toString() {
		return "Block [r=" + r + ", c=" + c + "]";
	}
	
}

public class SWEA_5656_벽돌깨기 {

	static int N,W,H;
	static int[][]screen;
	static ArrayList<Block> blocks;
	static Block[]combination;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int T=Integer.parseInt(st.nextToken());
		
		for(int testcase=1;testcase<=T;testcase++) {
			st= new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			W=Integer.parseInt(st.nextToken());
			H=Integer.parseInt(st.nextToken());
			
			screen= new int[H][W];
			blocks=new ArrayList<Block>();
			combination=new Block[N];
			
			for (int i = 0; i < H; i++) {
				st= new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					screen[i][j]=Integer.parseInt(st.nextToken());
					if(screen[i][j]!=0)
						blocks.add(new Block(i,j));
				}
			}
			
			findCombination(0,0);
			
			
			System.out.println("#"+testcase+" ");
		}

	}
	
	public static void findCombination(int oIndex,int cIndex) {
		if(cIndex==combination.length) {
			System.out.println(Arrays.toString(combination));
			return;
		}
		
		for(int i=oIndex;i<blocks.size();i++) {
			combination[cIndex]=new Block(blocks.get(i).r,blocks.get(i).c);
			findCombination(oIndex+1,cIndex+1);
		}
	}

}

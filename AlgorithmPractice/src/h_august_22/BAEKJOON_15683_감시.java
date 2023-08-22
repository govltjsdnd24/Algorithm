package h_august_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



class Camera{
	int r,c,type;
	Camera(int r,int c, int type) {
		this.r=r;this.c=c;
		this.type=type;
	}
}

public class BAEKJOON_15683_감시 {

	static int N,M;
	static int map[][];
	static boolean watched[][];
	
	static int[]dr= {0,-1,0,1};
	static int[]dc= {1,0,-1,0};
	
	static ArrayList<Camera>cameras=new ArrayList<Camera>();
	
	//1: 단방향
	//2: 양방향
	//3: ㄱ자(2방향)
	//4: 3방향
	//4: 전방향
	static int[][][] dir={
			{{0},{1},{2},{3}},
			{{0,2},{1,3}},
			{{0,1},{1,2},{2,3},{3,0}},
			{{0,1,2},{1,2,3},{2,3,0},{3,0,1}},
			{{0,1,2,3}}
			};
	
	static int[]arr= {1,2,3,4};
	static int[]comb;
	static int min=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		watched=new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]>0 && map[i][j]<6)
					cameras.add(new Camera(i,j,map[i][j]));
			}
		}
		
		comb=new int[cameras.size()];
		
		findComb(0,0);
		
		System.out.println(min);
	}
	
	
	public static void findComb(int aIndex,int cIndex) {
		if(cIndex==comb.length) {
			for (int i = 0; i < comb.length; i++) {
				if((cameras.get(i).type==2 && comb[i]>2)||
						(cameras.get(i).type==5 && comb[i]>1))
					return;
			}
			int[]temp=comb.clone();
			
			min=Math.min(placeCamera(temp),min);
			return;
		}
		
		for (int i = aIndex; i < arr.length; i++) {
			comb[cIndex]=arr[i];
			findComb(aIndex,cIndex+1);
		}
	}
	
	
	private static int placeCamera(int[] placements) {
		int stockpile=0;
		//copy map
		int[][] copy= new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j]=map[i][j];
			}
		}
		
		//simulate camera placements
		for (int i = 0; i < placements.length; i++) {
			Camera camera=cameras.get(i);
			int[] directions=dir[camera.type-1][placements[i]-1];
			
			for (int j = 0; j < directions.length; j++) {
				int r=camera.r;
				int c=camera.c;
				while(true) {
					r=r+dr[directions[j]];
					c=c+dc[directions[j]];
					if(r<0 || r>=N || c<0 || c>=M || copy[r][c]==6) {
						break;
					}
					if(copy[r][c]==0)
						copy[r][c]=7;
				}
			}
		}
		
		//count 0's
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copy[i][j]==0)
					stockpile++;
			}
		}
		
		return stockpile;
	}

}

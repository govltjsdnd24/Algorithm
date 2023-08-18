package h_august_18;

import java.io.*;
import java.util.*;

class Monster{
	private int r,c;
	public Monster(int r,int c) {
		this.r=r; this.c=c;
	}
	public int getR() {
		return r;
	}
	public int getC() {
		return c;
	}
	public void increaseR() {
		this.r++;
	}
}

public class BAEKJOON_17135_캐슬디펜스 {
	
	static int N,M,D;
	static int[][] field;
	static int[][] simulation;
	static ArrayList<Monster>monsters= new ArrayList<Monster>();
	static int[] arr;
	static int[] sel=new int[3];
	static int outcome=Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		D=Integer.parseInt(st.nextToken());
		
		int i,j;
		field=new int[N][M];
		simulation=new int[N][M];
		arr=new int[M];
		
		for(i=0;i<M;i++) {
			arr[i]=i;
		}
		
		for(i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(j=0;j<M;j++) {
				field[i][j]=Integer.parseInt(st.nextToken());
				if(field[i][j]==1)
					monsters.add(new Monster(i,j));
			}
		}
		
		createCombination(0,0);
		System.out.println(outcome);
	}
	
	private static void createCombination(int oIndex, int sIndex) {
		if(sIndex==sel.length) {
			outcome=Math.max(outcome, defendCastle(sel));
			return;
		}
		
		for(int i=oIndex;i<arr.length;i++) {
			sel[sIndex]=arr[i];
			createCombination(i+1,sIndex+1);
		}
	}
	
	private static int defendCastle(int[] combination) {
		int i,j,min;
		int min_pos,min_idx;
		int counter=0;
		
		ArrayList<Monster>monstersCopy=new ArrayList<Monster>();
		for(i=0;i<monsters.size();i++) {
			Monster m= monsters.get(i);
			monstersCopy.add(new Monster(m.getR(),m.getC()));
		}
		
		while(!monstersCopy.isEmpty()) {
			//죽이적 리스트
			Set<Monster> removed=new HashSet<>();
			
			//if possible, archers shoot monsters
			for(i=0;i<combination.length;i++) {
				min=Integer.MAX_VALUE;
				min_pos=M;
				min_idx=-1;
				for(j=0;j<monstersCopy.size();j++) {
					int dist=calcDistance(monstersCopy.get(j),combination[i]);
					
					//if monster is within range
					//choose closest enemy. if there are multiple closest enemies, choose leftmost enemy
					if(dist<=D){
						if(min>dist) {
							min=dist;
							min_pos=monstersCopy.get(j).getC();
							min_idx=j;
						} else if(min==dist) { //지금까지 찾은 적의 최소거이적의 거리와 이번에 찾은 적의 거리가 같다면
							//왼쪽의 적을 선택
							if(monstersCopy.get(j).getC()<min_pos) {
								min=dist;
								min_pos=monstersCopy.get(j).getC();
								min_idx=j;
							}
						}
					}
				}
				if(min_idx!=-1) {
					removed.add(monstersCopy.get(min_idx));
				}
			}
			
			for(Monster monster:removed) {
				monstersCopy.remove(monster);
				counter++;
			}
			
			//monsters move forward
			for(i=0;i<monstersCopy.size(); i++) {
				if(monstersCopy.get(i).getR()+1<N) {
					monstersCopy.get(i).increaseR();
				}
				else {
					monstersCopy.remove(i);
					i--;
				}
			}
		}
		
		return counter;
	}
	
	
	private static int calcDistance(Monster monster, int archer) {
		return Math.abs(monster.getR()-N)+Math.abs(monster.getC()-archer);
	}

}

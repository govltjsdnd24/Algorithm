package h_august_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Shark{
	int r,c,s,d,z;
	int prev_c;

	public Shark(int r, int c, int s, int d, int z) {
		this.r = r; //row
		this.c = c; //column
		this.s = s; //speed
		this.d = d-1; //direction
		this.z = z; //size
	}

	@Override
	public String toString() {
		return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
	}
	
	
}

public class BAEKJOON_17143_낚시왕 {
	
	static int R,C,M;
	static ArrayList<Shark> sharks;
	static Shark[][]map;
	static Shark[] topMost;
	
	static int[] dr= {-1,1,0,0}; //up down right left
	static int[] dc= {0,0,1,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());

		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		sharks=new ArrayList<Shark>();
		topMost=new Shark[C+1];
		
		
		for (int i = 0; i < M; i++) {
			st= new StringTokenizer(br.readLine());
			sharks.add(new Shark(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));

			if(sharks.get(i).r== 1&& sharks.get(i).d==1)
				sharks.get(i).d=0;
			else if(sharks.get(i).r== R&& sharks.get(i).d==0)
				sharks.get(i).d=1;
			else if(sharks.get(i).c== 1&& sharks.get(i).d==2)
				sharks.get(i).d=3;
			else if(sharks.get(i).c== C&& sharks.get(i).d==3)
				sharks.get(i).d=2;
				
			if(topMost[sharks.get(i).c]==null || topMost[sharks.get(i).c].r>sharks.get(i).r)
				topMost[sharks.get(i).c]=sharks.get(i);
		}
		int caughtSharks=0;
		for (int i = 1; i <= C; i++) {
			//fisherman moves
			caughtSharks+=simulateFishing(i);
		}
		System.out.println(caughtSharks);
	}
	
	public static int simulateFishing(int pos) {
		int caught=0;
		//fisherman catches fish
		if(topMost[pos]!=null) {
			caught+=topMost[pos].z;
			sharks.remove(topMost[pos]);
		}
		
		topMost=new Shark[C+1];
		map=new Shark[R+1][C+1];
		
		for (int i = 0; i < sharks.size(); i++) {
			Shark shark=sharks.get(i);
			shark.prev_c=shark.c;

			if(R>1)
				shark.r=shark.r+(shark.s%((R-1)*2))*dr[shark.d];
			if(C>1)
				shark.c=shark.c+(shark.s%((C-1)*2))*dc[shark.d];
			if(shark.r>=R*2-1 && R>1) {
				shark.r=shark.r%((R-1)*2);
			}
			else if(shark.r<-((R-1)*2-1) && R>1) {
				shark.r=shark.r%-((R-1)*2);
			}
			else if(shark.c>=C*2 && C>1) {
				shark.c=shark.c%((C-1)*2);
			}
			else if(shark.c<-((C-1)*2-1) && C>1) {
				shark.c=shark.c%-((C-1)*2);
			}
			
			
			if(shark.r>R) {
				shark.r-=(shark.r-R)*2;
				if(shark.d<2)
					shark.d=(shark.d+1)%2;
				else if(shark.d<4)
					shark.d=(((shark.d-1)%2)+2);
			}
			if (shark.r<1) {
				shark.r=Math.abs(shark.r-2);
				
				if(shark.r>R) {
					shark.r-=(shark.r-R)*2;
				}
				else {
					if(shark.d<2)
						shark.d=(shark.d+1)%2;
					else if(shark.d<4)
						shark.d=(((shark.d-1)%2)+2);
				}
			}
			if (shark.c>C) {
				shark.c-=(shark.c-C)*2;
				if(shark.d<2)
					shark.d=(shark.d+1)%2;
				else if(shark.d<4)
					shark.d=(((shark.d-1)%2)+2);
			}
			if(shark.c<1) {
				shark.c=Math.abs(shark.c-2);
				if (shark.c>C) {
					shark.c-=(shark.c-C)*2;
				}
				else {
					if(shark.d<2)
						shark.d=(shark.d+1)%2;
					else if(shark.d<4)
						shark.d=(((shark.d-1)%2)+2);
				}
				
			}

			if(map[shark.r][shark.c]==null) 
				map[shark.r][shark.c]=shark;
			else {
				if(map[shark.r][shark.c].z>shark.z) {
					sharks.remove(shark);
					i--;
					continue;
				}
				else {
					if(topMost[shark.c]==map[shark.r][shark.c])
						topMost[shark.c]=shark;
					sharks.remove(map[shark.r][shark.c]);
					map[shark.r][shark.c]=shark;
				}
				i--;
			}
			
			if(topMost[shark.c]==null || topMost[shark.c].r>shark.r)
				topMost[shark.c]=shark;
		}
		
		return caught;
	}
	
	static void print() {
		for(int i=0;i<sharks.size();i++) {
			System.out.println(sharks.get(i));
		}
	}

}

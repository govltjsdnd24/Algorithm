package h_august_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Shark{
	int r,c,s,d,z;

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
//			System.out.println("caught : "+topMost[pos]);
			sharks.remove(topMost[pos]);
		}
		
		topMost=new Shark[C+1];
		//fish move
		for(Shark shark: sharks) {
//			System.out.println();
//			System.out.println("from: "+shark);
			shark.r=shark.r+shark.s*dr[shark.d];
			shark.c=shark.c+shark.s*dc[shark.d];
			
//			System.out.println("before: "+shark);
			
			boolean farpast=false;
			if(shark.r>=R*2) {
				shark.r=shark.r%((R-1)*2);
				farpast=true;
			}
			else if(shark.r<-((R-1)*2-1)) {
				shark.r=shark.r%-((R-1)*2);
				farpast=true;
			}
			else if(shark.c>=C*2) {
//				System.out.println(C*2);
//				System.out.println(shark.c);
				shark.c=shark.c%((C-1)*2);
				farpast=true;
			}
			else if(shark.c<-((C-1)*2-1)) {
				shark.c=shark.c%-((C-1)*2);
				farpast=true;
			}
			
			
//			System.out.println("r: "+shark.r+", c: "+ shark.c);
			
			if(shark.r>R) {
//				System.out.println(shark.r);
				shark.r-=(shark.r-R)*2;
//				System.out.println(shark.r);
				if(!farpast) {
					if(shark.d<2)
						shark.d=(shark.d+1)%2;
					else if(shark.d<4)
						shark.d=(((shark.d-1)%2)+2);
				}
			}
			else if (shark.r<1) {
				shark.r=Math.abs(shark.r-2);
				if(shark.r>R) {
					shark.r-=(shark.r-R)*2;
					farpast=true;
				}
				if(!farpast) {
					if(shark.d<2)
						shark.d=(shark.d+1)%2;
					else if(shark.d<4)
						shark.d=(((shark.d-1)%2)+2);
				}
			}
			else if (shark.c>C) {
//				System.out.println(shark.c);
				shark.c-=(shark.c-C)*2;
//				System.out.println(shark.c);
				if(!farpast) {
					if(shark.d<2)
						shark.d=(shark.d+1)%2;
					else if(shark.d<4)
						shark.d=(((shark.d-1)%2)+2);
				}
			}
			else if(shark.c<1) {
				shark.c=Math.abs(shark.c-2);
				if (shark.c>C) {
					shark.c-=(shark.c-C)*2;
					farpast=true;
				}
				if(!farpast) {
					if(shark.d<2)
						shark.d=(shark.d+1)%2;
					else if(shark.d<4)
						shark.d=(((shark.d-1)%2)+2);
				}
			}
			
//			System.out.println("after "+ shark);
			//deflect
//			while(true) {
//				if(shark.r>R) {
//					shark.r-=(shark.r-R)*2;
//					if(shark.d<2)
//						shark.d=(shark.d+1)%2;
//					else if(shark.d<4)
//						shark.d=(((shark.d-1)%2)+2);
//				}
//				else if (shark.r<1) {
//					shark.r=Math.abs(shark.r-2);
//					if(shark.d<2)
//						shark.d=(shark.d+1)%2;
//					else if(shark.d<4)
//						shark.d=(((shark.d-1)%2)+2);
//				}
//				else if (shark.c>C) {
//					shark.c-=(shark.c-C)*2;
//					if(shark.d<2)
//						shark.d=(shark.d+1)%2;
//					else if(shark.d<4)
//						shark.d=(((shark.d-1)%2)+2);
//				}
//				else if(shark.c<1) {
//					shark.c=Math.abs(shark.c-2);
//					if(shark.d<2)
//						shark.d=(shark.d+1)%2;
//					else if(shark.d<4)
//						shark.d=(((shark.d-1)%2)+2);
//				}
//				else
//					break;
//			}
			if(topMost[shark.c]==null || topMost[shark.c].r>shark.r)
				topMost[shark.c]=shark;
//			System.out.println("to: "+shark);
		}
		
		
		//fish eat (optional)
		for(int i=0; i<sharks.size();i++) {
			for (int j = 0; j < sharks.size(); j++) {
				if(i!=j && sharks.get(i).r==sharks.get(j).r && sharks.get(i).c==sharks.get(j).c) {
					if(sharks.get(i).z>sharks.get(j).z) {
						if(topMost[sharks.get(i).c]==sharks.get(j))
							topMost[sharks.get(i).c]=sharks.get(i);
						sharks.remove(j);
						if(j<i)
							if(i!=0)
								i--;
						if(j!=0)
							j--;
					}
					else if(sharks.get(i).z<sharks.get(j).z) {
						if(topMost[sharks.get(i).c]==sharks.get(i))
							topMost[sharks.get(i).c]=sharks.get(j);
						sharks.remove(i);
						if(i<j)
							if(j!=0)
								j--;
						if(i!=0)
							i--;
					}
				}
			}
		}
//		print();
//		System.out.println(sharks.size());
//		System.out.println();
		
//		for (int i = 0; i < topMost.length; i++) {
//			System.out.println(topMost[i]);
//		}
//		System.out.println();
//		System.out.println("end");
		
		return caught;
	}
	
	static void print() {
		for(int i=0;i<sharks.size();i++) {
			System.out.println(sharks.get(i));
		}
	}

}

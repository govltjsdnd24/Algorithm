package h_august_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Magnet{
	char[]cogs=new char[8];
	
	void turnClockwise() {
		char temp=cogs[7];
		for(int i=0;i<7;i++) {
			cogs[i]=cogs[i+1];
		}
		cogs[0]=temp;
	}
	void turnCounterClockwise() {
		char temp=cogs[0];
		for(int i=7;i>0;i--) {
			cogs[i]=cogs[i-1];
		}
		cogs[7]=temp;
	}
	boolean isTurnable(int side,char c) {
		if(cogs[side]!=c)
			return true;
		else
			return false;
	}
	
}

public class SWEA_4012_특이한자석 {
	
	static int K;
	static Magnet[]magnets=new Magnet[4];
	static int[][] moves;
	
	static final int ARROWPOS=0;
	static final int RIGHTCOG=2;
	static final int LEFTCOG=6;

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());

		int T=Integer.parseInt(st.nextToken());

		int i,j,k;
		
		for(int testcase=1;testcase<=T;testcase++) {
			int sum=0;
			st= new StringTokenizer(br.readLine());
			K=Integer.parseInt(st.nextToken());
			
			moves=new int[K][2];
			
			for(i=0;i<4;i++) {
				magnets[i]=new Magnet();
				st= new StringTokenizer(br.readLine());
				for(j=0;j<8;j++) {
					int temp=Integer.parseInt(st.nextToken());
					magnets[i].cogs[j]=(temp==0?'N':'S');
				}
			}
			
			for (k = 0; k < K; k++) {
				st= new StringTokenizer(br.readLine());
				turnCogwheel(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			for (i = 0; i < 4; i++) {
				if(magnets[i].cogs[ARROWPOS]=='S') {
					int score=i*2;
					sum+=(score!=0?i*2:0);
				}
			}
			
			System.out.println("#"+testcase+" "+sum);
		}
		
	}
	
	public static void turnCogwheel(int index,int direction) {
		int current=index-1;
		if(direction==1) {
			magnets[current].turnClockwise();
			int tempD=direction*-1;
			for(int i=current;i>0;--i) {
				if(magnets[i].isTurnable(LEFTCOG, magnets[i-1].cogs[RIGHTCOG])){
					if(tempD==1)
						magnets[i-1].turnClockwise();
					else
						magnets[i-1].turnCounterClockwise();
					tempD=direction*-1;
				}
				else
					break;
			}
			for(int i=current;i<7;++i) {
				if(magnets[i].isTurnable(RIGHTCOG, magnets[i+1].cogs[LEFTCOG])){
					if(tempD==1)
						magnets[i+1].turnClockwise();
					else
						magnets[i+1].turnCounterClockwise();
					tempD=direction*-1;
				}
				else
					break;
			}
		}
		else if(direction==-1) {
			magnets[current].turnCounterClockwise();
			for(int i=current;i>=0;--i) {
				
			}
			for(int i=current;i<8;++i) {
				
			}
		}
	}

}

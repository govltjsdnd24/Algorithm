package j_october_10;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Magnet{
	char[]cogs=new char[8];
	
	void turnClockwise() {
		char temp=cogs[7];
		for(int i=7;i>0;i--) {
			cogs[i]=cogs[i-1];
		}
		cogs[0]=temp;
	}
	void turnCounterClockwise() {
		char temp=cogs[0];
		for(int i=0;i<7;i++) {
			cogs[i]=cogs[i+1];
		}
		cogs[7]=temp;
	}
	
	boolean isTurnable(int side,char c) {	
		if(cogs[side]!=c)
			return true;
		else
			return false;
	}
	@Override
	public String toString() {
		return "Magnet [cogs=" + Arrays.toString(cogs) + "]";
	}
	
}

public class BAEKJOON_14891_톱니바퀴 {
	
	static int K;
	static Magnet[]magnets;
	static boolean[]visited;
	static int[][] moves;
	
	static final int ARROWPOS=0;
	static final int RIGHTCOG=2;
	static final int LEFTCOG=6;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		int i,j,k;	
		magnets=new Magnet[4];
		
		for(i=0;i<4;i++) {
			line=br.readLine();
			magnets[i]=new Magnet();
			for(j=0;j<8;j++) {
				int temp=line.charAt(j)-'0';
				magnets[i].cogs[j]=(temp==0?'N':'S');
			}
		}
		
		StringTokenizer st= new StringTokenizer(br.readLine());	

		int sum=0;
		K=Integer.parseInt(st.nextToken());

		for (k = 0; k < K; k++) {
			st= new StringTokenizer(br.readLine());
			visited=new boolean[4];
			int index=Integer.parseInt(st.nextToken())-1;
			
			visited[index]=true;
			turnCogwheel(index,Integer.parseInt(st.nextToken()));

		}
		
		for (i = 0; i < 4; i++) {
			if(magnets[i].cogs[ARROWPOS]=='S') {
				sum+=Math.pow(2, i);
			}
		}
		
		System.out.println(sum);
		
		
	}
	
	public static void turnCogwheel(int index,int direction) {
		
		boolean left=false,right=false;
		
		if(index-1>=0 && !visited[index-1])
			left=magnets[index].isTurnable(LEFTCOG,magnets[index-1].cogs[RIGHTCOG]);
		if(index+1<4 && !visited[index+1])
			right=magnets[index].isTurnable(RIGHTCOG,magnets[index+1].cogs[LEFTCOG]);
		
		if(direction==1)
			magnets[index].turnClockwise();
		else
			magnets[index].turnCounterClockwise();
		
		if(left) {
			visited[index-1]=true;
			turnCogwheel(index-1,direction*-1);
		}
		if(right) {
			visited[index+1]=true;
			turnCogwheel(index+1,direction*-1);
		}
		
	}

}

package j_october_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Purifier{
	int upperR,upperC;
	int lowerR,lowerC;
	
	public int getUpperR() {
		return upperR;
	}
	public void setUpperR(int upperR) {
		this.upperR = upperR;
	}
	public int getUpperC() {
		return upperC;
	}
	public void setUpperC(int upperC) {
		this.upperC = upperC;
	}
	public int getLowerR() {
		return lowerR;
	}
	public void setLowerR(int lowerR) {
		this.lowerR = lowerR;
	}
	public int getLowerC() {
		return lowerC;
	}
	public void setLowerC(int lowerC) {
		this.lowerC = lowerC;
	}
	@Override
	public String toString() {
		return "Purifier [upperR=" + upperR + ", upperC=" + upperC + ", lowerR=" + lowerR + ", lowerC=" + lowerC + "]";
	}
	
}

public class BAEKJOON_17144_미세먼지안녕 {

	static Purifier purifier= new Purifier();
	static int R,C;
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		int T=Integer.parseInt(st.nextToken());

		int[][] room= new int[R][C];
		boolean upperCheck=false;
		
		for (int i = 0; i < R; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				room[i][j]=Integer.parseInt(st.nextToken());
				if(room[i][j]==-1) {
					if(!upperCheck) {
						purifier.setUpperR(i);
						purifier.setUpperC(j);
						upperCheck=true;
					}
					else {
						purifier.setLowerR(i);
						purifier.setLowerC(j);
					}
				}
			}
		}
		
		for (int i = 0; i < T; i++) {
			circulateRoom(room);
		}
		
		int sum=0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(room[i][j]!=-1)
					sum+=room[i][j];
			}
		}
		System.out.println(sum);
	}

	private static void circulateRoom(int[][] room) {
		
		int[][] originalRoom=new int[R][C];
		for (int i = 0; i < R; i++) {
			originalRoom[i]=room[i].clone();
		}
		
		//dust dispersion
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(originalRoom[r][c]>0) {
					int div=originalRoom[r][c]/5;
					int spread=0;
					for (int k = 0; k < 4; k++) {
						int nr=r+dr[k];
						int nc=c+dc[k];
						if(nr>=0 && nr<R && nc>=0 && nc<C && room[nr][nc]!=-1) {
							room[nr][nc]+=div;
							spread++;
						}
					}
					room[r][c]-=(div*spread);
				}
			}
		}

		
		//purifier circulation
		//upper
		int temp=0;
		for (int i = purifier.getUpperR(); i > 0; i--) {
			temp=room[i][0];
			room[i][0]=room[i-1][0];
			room[i-1][0]=temp;
		}
		
		room[purifier.getUpperR()][0]=-1;
		room[0][0]=0;
		
		for (int i = 1; i <C; i++) {
			temp=room[0][i];
			room[0][i]=room[0][i-1];
			room[0][i-1]=temp;
		}
		
		for (int i = 1; i <= purifier.getUpperR(); i++) {
			temp=room[i][C-1];
			room[i][C-1]=room[i-1][C-1];
			room[i-1][C-1]=temp;
		}
		
		for (int i =C-1; i > 1; i--) {
			temp=room[purifier.getUpperR()][i];
			room[purifier.getUpperR()][i]=room[purifier.getUpperR()][i-1];
			room[purifier.getUpperR()][i-1]=temp;
		}

		//lower
		temp=0;
		for (int i = purifier.getLowerR(); i <R; i++) {
			temp=room[i][0];
			room[i][0]=room[i-1][0];
			room[i-1][0]=temp;
		}

		room[purifier.getLowerR()][0]=-1;
		room[R-1][0]=0;

		for (int i = 1; i <C; i++) {
			temp=room[R-1][i];
			room[R-1][i]=room[R-1][i-1];
			room[R-1][i-1]=temp;
		}
		
		for (int i = R-1; i > purifier.getLowerR(); i--) {
			temp=room[i][C-1];
			room[i][C-1]=room[i-1][C-1];
			room[i-1][C-1]=temp;
		}
		
		for (int i =C-1; i > 1; i--) {
			temp=room[purifier.getLowerR()][i];
			room[purifier.getLowerR()][i]=room[purifier.getLowerR()][i-1];
			room[purifier.getLowerR()][i-1]=temp;
		}
		
	}
	
	private static void print(int [][]map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

}

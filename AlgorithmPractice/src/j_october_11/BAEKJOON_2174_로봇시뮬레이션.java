package j_october_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Robot{
	int r,c,d,n;

	public Robot(int c, int r, char d,int n) {
		this.r = BAEKJOON_2174_로봇시뮬레이션.B-1-r;
		this.c = c;
		switch(d) {
		case 'N': this.d=0; break;
		case 'E': this.d=1; break;
		case 'S': this.d=2; break;
		case 'W': this.d=3; break;
		}
		this.n=n;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	@Override
	public String toString() {
		return "Robot [r=" + r + ", c=" + c + ", d=" + d + "]";
	}
	
}

public class BAEKJOON_2174_로봇시뮬레이션 {

	static int [][] map;
	static int A,B,N,M;
	
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		A=Integer.parseInt(st.nextToken());
		B=Integer.parseInt(st.nextToken());
		
		map=new int[B][A];
		
		st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		Robot[] robots= new Robot[N];
		
		int numbering=1;
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			robots[i]=new Robot(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,st.nextToken().charAt(0),numbering++);
		}
		
		for (int i = 0; i < M; i++) {
			st= new StringTokenizer(br.readLine());
			if(!simulate(robots,Integer.parseInt(st.nextToken()),st.nextToken().charAt(0),Integer.parseInt(st.nextToken())))
				return;
		}
		System.out.println("OK");
	}

	private static boolean simulate(Robot[] robots,int current, char command, int reps) {
		Robot robot=robots[current-1];
		
		for (int i = 0; i < reps; i++) {

			//execution
			switch(command) {
			case 'L':
				robot.setD(((robot.getD()-1)+4)%4);
				break;
			case 'R':
				robot.setD((robot.getD()+1)%4);
				break;
			case 'F':
				robot.setR(robot.getR()+dr[robot.getD()]);
				robot.setC(robot.getC()+dc[robot.getD()]);
				break;
			}
			//System.out.println(robot.getD());
			
			//check for robot collision
			int r=robot.getR();
			int c=robot.getC();
			for (int j = 0; j < robots.length; j++) {
				//System.out.println(robots[j].getR() + " : " + robots[j].getC());
				if(j!=current-1 && robots[j].getR()==r && robots[j].getC()==c) {
					System.out.println("Robot "+robot.n+" crashes into robot "+robots[j].getN());
					return false;
				}
			}
			
			//check for wall collision
			if(r<0 || r>=B || c<0 || c>=A) {
				System.out.println("Robot "+robot.n+" crashes into the wall");
				return false;
			}
			//System.out.println(robot.getN()+": "+r+","+c);
			
		}
		
		return true;
	}

}



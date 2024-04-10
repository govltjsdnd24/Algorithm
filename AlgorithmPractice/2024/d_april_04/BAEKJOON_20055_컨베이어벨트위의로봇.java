package d_april_04;

import java.io.*;
import java.util.*;

class Cell{
	int life;
	boolean robot=false;
	
	public Cell (int life) {
		this.life=life;
	}
	
	public boolean isRobot() {
		return robot;
	}
	
	public void swapRobot() {
		robot=!robot;
	}
	
	public void decreaseLife() {
		life--;
	}
	
	public String toString() {
		return "life: "+life+" robot: "+robot;
	}
}

public class BAEKJOON_20055_컨베이어벨트위의로봇 {
	
	static int N,K;
	
	static int zeros=0;
	
	static List<Cell>up=new ArrayList<Cell>();
	static List<Cell>down=new ArrayList<Cell>();

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());

		N= Integer.parseInt(st.nextToken()); //length of conveyer belt
		K=Integer.parseInt(st.nextToken()); //number of 0s to end
		
		//assign life to each conveyer cell
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			up.add(new Cell(Integer.parseInt(st.nextToken())));
		for(int i=0;i<N;i++)
			down.add(new Cell(Integer.parseInt(st.nextToken())));
		
		int stage;
		for(stage=0;zeros<K;++stage) {
			
			//1. rotate
			rotate();
			
			//2. move robot
			move();
			
			//3. put robot
			if(up.get(0).life>0) {
				up.get(0).swapRobot();
				up.get(0).decreaseLife();
				if(up.get(0).life==0)
					zeros++;
			}
			
		}
		
		System.out.println(stage);
	}
	
	static void rotate() {
		//remove
		Cell upRemoved=up.remove(N-1);
		Cell downRemoved=down.remove(N-1);
		//clear robot
		if(upRemoved.isRobot()) {
			upRemoved.swapRobot();
		}
		if(downRemoved.isRobot())
			downRemoved.swapRobot();
		//add
		up.add(0,downRemoved);
		down.add(0,upRemoved);
		//clear robot again
		if(up.get(N-1).isRobot()) {
			up.get(N-1).swapRobot();
		}
	}
	
	static void move() {
		for(int i=up.size()-2;i>=0;i--) {
			Cell current= up.get(i);
			Cell next= up.get(i+1);
			
			if(current.isRobot()) {
				if(!next.isRobot() && next.life!=0) {
					//remove from old
					current.swapRobot();
					//add to new
					next.swapRobot();
					next.decreaseLife();
					if(next.life==0)
						zeros++;
				}
			}
			
		}
	}
	
	static void print() {
		for(int i=0;i<up.size();i++) {
			System.out.println("Up "+i+": "+up.get(i));
		}
		for(int i=0;i<down.size();i++) {
			System.out.println("Down "+i+": "+down.get(i));
		}
	}

}

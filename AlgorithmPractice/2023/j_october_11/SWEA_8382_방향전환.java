package j_october_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Location{
	int x,y;

	public Location(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Location [x=" + x + ", y=" + y + "]";
	}
	
}

public class SWEA_8382_방향전환 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());

		int T=Integer.parseInt(st.nextToken());
		Location start,finish;
		for (int testcase = 1; testcase <= T; testcase++) {
			st= new StringTokenizer(br.readLine());
			start=new Location(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			finish= new Location(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			System.out.println("#"+testcase+" "+traverse(start,finish));
		}
	}

	private static int traverse(Location start, Location finish) {
		int x=Math.abs(start.getX()-finish.getX());
		int y=Math.abs(start.getY()-finish.getY());
		
		int h=(x+y)/2;
		return h*2+Math.abs(x-h) + Math.abs(y-h);
	}

}

package j_october_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point{
	int x,y;

	public Point(int x, int y) {
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
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}

public class SWEA_8458_원점으로집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());

		int T=Integer.parseInt(st.nextToken());
		int N;
		for (int testcase = 1; testcase <= T; testcase++) {
			st= new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			Point[] points= new Point[N];
			
			for (int i = 0; i < N; i++) {
				st= new StringTokenizer(br.readLine());
				points[i]=new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			System.out.println("#"+testcase+" "+collect(points));
		}
	}
	
	private static int traverse(Point point) {
		int x= Math.abs(point.getX());
		int y=Math.abs(point.getY());
		
		return x+y;
	}

	private static int collect(Point[] points) {
		int[] distances=new int[points.length];
		
		//find distance
		int max=traverse(points[0]);
		int even_odd=max%2;
		
		for (int i = 1; i < points.length; i++) {
			distances[i]=traverse(points[i]);
			if(even_odd!=distances[i]%2)
				return -1;
			max=Math.max(distances[i],max);
		}
		
		//stockpile
		int counter;
		int stockpile=0;
		for (counter= 1; stockpile< max || stockpile%2!=even_odd; counter++) 
			stockpile+=counter;
		
		return counter-1;
	}



}

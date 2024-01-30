package a_january_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
	int x,y;

	@Override
	public int compareTo(Point o) {
		int comp=Integer.compare(y, o.y);
		if(Integer.compare(y, o.y)==0)
			return Integer.compare(x, o.x);
		else return comp;
	}
	
}

public class BAEKJOON_11651_좌표정렬하기2 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        Point[] points= new Point[t];
        StringTokenizer st=new StringTokenizer("");
        for(int tc=1; tc<=t;tc++){
        	String line =br.readLine();
            int x=Integer.parseInt(st.nextToken(line));
            int y=Integer.parseInt(st.nextToken(line));
            System.out.println(x+" "+y);
            
        }

        System.out.println();
    }
}

package h_august_11;

import java.io.*;
import java.util.*;

class Reservation implements Comparable<Reservation>{
	private int start,end;
	public Reservation(int start,int end) {
		this.start=start; this.end=end;
	}
	public int getStart() {
		return start;
	}
	public int getEnd() {
		return end;
	}
	@Override
	public int compareTo(Reservation r) {
		if(this.end==r.end) {
			return(Integer.compare(this.start,r.start));
		}
		return(Integer.compare(this.end, r.end));
	}
	@Override
	public String toString() {
		return start + "," + end;
	}
}

public class BAEJOON_1931_회의실배정 {

	static Reservation[] reserves;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		
		int i,start,end;
		reserves= new Reservation[N];
		for(i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			start=Integer.parseInt(st.nextToken());
			end=Integer.parseInt(st.nextToken());
			reserves[i]=new Reservation(start, end);
		}
		
		Arrays.sort(reserves);
		
		findMostReserve();
	}
	
	public static void findMostReserve() {
		int i,j;
		int count=1;
		Reservation current=reserves[0];
		for(i=1;i<N;i++) {
			if(reserves[i].getStart()>=current.getEnd()) {
				current=reserves[i];
				count++;
			}
		}
		System.out.println(count);
	}

}

package i_september_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_13485_시험감독 {

	static int N,B,C;
	static int A[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		
		A=new int[N];
		st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i]= Integer.parseInt(st.nextToken());
		}
		
		st= new StringTokenizer(br.readLine());
		B= Integer.parseInt(st.nextToken());
		C= Integer.parseInt(st.nextToken());
		
		System.out.println(countOverseer());
	}
	
	public static long countOverseer() {
		long mainOverseers=0;
		long subOverseers=0;
		
		for (int i = 0; i < N; i++) {
			//assign main overseer
			mainOverseers++;
			int students=A[i]-B;
			
			if(students>0) {
				subOverseers+=students/C;
				if(students%C>0)
					subOverseers++;
			}
		}
		
		return mainOverseers+subOverseers;
	}

}

package j_october_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_17281_야구 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int [][] innings=new int[N][9];
		
		for (int i = 0; i < args.length; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				innings[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
	}

}

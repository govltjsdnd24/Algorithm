package g_july_31;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BAEKJOON_15651 {
	
	static int[] arr;
	static int[] sel;
	static boolean[] v;
	static BufferedReader bis=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		
		String s= bis.readLine();
		String []ss=s.split(" ");

		int N=Integer.parseInt(ss[0]);
		int M=Integer.parseInt(ss[1]);
		
		arr=new int[N];
		sel=new int[M];
		v=new boolean[arr.length];
		
		for (int i = 1; i <= N; i++) {
			arr[i-1]=i;
		}
		
		recursive(0);
		bw.flush();
	}
	
	private static void recursive(int idx) throws IOException {
		//basis part

		if(idx==sel.length) {
			StringBuilder sb=new StringBuilder();
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i]);
				if(i!=sel.length-1)
					sb.append(" ");
			}
			sb.append("\n");
			bw.write(sb.toString());
			return;
		}
		
		//inductive part
		
		for (int i = 0; i < arr.length; i++) {
			sel[idx]=arr[i];
			recursive(idx+1);
		}
		
	}
}

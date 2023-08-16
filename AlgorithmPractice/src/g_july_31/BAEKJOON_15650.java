package g_july_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON_15650 {
	
	static int[] arr;
	static int[] sel;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader bis=new BufferedReader(new InputStreamReader(System.in));
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
		
		recursive(0,0);

	}
	
	private static void recursive(int idx,int k) {
		//basis part

		if(k==sel.length) {
			StringBuilder sb=new StringBuilder();
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i]);
				if(i!=sel.length-1)
					sb.append(" ");
			}
			sb.append("\n");
			System.out.print(sb.toString());
			return;
		}
		
		//inductive part
		
		for (int i = idx; i < arr.length; i++) {
			sel[k]=arr[i];
			recursive(i+1,k+1);
		}
		
	}
}

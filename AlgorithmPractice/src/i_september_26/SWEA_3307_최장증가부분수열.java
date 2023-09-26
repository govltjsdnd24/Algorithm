package i_september_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3307_최장증가부분수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		int T= Integer.parseInt(st.nextToken());
		int N;
		int[] sequence;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st= new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			sequence=new int[N];
			
			st= new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				sequence[i]=Integer.parseInt(st.nextToken());
			}
			
			sb.append("#"+test_case+" "+find_length(sequence)+"\n");
			
		}
		System.out.println(sb.toString());
	}

	private static int find_length(int[] sequence) {
		int max_length=1;
		int[] LIS=new int[sequence.length];
		
		for (int i = 0; i < sequence.length; i++) {
			LIS[i]=1;
			for (int j = 0; j < i; j++) {
				if(sequence[j]<sequence[i] && LIS[i]<LIS[j]+1)
					LIS[i]=LIS[j]+1;
			}
			max_length=Math.max(max_length,LIS[i]);
		}
		
		return max_length;
	}

}

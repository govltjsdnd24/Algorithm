package j_october_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_14150_나무높이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());

		int T=Integer.parseInt(st.nextToken());	
		int N;
		for (int testcase = 1; testcase <= T; testcase++) {
			st= new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());	
			int trees[]=new int[N];
			
			st= new StringTokenizer(br.readLine());
			int max=0;
			for (int i = 0; i < N; i++) {
				trees[i]=Integer.parseInt(st.nextToken());
				max=Math.max(max, trees[i]);
			}
			
			System.out.println("#"+testcase+" "+calculateDays(trees,max));
		}
	}

	private static int calculateDays(int[] trees,int max) {
		//find difference
		int odds=0;
		int evens=0;
		for (int i = 0; i < trees.length; i++) {
			if(trees[i]!=max) {
				trees[i]=Math.abs(max-trees[i]);
				odds+=trees[i]%2;
				evens+=trees[i]/2;
			}
		}

		int diff=0;
		if(odds>evens) {
			diff=(evens*2)+(odds-evens)*2-1;
		}
		else if(evens>odds) {
			diff=(odds*2);
			int temp=evens-odds;
			diff+=(temp/3)*4;
			if(temp%3==1)
				diff+=2;
			else if(temp%3==2)
				diff+=3;
		}
		else if(evens==odds){
			diff=evens*2;
		}
		
		return diff;
	}

}

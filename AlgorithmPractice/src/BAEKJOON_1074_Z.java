package h_august_14;

import java.io.*;
import java.util.StringTokenizer;

public class BAEKJOON_1074_Z {
	
	static int[]sr= {0,0,1,1};
	static int[]sc= {0,1,0,1};
	
	static int N,r,c;
	static long counter=0;

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());

		traverseZ(0,0,(int)Math.pow(2, N));
		
	}
	
	public static void traverseZ(int br,int bc,int size) {
		int i;
		int cr,cc;
		if(size==2) {
			for(i=0;i<4;i++) {
				cr=br+sr[i];
				cc=bc+sc[i];
				if(cr==r && cc==c) {
					System.out.println(counter);
					return;
				}
				counter++;
			}
		}
		else {
			int half=size/2;
			
			if(r>=br && r<br+half && c>=bc && c<bc+half)
				traverseZ(br,bc,half);
			else
				counter+=half*half;
			
			if(r>=br && r<br+half && c>=bc+half && c<bc+size)
				traverseZ(br,bc+half,half);
			else 
				counter+=half*half;
			
			if(r>=br+half && r<br+size && c>=bc && c<bc+half)
				traverseZ(br+half,bc,half);
			else
				counter+=half*half;
			
			if(r>=br+half && r<br+size && c>=bc+half && c<bc+half*2)
				traverseZ(br+half,bc+half,half);
			else
				counter+=half*half;
		}
			
	}

}

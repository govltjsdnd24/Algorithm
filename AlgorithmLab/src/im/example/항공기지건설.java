package im.example;

import java.io.*;
import java.util.*;

public class 항공기지건설 {
	static int N,K,Ans,T;

	public static void main(String[] args) {
		System.setIn(new FileInputStream("항공기지건설.txt"));
		Scanner sc= new Scanner(System.in);
		T=sc.nextInt();
		N=sc.nextInt();
		K=sc.nextInt();
		
		for(int tc=1; tc<=T;tc++) {
			N=sc.nextInt();
			K=sc.nextInt();
			
			Ans=0;
			int[][]map= new int[N][N];
			for(int r =0; r<N;r++) {
				for(int c=0; c<N;c++) {
					map[r][c]=sc.nextInt();
				}
			}
			//print(map);
			
			//solution
			//시작점 순회
			
			for(int r =0; r<N;r++) {
				for(int c=0; c<N;c++) {
					int temp=0;
					// 끝점 순회
					for(int m =r; m<N;m++) {
						for(int n=c; n<N;n++) {
							//시작점 부터 끝점까지의 값이 k값을 넘는지 검사
							//선택영역안에서 최대 최소값의 차가 k 이하인지 검사
							int max=Integer.MIN_VALUE;
							int min=Integer.MAX_VALUE;
							for(int a=r;a<=N;a++) {
								for(int b=c;b<=N;b++) {
									max=Math.max(max, map[a][b]);
									min=Math.min(min, map[a][b]);
								}
							}
							//최대-최소<=K ? 면적계산 : pass
							if(Math.abs(max)-Math.abs(min)<=K){
								temp=Math.max(temp,Math.abs(m-r+1)*Math.abs(n-c+1));
							}
						}
					}
					Ans=Math.max(Ans,temp);
				}
			}
			System.out.println("#"+tc+" "+Ans);
		}
	}
	private static void print(int[][]map) {
		for(int r =0; r<N;r++) {
			for(int c=0; c<N;c++) {
				System.out.print(map[r][c]+" ");
			}
		}
	}

}

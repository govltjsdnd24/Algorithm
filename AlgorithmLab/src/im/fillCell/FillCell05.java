package im.fillCell;

import java.util.Scanner;
/*
 * 배열의 갯수와 좌표를 입력받아 상하좌우에 1을 표시한 후
 * 전체 배열을 화면에 출력
 * 경계선 체크
 * 지정한 범위까지 1을 표시합니다
 */

public class FillCell05 {

	public static void main(String[] args) {
		int N;
		Scanner sc= new Scanner(System.in);
		N=sc.nextInt();
		
		int[][]map= new int[N][N];
		int row_start=sc.nextInt();
		int column_start=sc.nextInt();
		int area=sc.nextInt();
		map[row_start][column_start]=1;
		
		int[]row_dimension= {-1,1,0,0,1,1,-1,-1};
		int[]column_dimension= {0,0,-1,1,1,-1,1,-1};
		
		//델타 방식
		
		for(int d=0;d<8;d++) {
			for(int cnt=1;cnt<=area;cnt++) {
				
				int nr=row_start+row_dimension[d]*cnt;
				int nc=column_start+column_dimension[d]*cnt;
				
				//check boundary
				if(nr>=0&&nr<N&&nc>=0&&nc<N) {
					map[nr][nc]=1;
				}
			}
		}
		 for(int a=0;a<map.length;a++) {
			 for(int b=0;b<map[a].length;b++) {
				 System.out.print(map[a][b]+ " ");
			 }
			 System.out.println();
		 }
		
	}

}

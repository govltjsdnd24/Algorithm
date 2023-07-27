package im.fillCell;

import java.util.Scanner;
/*
 * 배열의 갯수와 좌표를 입력받아 1을 표시한 후 전체 배열을 화면에 출력하세요.
 * 
 */

public class FillCell01 {
	
	public static void main(String[] args) {
		int N;
		Scanner sc= new Scanner(System.in);
		N=sc.nextInt();
		
		int[][]map= new int[N][N];
		int r=sc.nextInt();
		int c=sc.nextInt();
		map[r][c]=1;
		
		for(int i=0;r<map.length;r++) {
			for(int j=0;c<map[r].length;c++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}

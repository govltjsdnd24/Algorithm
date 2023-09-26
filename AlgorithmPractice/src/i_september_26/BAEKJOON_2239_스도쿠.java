package i_september_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Zero{
	private int r,c;

	public Zero(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
	
	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "Zero [r=" + r + ", c=" + c + "]";
	}
	
}


public class BAEKJOON_2239_스도쿠 {

	static final int SIZE=9;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] sudoku=new int[9][9];
		List<Zero> zeros= new ArrayList<Zero>();
		for (int i = 0; i < SIZE; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < SIZE; j++) {
				sudoku[i][j]=Integer.parseInt(st.nextToken());
				if(sudoku[i][j]==0) {
					zeros.add(new Zero(i,j));
				}
			}
		}
		
		fill_blanks(sudoku,zeros);
		print(sudoku);
	}

	private static void print(int[][] sudoku) {
		StringBuilder sb= new StringBuilder();
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if(j!=SIZE-1)
					sb.append(sudoku[i][j]+" ");
				else if (j==SIZE-1 && i!=SIZE-1)
					sb.append(sudoku[i][j]+"\n");
				else
					sb.append(sudoku[i][j]);
			}
		}
		System.out.println(sb.toString());
	}

	private static void fill_blanks(int[][] sudoku,List<Zero> zeros) {
//		recursion(sudoku,zeros,new int[zeros.size()],0,0);
	}
	
//	private static void recursion(int[][] sudoku,List<Zero>zeros,int[] values,int index, int num) {
//		//기저
//		if(num>SIZE) {
//			return;
//		}
//		if(index==zeros.size()) {
//			for (int i = 0; i <values.length; i++) {
//				sudoku[zeros.get(i).getR()][zeros.get(i).getC()]=values[i];
//			}
////			print(sudoku);
////			System.exit(0);
//			return;
//		}
//		
//		if(horizontal_check(sudoku,zeros.get(index),num) && vertical_check(sudoku,zeros.get(index),num) && grid_check(sudoku, zeros.get(index),num)) {
//			values[index]=num;
//			sudoku[zeros.get(index).getR()][zeros.get(index).getC()]=num;
//			recursion(sudoku,zeros,values,index+1,1);
//		}
//
//		//recursion
//		recursion(sudoku,zeros,values,index,num+1);
//	}
	
	private static void recursion(int[][] sudoku,int r, int c) {
		//기저
		if(c==SIZE) {
			return;
		}
		if(r==SIZE) {
			print(sudoku);
//			System.exit(0);
			return;
		}
		
		if(sudoku[r][c]==0) {
			for (int i = 1; i <=SIZE; i++) {
				if(horizontal_check(sudoku,new Zero(r,c),i) && vertical_check(sudoku,new Zero(r,c),i) && grid_check(sudoku,new Zero(r,c),i)) {
					sudoku[r][c]=i;
					recursion(sudoku,r,c+1);
				}
				sudoku[r][c]=0;
				return;
			}
		}

		//recursion
		recursion(sudoku,r,c+1);
	}
	
	
	private static boolean horizontal_check(int[][] sudoku, Zero zero, int num) {
		for (int i = 0; i < SIZE; i++) {
			if(sudoku[zero.getR()][i]==num && i!=zero.getC())
				return false;
		}
		return true;
	}
	
	private static boolean vertical_check(int[][] sudoku, Zero zero,int num) {
		for (int i = 0; i < SIZE; i++) {
			if(sudoku[i][zero.getC()]==num && i!=zero.getR())
				return false;
		}
		return true;
	}

	private static boolean grid_check(int[][] sudoku, Zero zero,int num) {

		int verticalStart=zero.getR()/3*3;
		int horinzontalStart=zero.getC()/3*3;
		
		for (int i = verticalStart; i < verticalStart+SIZE/3; i++) {
			for (int j = horinzontalStart; j < horinzontalStart+SIZE/3; j++) {
				if(sudoku[i][j]==num && i!=zero.getR() && j!=zero.getC())
					return false;
			}
		}
		return true;
	}

}

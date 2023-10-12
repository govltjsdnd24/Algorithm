package j_october_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_16935_배열돌리기3 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int R=Integer.parseInt(st.nextToken());
		int [][] array=new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				array[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st= new StringTokenizer(br.readLine());
		
		for (int i = 0; i < R; i++) {
			int operation=Integer.parseInt(st.nextToken());
			array=rotateArray(array,operation);
		}
		
		print(array);
	}

	private static int[][] rotateArray(int[][] array, int operation) {
		int[][] newArray=null;
		switch(operation) {
		case 1: newArray=upsideDown(array); break;
		case 2: newArray=leftToRight(array); break;
		case 3: newArray=clockwiseRotate(array); break;
		case 4: newArray=counterClockwiseRotate(array); break;
		case 5: newArray=dividedClockwise(array); break;
		case 6: newArray=dividedCounterClockwise(array); break;
		}
		return newArray;
	}

	private static int[][] upsideDown(int[][] array) {
		int[][] copied=new int[array.length][array[0].length];
		
		for (int i = 0; i<array.length; i++) {
			copied[i]=array[array.length-i-1].clone();
		}
		
		return copied;
	}

	private static int[][] leftToRight(int[][] array) {
		int[][] copied=new int[array.length][array[0].length];
		
		for (int i = 0; i<array[0].length; i++) {
			for (int j = 0; j < array.length; j++) {
				copied[j][i]=array[j][array[0].length-i-1];
			}
		}
		
		return copied;
	}
	
	private static int[][] clockwiseRotate(int[][] array) {
		int[][] copied=new int[array[0].length][array.length];
		
		for (int i = 0; i<array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				copied[j][array.length-i-1]=array[i][j];
			}
		}
		
		return copied;
	}

	private static int[][] counterClockwiseRotate(int[][] array) {
		int[][] copied=new int[array[0].length][array.length];
		
		for (int i = 0; i<array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				copied[array[0].length-j-1][i]=array[i][j];
			}
		}
		
		return copied;
	}
	
	private static int[][] dividedClockwise(int[][] array) {
		int[][][] divCopied=new int[4][array.length/2][array[0].length/2];
		int[][] copied=new int[array.length][array[0].length];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < array.length/2; j++) {
				for (int k = 0; k < array[0].length/2; k++) {
					divCopied[i][j][k]=array[(i/2)*(array.length/2)+j][(i%2)*(array[0].length/2)+k];
					//copied[(((i+1)%4)/2)*(array.length/2)+j][(((i+1)%4)%2)*(array[0].length/2)+k]=array[(i/2)*(array.length/2)+j][(i%2)*(array[0].length/2)+k];
				}
			}
		}
		
		for (int i = 0; i < array.length/2; i++) {
			for (int j = 0; j < array[0].length/2; j++) {
				copied[i][j+array[0].length/2]=divCopied[0][i][j];
				copied[i+array.length/2][j+array[0].length/2]=divCopied[1][i][j];
				copied[i+array.length/2][j]=divCopied[3][i][j];
				copied[i][j]=divCopied[2][i][j];
			}
		}
		
		return copied;
	}

	private static int[][] dividedCounterClockwise(int[][] array) {
		int[][][] divCopied=new int[4][array.length/2][array[0].length/2];
		int[][] copied=new int[array.length][array[0].length];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < array.length/2; j++) {
				for (int k = 0; k < array[0].length/2; k++) {
					divCopied[i][j][k]=array[(i/2)*(array.length/2)+j][(i%2)*(array[0].length/2)+k];
				}
			}
		}
		
		for (int i = 0; i < array.length/2; i++) {
			for (int j = 0; j < array[0].length/2; j++) {
				copied[i][j+array[0].length/2]=divCopied[3][i][j];
				copied[i+array.length/2][j+array[0].length/2]=divCopied[2][i][j];
				copied[i+array.length/2][j]=divCopied[0][i][j];
				copied[i][j]=divCopied[1][i][j];
			}
		}
		
		return copied;
	}

	private static void print(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
	}

}

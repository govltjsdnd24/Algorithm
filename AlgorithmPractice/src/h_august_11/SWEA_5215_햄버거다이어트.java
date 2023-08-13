package h_august_11;
import java.util.Scanner;

class SWEA_5215_햄버거다이어트
{
	static int [][]calScore;
	static int [][]scores;
	static int N,L,Ans;
	static int [] sel;
	
	public static void main(String[] args)  {
		Scanner scan=new Scanner(System.in);
		int test_case,t;
		int i,j;
		
		t=scan.nextInt();
		for(test_case=1;test_case<=t;test_case++) {
			N=scan.nextInt();
			L=scan.nextInt();
			Ans=Integer.MIN_VALUE;
			
			calScore=new int [N][2];
			sel=new int[N];
			
			for(i=0;i<N;i++) 
				for(j=0;j<2;j++) {
					calScore[i][j]=scan.nextInt();
				}
			
			boolean [] sel= new boolean [N];
			recursion(0,sel);
			
			System.out.println("#"+test_case+" "+Ans);
		}

	}
	
	public static void recursion(int index, boolean[] sel) {
		//basis part
		
		if(index==N) {
			int sum=0;
			int taste=0;
			
			for (int i = 0; i < sel.length; i++) {
				if(sel[i]) {
					sum+= calScore[i][1];
					taste+=calScore[i][0];
				}
			}
			if(sum<=L) {
				Ans= Math.max(Ans, taste);
			}
			return;
		}
		
		//inductive part
		
		//재료 선택 하는 경우
		sel[index]=true;
		recursion(index+1,sel);
		//재료 선택 않는 경우
		sel[index]=false;
		recursion(index+1,sel);
	}
}
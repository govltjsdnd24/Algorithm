package h_august_11;
import java.util.Scanner;
import java.util.HashMap;

public class Hamburger {
	

	public static void main(String[] args) {
		int test_case,t;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		int N, L;
		int i,j;
		double max,temp;
		int max_pos;
		int [][]ingredient;
		double calories;
		
//		double [] ratio;
		HashMap<Integer,Double> ratio= new HashMap();
		HashMap<Integer,Double> sorted= new HashMap();
		
		for(test_case=1;test_case<=t;test_case++) {
			calories=0;
			
			N=sc.nextInt();
			L=sc.nextInt();
			
			ingredient= new int[N][N];
			
//			ratio= new double[N];
			
			for(i=0;i<N;i++) {
				ingredient[i][0]=sc.nextInt();
				ingredient[i][1]=sc.nextInt();
				ratio.put(i,(double)ingredient[i][0]/(double)ingredient[i][1]);
//				ratio[i]=(double)ingredient[i][1]/(double)ingredient[i][0];
			}
			

//			max=0;
//			List<Double>arr= new ArrayList<>(ratio.keySet());

//			Collections.sort(arr);
//			for(Double doub:arr) {
//				sorted.put(doub,arr.get(doub));
//			}
			
			while(true) {
				max=Integer.MIN_VALUE;
				max_pos=0;
				for(Integer in:ratio.keySet()) {
					temp=Math.max(max, ratio.get(in));
					if(temp>max) {
						max=temp;
						max_pos=in;
					}
				}
				if(calories+ingredient[max_pos][1]<L) {
					calories+=ingredient[max_pos][1];
					ratio.remove(max_pos);
				}
				else
					break;
			}
			System.out.println("#"+test_case+" "+calories);
			
			
//			for(i=0;i<N;i++) {
//				max=Math.max(ratio[i], max);
//			}
			
			
			
		}

	}

}

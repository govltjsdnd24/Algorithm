package july_17;

import java.util.Scanner;

public class SWEA_7272 {
	
	public static boolean hole_compare(char c1,char c2) {
		int atn1=(int)c1;
        int atn2=(int)c2;
		if((atn1==67 || (atn1>=69 && atn1<=78) || (atn1>=83 &&atn1<=90)) &&
            (atn2==67 || (atn2>=69 && atn2<=78) || (atn2>=83 &&atn2<=90)))
			return true;
		else if((atn1==65 || atn1==68 || (atn1>=79 && atn1<=82)) && 
            (atn2==65 || atn2==68 || (atn2>=79 && atn2<=82)))
			return true;
		else if(atn1==66 && atn2==66)
			return true;
		else
            return false;
	}
	
	public static void main(String[] args) {
		int i,test_case;
		String input1,input2;
		int n1,n2;
		
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		for(test_case=1;test_case<=t;test_case++) {     
			input1=sc.next();
			input2=sc.next();
            
            if(input1.length()!=input2.length()){
                System.out.println("#"+test_case+" DIFF");
                continue;
            }
                
			n1=0;n2=0;
            int check=0;
			
			for(i=0;i<input1.length();i++) {
				if(!hole_compare(input1.charAt(i),input2.charAt(i))){
                    check=1;
                }
			}
			
			if(n1!=n2 || check==1)
				System.out.println("#"+test_case+" DIFF");
			else
				System.out.println("#"+test_case+" SAME");
			
		}
		
	}

}

package july_19;
import java.util.Scanner;

public class BAEKJOON_17413 {
	String S;
	String outS;
	
	int bracket_checker(int track) {
		int i;
		boolean closeFound=false;
		for(i=track;i<S.length();i++) {
			if(S.charAt(i)=='>') {
				closeFound=true;
				break;
			}
		}
		if(closeFound)
			outS+=S.substring(track,i+1);
		return i;
	}
	
	void revert_string(String subStr, int track) {
		int i;
		String reverse="";
		for(i=subStr.length()-1;i>=0;i--) {
			reverse+=subStr.charAt(i);
		}
		outS+=reverse;
	}
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String temp="";
		
		BAEKJOON_17413 bj=new BAEKJOON_17413();
		bj.S=sc.nextLine();
		bj.outS="";
		
		int i;
		
		for(i=0;i<bj.S.length();i++) {
			//bracket checker
			if(bj.S.charAt(i)=='<') {
				bj.revert_string(temp,i);
				i=bj.bracket_checker(i);
				temp="";
			}
			//space checker
			else if(bj.S.charAt(i)==' ') {
				bj.revert_string(temp,i);
				bj.outS+=" ";
				temp="";
			}
			//alphabet checker
			else {
				temp+=bj.S.charAt(i);
				if(i==bj.S.length()-1) {
					bj.revert_string(temp,i);
				}	
			}
		}
		System.out.println(bj.outS);
	}
}

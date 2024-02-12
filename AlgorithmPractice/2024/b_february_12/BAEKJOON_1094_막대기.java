package b_february_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON_1094_막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n=Integer.parseInt(br.readLine());
        String bitStr= Integer.toBinaryString(n);
        int ones=0;
        for(int i=0;i<bitStr.length();i++) {
        	if(bitStr.charAt(i)=='1')
        		ones++;
        }
       
        
        System.out.println(ones);
    }
}

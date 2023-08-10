package august_10;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class BAEKJOON_28278_스택2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s =  new Stack<Integer>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            
            switch (num) {
            case 1:
                int num2 = Integer.parseInt(st.nextToken());
                s.add(num2);
                break;
            case 2:
                if (s.isEmpty()) {
                    sb.append(-1 + "\n");
                }else {
                    sb.append(s.pop() + "\n");
                }
                break;
            case 3:
                sb.append(s.size() + "\n");
                break;
            case 4:
                if (s.isEmpty()) {
                    sb.append(1 + "\n");
                }else {
                    sb.append(0 + "\n");
                }
                
                break;
            case 5:
                if (s.isEmpty()) {
                    sb.append(-1 + "\n");
                }else {
                    sb.append(s.peek() + "\n");
                }
                break;

            default:
                break;
            }
        }
        System.out.println(sb);
    }
    
}
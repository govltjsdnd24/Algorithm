package l_december_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * packageName : l_december_26
 * fileName : BAEKJOON_4949
 * author : KRSWC_ADM
 * date : 2024-12-26
 * description :
 * 요약 : 균형잡힌 세상
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-12-26         KRSWC_ADM          최초 생성
 */
public class BAEKJOON_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Stack<Character> stack;
        Loop:
        while(!(line=br.readLine()).equals(".")){
            stack=new Stack<>();
            for(char c:line.toCharArray()) {
                switch(c){
                    case '(':
                    case '[':
                        stack.push(c);
                        break;
                    case ')':
                        if(stack.isEmpty() || stack.pop()!='(') {
                            System.out.println("no");
                            continue Loop;
                        }
                        else
                            break;
                    case ']':
                        if(stack.isEmpty() || stack.pop()!='['){
                            System.out.println("no");
                            continue Loop;
                        }
                        else
                            break;
                    case '.':
                        if(!stack.isEmpty()){
                            System.out.println("no");
                            continue Loop;
                        }
                    default:
                        break;
                }
            }
            System.out.println("yes");
        }
    }
}

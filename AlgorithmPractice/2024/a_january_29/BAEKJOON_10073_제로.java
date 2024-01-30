import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n=Integer.parseInt(br.readLine());
        Long sum=0L;
        Stack<Integer> stack= new Stack<Integer>();
        for(int tc=1; tc<=n;tc++){
            int num=Integer.parseInt(br.readLine());
            
            if(num!=0) {
                stack.push(num);
            }
            else {
                stack.pop();
            }
        }
        int size=stack.size();
        for(int i=0;i<size;i++){
            sum+=stack.peek();
            stack.pop();
        }
        
        System.out.println(sum);
    }
}

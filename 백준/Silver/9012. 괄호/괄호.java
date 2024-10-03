import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t = 0; t<T; t++){
            String answer = "YES";
            Stack<Character> stack = new Stack<>();
            String com = br.readLine();

            for(int i=0; i<com.length(); i++){
                char s = com.charAt(i);

                // 여는 괄호는 스택에 무조건 저장
                if(s=='(') stack.push(s);
                else{
                    // 닫는 괄호는 열린 괄호 짝이 있을 때에만 정상
                    if(stack.isEmpty() || stack.pop()!='('){
                        answer = "NO";
                        break;
                    }
                }
            }
            
            // 모든 과정을 끝내고, 열린 괄호가 스택에 남아있다면 NO
            if(!stack.isEmpty()) answer = "NO";

            System.out.println(answer);
        }
    }
}
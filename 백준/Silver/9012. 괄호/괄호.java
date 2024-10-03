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

                if(s=='(') stack.push(s);
                else{
                    if(stack.isEmpty() || stack.pop()!='('){
                        answer = "NO";
                        break;
                    }
                }
            }

            if(!stack.isEmpty()) answer = "NO";

            System.out.println(answer);
        }
    }
}
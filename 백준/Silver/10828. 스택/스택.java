import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<t; i++){
            String str = br.readLine();
            String[] command = str.split(" ");

            if(command.length > 1){ // push 명령
                int n = Integer.parseInt(command[1]);

                stack.push(n);
            }
            else { // 나머지 명령 처리
                switch(command[0]){
                    case "pop":
                        if(stack.isEmpty()) System.out.println(-1);
                        else System.out.println(stack.pop());
                        break;
                    case "size":
                        System.out.println(stack.size());
                        break;
                    case "empty":
                        if(stack.isEmpty()) System.out.println(1);
                        else System.out.println(0);
                        break;
                    case "top":
                        if(stack.isEmpty()) System.out.println(-1);
                        else System.out.println(stack.peek());
                        break;
                    default:
                        break;
                }
            }
        }

    }
}
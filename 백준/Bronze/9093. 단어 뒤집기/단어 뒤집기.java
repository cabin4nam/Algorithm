import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int t= 0; t<T; t++) {
            String str = br.readLine();

            String[] tokens = str.split(" ");

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tokens.length; i++) {
                String s = tokens[i];

                Stack<String> stack = new Stack<>();
                for (int j = 0; j < s.length(); j++) {
                    stack.push(String.valueOf(s.charAt(j)));
                }

                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }

                sb.append(" ");

            }

            System.out.println(sb.toString());
        }

    }

}
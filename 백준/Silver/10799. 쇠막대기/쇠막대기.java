import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int answer=0;
        Stack<Integer> stack = new Stack<>();

        int index = 0;
        while(index < str.length()){
            char thisChar = str.charAt(index);

            if(thisChar == '('){
                stack.push(index);
            }
            else { // 닫힌 괄호
                int prevChar = stack.pop();

                if(index - prevChar == 1) { // 레이저
                    answer += stack.size();
                }
                else answer++;
            }
            index ++;
        }

        answer += stack.size();

        System.out.println(answer);

    }
}
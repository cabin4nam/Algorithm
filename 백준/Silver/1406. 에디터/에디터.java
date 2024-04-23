import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int count = Integer.parseInt(br.readLine());

        Stack<String> leftStack = new Stack<>();
        Stack<String> rightStack = new Stack<>();

        for(int i=0; i<str.length(); i++){
            leftStack.push(str.substring(i, i+1));
        }

        for(int i=0; i<count; i++){
            String command = br.readLine();
            
            if(command.startsWith("L")){ // 왼쪽으로 커서 이동
                if(leftStack.empty()) continue;
                String text = leftStack.pop();
                rightStack.push(text);
            }
            else if(command.startsWith("D")){ // 오른쪽으로 커서 이동
                if(rightStack.empty()) continue;
                String text = rightStack.pop();
                leftStack.push(text);
            }
            else if(command.startsWith("B")){ // 커서에 왼쪽에 있는  문자 삭제
                if(leftStack.empty()) continue;
                leftStack.pop();
            }
            else { // 커서에 문자 추가
                String newText = command.split(" ")[1];
                leftStack.push(newText);
            }
        }

        while(!leftStack.empty()){
            String text = leftStack.pop();
            rightStack.push(text);
        }

        StringBuilder st = new StringBuilder();
        while(!rightStack.empty()){
            st.append(rightStack.pop());
        }
        System.out.println(st);

    }
}
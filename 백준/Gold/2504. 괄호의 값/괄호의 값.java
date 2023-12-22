import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        Stack<Character> st = new Stack<>();
        boolean flag = true;
        int answer = 0;
        int cnt =1;
        for(int i=0; i<line.length(); i++) {
            char cur = line.charAt(i);
            // ( 이면 스택에 넣어주고, cnt에 2를 곱해 ) 가 나오기 전까지의 값들에 2가 추가로 곱해지도록 함
            if(cur == '(') {
                st.push(cur);
                cnt *= 2;
            }
            // [ 이면 스택에 넣어주고, cnt에 3을 곱해 ] 가 나오기 전까지의 값들에 3이 추가로 곱해지도록 함
            else if(cur == '[') {
                st.push(cur);
                cnt *= 3;
            }
            else {
                
                if(cur == ')') {
                    // ) 이지만, peek 한 값이 ( 이 아니라면 잘못된 괄호식 -> return;
                    if(st.isEmpty() || st.peek() != '(') {
                        flag=false;
                        break;
                    }
                    // ) 으로 한 괄호가 끝났으면, 이 때까지 계산한 값을 answer 에 반영
                    if(line.charAt(i-1) =='(') {
                        answer += cnt;
                    }
                    st.pop();
                    cnt /= 2; // 2를 곱해주기 위한 ()가 끝났으니, 2로 나누어 원상복귀
                }else if(cur==']') {
                    // ] 이지만, peek 한 값이 [ 이 아니라면 잘못된 괄호식 -> return;
                    if(st.isEmpty() || st.peek() != '[') {
                        flag=false;
                        break;
                    }
                    // ] 으로 한 괄호가 끝났으면, 이 때까지 계산한 값을 answer 에 반영
                    if(line.charAt(i-1)=='[') {
                        answer += cnt;
                    }
                    st.pop();
                    cnt /= 3; // 3를 곱해주기 위한 [] 가 끝났으니, 3으로 나누어 원상복귀
                }
                else {
                    flag = false;
                    break;
                }
            }
        }
        if(!flag || !st.isEmpty()) {
            System.out.println(0);
        }else {
            System.out.println(answer);
        }
    }
}
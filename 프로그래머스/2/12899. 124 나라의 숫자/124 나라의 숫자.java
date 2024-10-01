import java.util.*;
class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        String[] numArr = {"1", "2", "4"};
        Stack<String> stack = new Stack<>();
        while(n > 0){
            n--;
            int num = n%3;
            stack.push(numArr[num]);
            n /= 3;
        }
        
        while(!stack.isEmpty()) sb.append(stack.pop());
        answer = sb.toString();
        return answer;
    }
}
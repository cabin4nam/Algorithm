import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack stack = new Stack<String>();
        int idx = 0;
        
        while(idx < s.length()){
            String ch = s.substring(idx,idx+1);
            if(ch.equals("(")) stack.push(ch);
            else{
                if(stack.empty() || !(stack.peek().equals("("))){
                    answer = false;
                    break;
                } 
                
                stack.pop();
            }
            idx++;
        }
        
        if(!stack.empty()) answer = false;

        return answer;
    }
}
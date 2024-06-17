import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        Stack<String> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            String ch = s.substring(i, i+1);
            
            if(stack.empty() || !(stack.peek().equals(ch)))
                stack.push(ch);
            
            else stack.pop();
        }
        
        if(stack.empty()) answer = 1;
        else answer = 0;

        return answer;
    }
}
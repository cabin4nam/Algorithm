import java.util.Stack;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(stack.isEmpty()) stack.push(s.charAt(i));
            else if(s.charAt(i) == '(') stack.push('(');
            else {
                char c = stack.pop();
                
                if(c!='(') return false;
            }
        }
        
        if(!stack.isEmpty()) return false;
        
        return true;
    }
}
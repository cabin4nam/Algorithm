import java.util.Stack;

class Solution {
    private static StringBuilder sb;
    public int solution(String s) {
        int answer = 0;
        int openCnt = 0;
        int closeCnt = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[') openCnt ++;
            else closeCnt++;
        }
        
        if(openCnt != closeCnt) return 0;
        
        sb = new StringBuilder(s);
        for(int i=0; i<s.length(); i++){
            // 올바른지 확인
            if(isRight()) answer++;
                
            // 회전
            char str = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(String.valueOf(str));
            
        }
        
        return answer;
    }
    
    private static boolean isRight(){
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i)=='(' || sb.charAt(i)=='{' || sb.charAt(i)=='[') stack.push(sb.charAt(i));
            else {
                if(stack.isEmpty()) return false;
                
                char c = stack.pop();
                
                switch(sb.charAt(i)){
                    case ')' : if(c!='(') return false; break;
                    case '}' : if(c!='{') return false; break;
                    case ']' : if(c!='[') return false; break;
                    default: break;
                }
            }
        }
        
        if(!stack.isEmpty()) return false;
        
        return true;
    }
}
import java.util.*;
import java.lang.*;
class Solution {
    private static Stack<String> stack = new Stack<>();
    public int solution(String s) {
        int answer = 0;
        
        HashMap<String, String> map = new HashMap<>();
        map.put(")", "(");
        map.put("}", "{");
        map.put("]", "[");
        
        int n = s.length();
        s += s; // 문자열 뒤에 문자열 한 번 더 붙여서 두 번 반복되게
        // 회전시키기 -> 시작 인덱스를 하나씩 미뤄줌
        A : for(int i=0; i<n; i++){
            stack.clear();
            
            for(int j=i; j<i+n; j++){
                String ch = s.substring(j, j+1);
                if(!map.containsKey(ch)) // map에 key가 없다면, 열린괄호
                    stack.push(ch);
                
                else {
                    if(stack.empty() || !(stack.pop().equals(map.get(ch))))
                        continue A;
                }
            }
            
            if(stack.isEmpty()) answer ++;
            
        }
        
        
        return answer;
    }
}
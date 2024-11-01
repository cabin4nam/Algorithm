import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Queue<Character> q = new LinkedList<>();
        for(int i =0; i<s.length(); i++) q.offer(s.charAt(i));
        for(int i=0; i<s.length(); i++){
            // 올바른지 확인 -> 올바르면 answer에 더해주기
            ArrayList<Character> list = new ArrayList<>();
            for(Character c : q){
                list.add(c);
            }   
            if(isCorrect(list)) answer++;
            
            // 회전
            q.offer(q.poll());
        }
        return answer;
    }
    
    private static boolean isCorrect(ArrayList<Character> list){
        Stack<Character> stack = new Stack<>();
        
        for(Character c : list){
            if(c=='[' || c=='{' || c=='(') stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                
                Character peek = stack.peek();
                if(c==']' && peek=='[') stack.pop();
                else if(c=='}' && peek=='{') stack.pop();
                else if(c==')' && peek=='(') stack.pop();
                else return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}
import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> q1 = new LinkedList<>();
        for(String s : cards1) q1.offer(s);
        Queue<String> q2 = new LinkedList<>();
        for(String s: cards2) q2.offer(s);
        
        String card1 = q1.poll();
        String card2 = q2.poll();
        
        for(int i=0; i<goal.length; i++){
            String str = goal[i];
            
            if(str.equals(card1)){
                if(q1.isEmpty()) card1 = null;
                else card1 = q1.poll();  
            } 
            else if(str.equals(card2)){
                if(q2.isEmpty()) card2 = null;
                else card2 = q2.poll();
            } 
            else return "No";
        }
        
        return "Yes";
    }
}
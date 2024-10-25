import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        // 7 3 9
        int taskCnt = progresses.length;
        for(int i=0; i<taskCnt; i++){
            int remain = 100-progresses[i];
            
            if(remain%speeds[i]==0) q.offer(remain / speeds[i]);
            else q.offer(remain / speeds[i] + 1);
        }
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            int count =1;
            while(true){
                if(q.isEmpty() || q.peek() > now){
                    break;
                }
                
                q.poll();
                count++;
            }
            
            answer.add(count);
        }
        
        return answer;
    }
}
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int[] days = new int[progresses.length];
        for(int i=0; i<progresses.length; i++){
            int remain = 100-progresses[i];
            int speed = speeds[i];
            int day = remain/speed;
            
            if(remain%speed > 0) day++;
            
            days[i] = day;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int d : days){
            System.out.println();
            if(q.isEmpty()) q.offer(d);
            else{
                int prev = q.peek();
                
                // 현재 작업이 완료되기 전에 이전 작업 완료, 바로 배포
                if(prev < d){ 
                    answer.add(q.size());
                    q.clear();
                }
                
                // 현재 작업이 완료돼도 이전 작업이 아직 완료되지 않음, 이전 작업 완료 후 같이 배포
                q.offer(d);
            }
        }
        
        answer.add(q.size());
        
        return answer;
    }
}
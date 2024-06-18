import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int[] doneTime = new int[progresses.length];
        for(int i=0; i<progresses.length; i++){
            doneTime[i] = calcTime(progresses[i], speeds[i]);
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<doneTime.length; i++) queue.offer(doneTime[i]);
        
        while(!queue.isEmpty()){
            int time = queue.poll();
            
            int count = 1;
            while(!queue.isEmpty() && queue.peek() <= time){
                queue.poll();
                count ++;
            }
            
            answer.add(count);
        }
        
        
        return answer;
    }
    private int calcTime(int progress, int speed){
        int remain = 100 - progress;
        int time = 0;
        
        time = remain/speed;
        
        if(remain%speed > 0) time++;
        
        return time;
    }
}
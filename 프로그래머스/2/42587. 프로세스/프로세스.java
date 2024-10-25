import java.util.*;

class Solution {
    private static class Task{
        int id;
        int priority;
        public Task(int id, int priority){
            this.id = id;
            this.priority = priority;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Task> q = new LinkedList<>();
        for(int i=0; i<priorities.length; i++) q.offer(new Task(i, priorities[i]));
        
        int count = 0;
        while(!q.isEmpty()){
            Task t = q.poll();
            
            boolean canGo = true;
            Iterator<Task> iter = q.iterator();
            while(iter.hasNext()){
                Task temp = iter.next();
                
                if(temp.priority > t.priority){
                    q.offer(t);
                    canGo = false;
                    break;
                }
            }
            
            if(!canGo) continue;
            else count ++;
            
            if(t.id == location){
                answer = count;
                break;
            } 
        }
        
        return answer;
    }
}
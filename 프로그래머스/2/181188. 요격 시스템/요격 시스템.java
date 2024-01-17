import java.util.*;
class Solution {
    static class Target{
        int start;
        int end;
        
        public Target(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    
    public int solution(int[][] targets) {
        int answer = 0;
        
        PriorityQueue<Target> pq = new PriorityQueue<>(targets.length, new Comparator<Target>() {
            @Override
            public int compare(Target t1, Target t2) {
                if(t1.end >= t2.end) return 1;
                else return -1;
            }
        });
        
        for(int[] t : targets){
            pq.offer(new Target(t[0], t[1]));
        }
        
        while(!pq.isEmpty()){
            Target t = pq.poll();
            answer ++;
            
            while(true){
                Target t2 = pq.peek();
            
                if(t2==null) {
                    break;
                }
                if(t2.end > t.start && t2.start < t.end){
                    pq.poll();
                }
                else break;
            }
        }
        
      
        
        return answer;
    }
}
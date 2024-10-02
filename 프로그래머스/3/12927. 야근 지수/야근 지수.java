// 피로도 = 시작한 시점 + (남은일의 작업량)^2
// 1시간동안 작업량 1만큼 처리
import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int w : works){
            pq.offer(w);
        }
        
        for(int i=0; i<n; i++){
            if(pq.peek() == 0){
                break;
            } 
            
            // 가장 큰 작업을 줄이기
            int time = pq.poll();
            pq.offer(time-1);
        }
        
        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}
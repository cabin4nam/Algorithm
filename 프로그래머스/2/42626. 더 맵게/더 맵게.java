import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) pq.offer(s);
        
        while(!pq.isEmpty()){
            if(pq.peek() >= K) break;
            
            // 스코빌 지수가 K가 아닌 음식이 남아있을 경우
            if(pq.size() < 2) return -1;
            
            int f1 = pq.poll();
            int f2 = pq.poll();
            
            pq.offer(f1 + (f2*2));
            answer ++;
        }
        
        return answer;
    }
}
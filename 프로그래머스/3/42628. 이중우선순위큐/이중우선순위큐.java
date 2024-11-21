import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        
        // 기본 최소힙
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(String s : operations){
            String[] op = s.split(" ");
            String com = op[0];
            int num = Integer.parseInt(op[1]);

            if(com.equals("I")){
                pq.offer(num);
            }
            else{
                if(!pq.isEmpty()){
                   if(num==1){ // 최댓값 삭제
                        int max = Collections.max(pq); // 큐의 최대값 탐색
                        pq.remove(max); // 최대값 제거
                    }
                    else { // 최솟값 삭제
                        pq.poll();
                    } 
                }
            }
        }
        
        if(!pq.isEmpty()) {
            answer[0] = Collections.max(pq);
            answer[1] = pq.peek();
        }
       
        return answer;
    }
}
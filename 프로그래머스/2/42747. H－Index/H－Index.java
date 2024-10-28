import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        // 3 0 6 1 5
        // 6 5 3 1 0
        
        // i=0 -> 6편
        // i=1 -> 5편
        // i=2 -> 3번
        
        Arrays.sort(citations);
        
        for(int i=0; i<citations.length; i++){
            // 인용된 논문의 수
            int count = citations.length - i;
            
            if(count <= citations[i]){
                answer = count;
                break;
            }
        }
        
        return answer;
    }
}
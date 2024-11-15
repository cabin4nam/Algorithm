import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long left = 1;
        long right = times[times.length-1]*(long)n;
        long mid = 0;
        
        while(left <= right){
            mid = (left+right)/2;
            
            // mid 시간동안 심사할 수 있는 인원 체크
            long count = canDo(times, mid);
            
            if(count >= n){
                answer = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        
        return answer;
    }
    
    private static long canDo(int[] times, long time){
        long count = 0;
        for(int t : times){
            count += time/t;
        }
        
        return count;
    }
}
import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        Arrays.sort(times);
        
        long low = 0; // 최소 시간
        long high = times[times.length-1] * (long)n; // 최대 시간 : 가장 오래 걸리는 심사관이 모든 사람을 심사할 경우
        long mid;
        
        while(low <= high){
            mid = (low+high) / 2;
            
            // mid 시간동안 심사할 수 있는 최대 인원이 n명일 때 정답
            long count = countMax(mid, times);
            // if(n==count) return mid;
            if(n<=count){
                high = mid-1; 
                answer = mid;
            }  
            else low = mid+1;
        }
        
        return answer;
    }
    
    private static long countMax(long time, int[] times){
        long count = 0;
        
        for(int p : times){
            count += time/p;
        }
        
        return count;
    }
}
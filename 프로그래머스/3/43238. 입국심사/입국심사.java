import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        // 이분 탐색
        long left = 1; // 최소시간
        long right = times[times.length-1] * (long)n; // 최대시간
        long mid = 0;
        
        while(left <= right){
            mid = (left+right)/2;
            
            // mid 시간동안 입국심사관이 심사할 수 있는 사람의 수
            long count = 0;
            for(int t : times) count += mid/t;
            
            if(count >= n){ // n명보다 더 많이 심사할 수 있으면 -> 더 짧은 시간으로 조정
                answer = mid;
                right = mid-1;
            }
            else { // n명보다 적은 사람을 심사할 수 있으면 -> 시간 늘리기
                left = mid+1;
            }
        }
        
        return answer;
    }
}
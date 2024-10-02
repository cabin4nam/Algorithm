import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long left = 0;
        long right = times[times.length-1] * (long)n;
        
        while(left <= right){
            long mid = (left+right)/2;
            
            // mid에서 검사할 수 있는 모든 인원 합 구하기
            long sum=0;
            for(int i=0; i<times.length; i++)
                sum += mid/times[i];
            
            if(sum < n){ // 더 많은 시간이 필요함
                left = mid+1;
            }
            else {
                answer = mid;
                right = mid-1;
            }
        }
        
        return answer;
    }
}
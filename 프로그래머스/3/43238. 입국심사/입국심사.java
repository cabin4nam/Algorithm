import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        // 이진탐색을 위해 times를 sorting 해준다.
        Arrays.sort(times);
        
        long left = 0; // n명의 사람을 모두 심사하는 데 걸리는 최소 시간
        long right = (long)times[times.length -1] * n; //n명의 사람을 모두 심사하는 데 걸리는 최악의 시간 (심사가 오래 걸리는 사람이 모든 사람을 순차적으로 심사)
        
        while(left <= right){
            // 이진탐색에 필요한 mid(중간값) 구하기
            long mid = (left+right)/2;
            
            // mid 시간동안 심사할 수 있는 사람은 총 몇 명?
            long sum = 0;
            // 심사를 빨리 하는 심사관부터 시작해서 각 몇 명을 심사할 수 있는지 sum에 누적
            for(int i=0; i<times.length; i++){
                sum += mid/times[i];
            }
            
            // sum, 즉 총 심사 가능한 인원 수가 목표 인원수(n) 보다 작으면 -> 시간이 부족함 -> left를 늘려줌
            if(sum < n){
                left = mid+1;
            }
            // sum, 즉 총 심사 가능한 인원 수가 목표 인원수(n)를 충족하면(같거나 크면) -> 시간 충분함 -> 줄여볼까? -> right를 늘려줌
            else {
                right = mid-1;
                answer = answer > mid ? mid : answer;
            }
        }
        return answer;
    }
}
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 누적합 배열 생성
        int[] sum = new int[n+1];
        for(int i=1; i<=n; i++) sum[i] = sum[i-1] + i;
        
        int start = 1;
        int end = 1;
        
        while(start <= n && end <= n && start <= end){
            int s = sum[end]-sum[start-1];
            
            if(s >= n){
                if(s==n){
                    answer ++;
                } 
                
                start ++;
            }
            else {
                end ++;
            }
        }
        
        return answer;
    }
}
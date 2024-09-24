class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // dp 이용
        int[] dp = new int[60001];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i<=n; i++){
            // 마지막 타일이 가로로 끝날 때 + 세로로 끝날 때
            dp[i] += (dp[i-2] + dp[i-1]) % 1000000007;
        }
        
        answer = dp[n];
        return answer;
    }
}
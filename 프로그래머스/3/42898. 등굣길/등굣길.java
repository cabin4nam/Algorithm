class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // m이 가로, n이 세로 길이
        // dp[n][m] = (m,n)까지 갈 수 있는 최단 경로의 개수
        int[][] dp = new int[n+1][m+1];
        dp[1][1] = 1;
        for(int[] p : puddles){
            dp[p[1]][p[0]] = -1;
        }
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(dp[i][j] == -1) continue;
                
                // 오른쪽으로 이동
                if(j<m && dp[i][j+1] != -1){
                    dp[i][j+1] = (dp[i][j+1] + dp[i][j])%1000000007;
                }
                
                // 아래쪽으로 이동
                if(i<n && dp[i+1][j] != -1){
                    dp[i+1][j] = (dp[i+1][j] + dp[i][j])%1000000007;
                }
            }
        }
        
        return dp[n][m];
    }
}
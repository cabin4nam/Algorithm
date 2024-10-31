class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int size = triangle.length;
        
        int[][] dp = new int[size+1][size+1];
        dp[0][0] = triangle[0][0];
        
        if(size == 1) return triangle[0][0];
        
        for(int i=1; i<size; i++){
            // 이전 층의 수에 이번 층의 수를 더한
            for(int j=0; j<=i; j++){
                // 만약 맨 왼쪽 요소라면
                if(j==0) dp[i][j] = dp[i-1][j] + triangle[i][j];
                
                // 만약 맨 오른쪽 요소라면
                else if(j==i) dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                
                else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }
        
        for(int n : dp[size-1]){
            answer = Math.max(answer, n);
        }
        
        return answer;
    }
}
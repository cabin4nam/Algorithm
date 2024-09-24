class Solution {
    int solution(int[][] land) {
        int m = land.length; // 행의 개수 (세로)
        int n = 4; // 열의 개수 (가로)

        // DP 배열을 land 배열과 동일한 크기로 생성
        int[][] dp = new int[m][n];

        // 첫 번째 행은 그대로 초기화
        for (int j = 0; j < n; j++) {
            dp[0][j] = land[0][j];
        }

        // 두 번째 행부터 DP 계산
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 이전 행에서 같은 열을 제외한 최대값을 찾고, 해당 값을 현재 값에 더함
                for (int k = 0; k < n; k++) {
                    if (k != j) { // 같은 열을 제외한 값들 중 최대값
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + land[i][j]);
                    }
                }
            }
        }

        // 마지막 행에서 최댓값 찾기
        int answer = 0;
        for (int j = 0; j < n; j++) {
            answer = Math.max(answer, dp[m-1][j]);
        }

        return answer;
    }
}

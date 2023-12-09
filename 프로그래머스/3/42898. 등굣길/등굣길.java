class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // 행열을 반대로 알려주고 있음 -> m x n 배열 -> int[n+1][m+1]
        // 배열 상에서는 int[][]의 각 요소가 세로, 가로 순
        // 문제 상에서는 int[][]의 각 요소가 가로, 세로 순
        
        int mod = 1000000007;
        
        int[][] map = new int[n+1][m+1];
        
        for(int i=0; i<puddles.length; i++){
            map[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        map[1][1] = 1;
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                // 현재 위치가 웅덩이라면 계산하지 않음
                if(map[i][j] == -1) continue; 
                
                // 위쪽으로부터 오는 경우 -> 위쪽이 물웅덩이가 아니면 현재 위치로 올 수 있는 경로로 더해줌
                if(map[i-1][j] > 0) map[i][j] += map[i-1][j] % mod;
                
                // 왼쪽으로부터 오는 경우 -> 위쪽이 물웅덩이가 아니면 현재 위치로 올 수 있는 경로로 더해줌
                if(map[i][j-1] > 0) map[i][j] += map[i][j-1] % mod;
             }
        }
        
        return map[n][m]%mod;
    }
}

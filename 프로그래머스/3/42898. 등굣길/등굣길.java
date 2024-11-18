class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        // 2차원 배열로 dp 저장
        int[][] map = new int[n+1][m+1];
        
        // 물웅덩이 -1로 표시
        for(int[] p : puddles){
            map[p[1]][p[0]] = -1;
        }
        map[1][1] = 1;
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(map[i][j]==-1) continue;
                
                // 오른쪽 이동
                if(j+1 <= m && map[i][j+1] != -1){
                    map[i][j+1] = (map[i][j] + map[i][j+1])%1000000007;
                }
                
                // 아래로 이동
                if(i+1 <= n && map[i+1][j] != -1){
                    map[i+1][j] = (map[i][j] + map[i+1][j])%1000000007;
                }
            }
        }
        
        
        answer = map[n][m];
        
        
        return answer;
    }
}
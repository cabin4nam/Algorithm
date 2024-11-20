class Solution {
    private static boolean[][] graph;
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        // 그래프를 사용하여 깊이 탐색을 통해, 각 선수가 이긴 선수, 진 선수의 수를 세기
        graph = new boolean[n+1][n+1];
        
        for(int[] r : results){
            int p1 = r[0];
            int p2 = r[1];
            
            graph[p1][p2] = true; // p1이 p2를 이겼음 (p1->p2)
        }
        
        for(int p=1; p<=n; p++){
            // p가 이긴 선수 수 
            // -1을 하는 이유는 winCount에서 자기 자신(가장 초기 count값 1)의 경우를 제외
            int win = winCount(p, new boolean[n+1], n)-1;
            // p가 진 선수 수
            int lose = loseCount(p, new boolean[n+1], n)-1;
            
            // 본인을 이기고 진 선수의 수 = 전체 게임의 수 (1번 선수는 나머지 4명과 게임. 한 명 당 전체 게임의 수 = 4) 라면, 순위를 정할 수 있음
            if(win+lose+1 == n) answer++;
        }
        
        
        return answer;
    }
    
    private static int winCount(int player, boolean[] visited, int n){
        int count = 1;
        
        for(int i=1; i<=n; i++){
            // player가 이긴 상대가 아니거나, 이미 방문한 경우라면 continue
            if(!graph[player][i] || visited[i]) continue;
            
            visited[i] = true;
            count += winCount(i, visited, n); // player가 이긴 상대가 이긴 상대는 몇 명?
        }
        
        return count;
    }
    
    private static int loseCount(int player, boolean[] visited, int n){
        int count = 1;
        
        for(int i=1; i<=n; i++){
            // player가 진 상대(player를 이긴 상대)가 아니거나, 
            // 이미 방문한 경우라면 continue
            if(!graph[i][player] || visited[i]) continue;
            
            visited[i] = true;
            count += loseCount(i, visited, n); // player를 이긴 상대를 이긴 상대는 몇 명?
        }
        
        return count;
    }
}
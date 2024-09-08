import java.util.*;

class Solution {
    static class Point {
        int r, c, depth;
        
        public Point(int r, int c, int depth) {
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }
    
    private static Point start;
    private static Point lever;
    private static Point exit;
    private static int n, m;
    private static int answer = -1;
    private static int[][] move = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        
        // 레버와 출구 위치 파악
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    start = new Point(i, j, 0);
                } else if (c == 'L') {
                    lever = new Point(i, j, 0);
                } else if (c == 'E') {
                    exit = new Point(i, j, 0);
                }
            }
        }
        
        // 1. 시작점 -> 레버까지 이동
        int toLever = bfs(maps, start, lever);
        
        // 레버까지 갈 수 없는 경우
        if (toLever == -1) return -1;
        
        // 2. 레버 -> 출구로 이동
        int toExit = bfs(maps, lever, exit);
        
        // 출구까지 갈 수 없는 경우
        if (toExit == -1) return -1;
        
        // 총 걸린 시간은 두 경로의 합
        return toLever + toExit;
    }
    
    // BFS 탐색 함수
    private static int bfs(String[] maps, Point start, Point goal) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        q.offer(start);
        visited[start.r][start.c] = true;
        
        while (!q.isEmpty()) {
            Point p = q.poll();
            
            // 목적지 (레버 or 출구) 도착
            if (p.r == goal.r && p.c == goal.c) {
                return p.depth;
            }
            
            // 다음 이동 포인트 저장
            for (int i = 0; i < 4; i++) {
                int nextR = p.r + move[i][0];
                int nextC = p.c + move[i][1];
                
                if (nextR < 0 || nextC < 0 || nextR >= n || nextC >= m) continue; 
                if (visited[nextR][nextC] || maps[nextR].charAt(nextC) == 'X') continue;
                
                q.offer(new Point(nextR, nextC, p.depth + 1));
                visited[nextR][nextC] = true;
            }
        }
        
        // 목적지에 도달할 수 없는 경우
        return -1;
    }
}

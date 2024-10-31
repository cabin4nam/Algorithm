
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    private static class Point{
        int r;
        int c;
        int depth;
        public Point(int r, int c, int depth){
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }
    private static int[][] move = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    private static int n; //세로
    private static int m; // 가로
    public int solution(int[][] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length;
        
        return bfs(maps, 0, 0);
    }
    
    public int bfs(int[][] maps, int startR, int startC){
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        q.offer(new Point(startR, startC, 1));
        visited[startR][startC] = true;
        
        while(!q.isEmpty()){
            Point p = q.poll();
            
            if(p.r == n-1 && p.c == m-1) return p.depth;
            
            for(int i=0; i<4; i++){
                int nextR = p.r + move[i][0];
                int nextC = p.c + move[i][1];
                
                if(nextR < 0 || nextC < 0 || nextR >= n || nextC >= m) continue;
                if(visited[nextR][nextC]) continue;
                
                if(maps[nextR][nextC] == 1){
                    q.offer(new Point(nextR, nextC, p.depth+1));
                    visited[nextR][nextC] = true;
                }
            }
        }
        
        return -1;
    } 
}
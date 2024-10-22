import java.util.*;

class Solution {
    private static int R;
    private static int C;
    private static class Point{
        int r;
        int c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    private static boolean[][] visited;
    private static int[][] move = {{-1,0}, {1,0} , {0,-1}, {0,1}};
    private static int[] oil;
    public int solution(int[][] land) {
        int answer = Integer.MIN_VALUE;
        
        // 1. dfs를 통해 석유가 모여 있는 곳의 count 세기
        // 2. dfs로 거친 포인트들을 list에 저장
        // 3. list에 있는 포인트들의 수를 count로 변경
        R = land.length;
        C = land[0].length;
        
        oil = new int[C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (land[i][j] == 1 && visited[i][j] == false) {
                    bfs(land, i, j);
                }
            }
        }
        
        answer = Arrays.stream(oil).max().getAsInt();
        
        return answer;
    }
    
    public int bfs(int[][] land, int r, int c){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(r,c));
        visited[r][c] = true;
        
        // 석유 덩어리 개수
        int count = 1;
        // 석유 덩어리의 열 위치 저장
        Set<Integer> set = new HashSet<>();
        
        while(!q.isEmpty()){
            Point p = q.poll();
            set.add(p.c);
            
            for(int i=0; i<4; i++){
                int nextR = p.r + move[i][0];
                int nextC = p.c + move[i][1];
                
                if(nextR < 0 || nextC < 0 || nextR >= R || nextC >= C) continue;
                if(visited[nextR][nextC]) continue;
                
                if(land[nextR][nextC] > 0){
                    q.offer(new Point(nextR, nextC));
                    visited[nextR][nextC] = true;
                    count ++;
                }
            }
        }
        
        for(int i : set) oil[i] += count; 
        
        return count;
    }
   
}
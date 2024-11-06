import java.util.*;
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
    private static int[][] move = {{0,-1}, {0,1}, {-1,0}, {1,0}};
    private static boolean checked = true;
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);
        
        for(int i=0; i<places.length; i++){
            boolean isValid = true;
            for(int r=0; r<5; r++){
                for(int c=0; c<5; c++){
                    if(places[i][r].charAt(c)=='P'){
                        if (!check(places[i], r, c)) {
                            answer[i] = 0;
                            isValid = false;
                        }
                    }
                }
                if(!checked) break;
            }
        }
        
        return answer;
    }
    
    
    private static boolean check(String[] room, int r, int c){
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        q.offer(new Point(r, c, 0));
        visited[r][c] = true;
        
        while(!q.isEmpty()){
            Point p = q.poll();
            
            if(p.depth == 2) continue;
            if(room[p.r].charAt(p.c) == 'X') continue;
            
            for(int i=0; i<4; i++){
                int nr = p.r + move[i][0];
                int nc = p.c + move[i][1];
                
                if(nr >= 5 || nc >= 5 || nr < 0 || nc < 0) continue;
                if(visited[nr][nc]) continue;
                
                if(room[nr].charAt(nc)=='P') return false;
                
                q.offer(new Point(nr,nc, p.depth+1));
                visited[nr][nc] = true;
            }
            
        }
        
        return true;
    }
}
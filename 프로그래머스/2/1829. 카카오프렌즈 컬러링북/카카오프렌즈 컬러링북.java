/**
- 그림의 난이도 = 영역의 수 (상하좌우로 연결된 같은 색상의 공간)
**/
import java.util.*;
class Solution {
    private class Point{
        int r;
        int c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    private static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j]) continue;
                if(picture[i][j] == 0) continue;
                
                numberOfArea ++;
                
                int sum = 0;
                int color = picture[i][j];
                Queue<Point> q = new LinkedList<>();
                q.offer(new Point(i, j));
                visited[i][j] = true;
            
                while(!q.isEmpty()){
                    Point p = q.poll();
        
                    sum ++;
                    
                    for(int d=0; d<4; d++){
                        int nextR = p.r + move[d][0];
                        int nextC = p.c + move[d][1];
                        
                        
                        if(nextR < 0 || nextC < 0 || nextR >= m || nextC >= n) continue;
                        if(visited[nextR][nextC]) continue;
                        
                        if(picture[nextR][nextC] == color){
                            q.offer(new Point(nextR, nextC));
                            visited[nextR][nextC] = true;
                        }
                    }
                }
                
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sum);
            }
        }
        
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
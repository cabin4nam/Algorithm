// 시작 위치에서 목표 위치까지 최소 몇번만에 돧ㄹ?
// 4방향 중 하나를 선택 -> 장애물 or 맨 끝에 부딪힐 때까지 미끄러지는 것을 한 번의 이동으로

// . : 빈공간, D : 장애물, G : 목표지점
import java.util.*;

class Solution {
    static class Point{
        int r;
        int c;
        int depth;
        
        public Point(int r, int c, int depth){
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }
    private static int[][] move = new int[][]{{-1,0},{1,0}, {0, -1}, {0,1}};
    private static int n; // 세로 길이
    private static int m; // 가로 길이
    public int solution(String[] boardStr) {
        int answer = 0;
        
        n = boardStr.length;
        m = boardStr[0].length();
        
        // 현재 로봇의 위치 저장
        String[][] board = new String[n][m];
        
        Point robot = new Point(-1, -1, 0);
        Point destination = new Point(-1, -1, -1);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                board[i][j] = boardStr[i].substring(j, j+1);
                
                if(board[i][j].equals("R")){
                    robot.r = i;
                    robot.c = j;
                }
                
                if(board[i][j].equals("G")){
                    destination.r = i;
                    destination.c = j;
                }
            }
        }
        
        for(int k=0; k<n; k++){
                    System.out.println();
                    for(int j = 0; j<m ; j++){
                        System.out.print(board[k][j] + " ");
                    }
                }
                System.out.println();
        
        boolean[][] visited = new boolean[n][m];
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(robot);
        
        while(!queue.isEmpty()){
            // 현재 위치
            Point prePoint = queue.poll();
            
            if(visited[prePoint.r][prePoint.c]) continue;
            
            visited[prePoint.r][prePoint.c] = true;
            
            System.out.println(" =========================== ");
            System.out.println("현재 : " + prePoint.r + " // " + prePoint.c);
            
            if(prePoint.r == destination.r && prePoint.c == destination.c) {
                return prePoint.depth;
            }
            
            // 다음 위치까지 이동
            for(int i=0; i<4; i++){
                int nextR = prePoint.r;
                int nextC = prePoint.c;
                
                while (inRange(nextR, nextC) && !board[nextR][nextC].equals("D")) {
                    nextR += move[i][0];
                    nextC += move[i][1];
                }
                
                nextR -= move[i][0];
                nextC -= move[i][1];
                
                if (visited[nextR][nextC] || (prePoint.r == nextR && prePoint.c == nextC)) continue;
            
                queue.add(new Point(nextR, nextC, prePoint.depth + 1));
            }
            
        }
        
        return -1;
        
    }
    
    private boolean inRange(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }
}
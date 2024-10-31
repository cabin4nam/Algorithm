// import java.util.Queue;
// import java.util.LinkedList;
// class Solution {
//     private static class Point{
//         int r;
//         int c;
//         int depth;
//         public Point(int r, int c, int depth){
//             this.r = r;
//             this.c = c;
//             this.depth = depth;
//         }
//     }
//     private static int[][] move = {{-1,0}, {1,0},{0,-1}, {0,1}};
//     public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
//         int answer = 0;
        
//         int[][] map = new int[50][50];
        
//         // map초기화 (직사각형들을 돌면서 이동가능한 경로를 1로 표시)
//         for(int i=0; i<rectangle.length; i++){
//             int startR = rectangle[i][1];
//             int endR = rectangle[i][3];
//             int startC = rectangle[i][0];
//             int endC = rectangle[i][2];
            
//             for(int x = startR; x<=endR; x++){
//                 for(int y=startC; y<=endC; y++){
//                     // 테두리를 1로 설정 (-1이면 건들지 않기) 
//                     if(x==startR || x==endR || y==startC || y==endC){
//                         if(map[x][y]!=-1) map[x][y] = 1;
//                     }
                    
//                     // 사각형 안쪽은 무조건 -1로 변경
//                     else {
//                         map[x][y] = -1;
//                     }
//                 }
//             }
//         }
        
//         // 경로에 맞게 시작점에서 item까지 이동가능한 최단 경로 구하기 (bfs)
//         answer = bfs(map, characterX, characterY, itemX, itemY);
        
//         return answer;
//     }
    
//     private static int bfs(int[][] map, int startC, int startR, int goalC, int goalR){
//         Queue<Point> q = new LinkedList<>();
//         boolean[][] visited = new boolean[map.length][map[0].length];
//         q.offer(new Point(startR, startC, 0));
//         visited[startR][startC] = true;
        
//         while(!q.isEmpty()){
//             Point p = q.poll();
            
//             if(p.r == goalR && p.c == goalC) return p.depth;
            
//             for(int i=0; i<4; i++){
//                 int nextR = p.r + move[i][0];
//                 int nextC = p.c + move[i][1];
                
//                 if(nextR < 0 || nextC < 0 || nextR >= map.length || nextC >= map[0].length) continue;
//                 if(visited[nextR][nextC]) continue;
                
//                 if(map[nextR][nextC]==1){
//                     q.offer(new Point(nextR, nextC, p.depth+1));
//                     visited[nextR][nextC] = true;
//                 }
//             }
//         }
        
//         return 0;
        
//    }
//}


// 정답
import java.util.Queue;
import java.util.LinkedList;
class Solution {
    private static class Point{
        int x;
        int y;
        int depth;
        public Point(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
    private static int[][] move = {{-1,0}, {1,0},{0,-1}, {0,1}};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        int[][] map = new int[101][101];
        
        // map초기화 (직사각형들을 돌면서 이동가능한 경로를 1로 표시)
        for(int i=0; i<rectangle.length; i++){
            int startY = rectangle[i][1]*2;
            int endY = rectangle[i][3]*2;
            int startX = rectangle[i][0]*2;
            int endX = rectangle[i][2]*2;
            
            for(int x = startX; x<=endX; x++){
                for(int y=startY; y<=endY; y++){
                    // 테두리를 2로 설정 (2이면 건들지 않기) 
                    if(x==startX || x==endX || y==startY || y==endY){
                        if(map[x][y]!=2) map[x][y] = 1;
                    }
                    
                    // 사각형 안쪽은 무조건 2로 변경
                    else {
                        map[x][y] = 2;
                    }
                }
            }
        }

        // 경로에 맞게 시작점에서 item까지 이동가능한 최단 경로 구하기 (bfs)
        answer = bfs(map, characterX*2, characterY*2, itemX*2, itemY*2);
        
        return answer;
    }
    
    private static int bfs(int[][] map, int startX, int startY, int itemX, int itemY){
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[101][101];
        q.offer(new Point(startX, startY, 0));
        visited[startX][startY] = true;
        
        while(!q.isEmpty()){
            Point p = q.poll();
            
            if(p.x == itemX && p.y == itemY) return p.depth/2;
            
            for(int i=0; i<4; i++){
                int nextX = p.x + move[i][0];
                int nextY = p.y + move[i][1];
                
                if(nextX < 0 || nextY < 0 || nextX > 100 || nextY > 100) continue;
                if(visited[nextX][nextY]) continue;
                
                if(map[nextX][nextY]==1){
                    q.offer(new Point(nextX, nextY, p.depth+1));
                    visited[nextX][nextY] = true;
                }
            }
        }
        
        return 0;
        
    }
}
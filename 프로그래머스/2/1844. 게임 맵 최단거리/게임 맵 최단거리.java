import java.lang.*; 
import java.util.*;

class Solution {
    // 상하좌우로 움직이기 용이하도록 설정한 값
    static int[] move_y = {-1, 1, 0, 0};
    static int[] move_x = {0, 0, -1, 1};
    
    static boolean[][] visited;
    static int minCost = Integer.MAX_VALUE;
    static boolean canArrive = false;
    public int solution(int[][] maps) {
        int answer = 0;
        
        // 0,0 부터 n-1, m-1 까지
        
        int n = maps.length;
        int m = maps[0].length;
        
        visited = new boolean[n][m];
        
        bfs(maps, 0, 0);
        
        if(!canArrive) return -1;
        
        return minCost;
    }

    
    public void bfs(int[][] maps, int start_y, int start_x){
        Queue<Node> q = new LinkedList<>();
        
        q.add(new Node(0,0,1));
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            Node currentNode = q.poll();
            
            if(currentNode.y == maps.length-1 && currentNode.x == maps[0].length-1){
                canArrive = true;
                minCost = currentNode.count;
                return;
            }
            
            for(int i=0; i<4; i++){
                int next_y = currentNode.y + move_y[i];
                int next_x = currentNode.x + move_x[i];
                
                if(canMove(next_y, next_x, maps)){
                    visited[next_y][next_x] = true;
                    q.add(new Node(next_y, next_x, currentNode.count+1));
                }
            }
        }
    }
    
    public boolean canMove(int row, int col, int[][] maps) {
        return row >= 0 && row < visited.length && col >= 0 && col < visited[0].length
                    && !visited[row][col] && maps[row][col] != 0;
    }
    
     class Node {
        int y;
        int x;
        int count;
        
        public Node(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
}
import java.util.*;
class Solution {
    private static int[][] map;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        // 인접 행렬을 활용하여 전선 표현
        map = new int[n+1][n+1];
        for(int[] wire : wires){
            int w1 = wire[0];
            int w2 = wire[1];
            
            map[w1][w2] = 1;
            map[w2][w1] = 1;
        }
        
        // 전선을 하나씩 끊어보면서 송신탑 개수 차이가 적은 것 찾기
        for(int[] wire : wires){
            int w1 = wire[0];
            int w2 = wire[1];
            
            // 전선 자르기
            map[w1][w2] = 0;
            map[w2][w1] = 0;
            
            int c1 = count(w1, n);
            int c2 = count(w2, n);
            
            answer = Math.min(answer, Math.abs(c1-c2));
            
            // 전선 원상복구
            map[w1][w2] = 1;
            map[w2][w1] = 1;
            
            
        }
        
        return answer;
    }
    
    private static int count(int start, int n){
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int i=1; i<=n; i++){
                if(map[now][i]==1 && !visited[i]){
                    q.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
        
        return count;
    }
}